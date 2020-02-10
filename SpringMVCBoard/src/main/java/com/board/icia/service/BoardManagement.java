package com.board.icia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.dao.IBoardDao;
import com.board.icia.dto.Board;
import com.board.icia.dto.Member;
import com.board.icia.dto.Reply;
import com.board.icia.userClass.DbException;
import com.board.icia.userClass.Paging;
import com.board.icia.userClass.UploadFile;
import com.google.gson.Gson;

@Service
public class BoardManagement {
	@Autowired
	private IBoardDao bDao;
	@Autowired
	private UploadFile upload;
	ModelAndView mav;

	public ModelAndView getBoardList(Integer pageNum) {
		mav = new ModelAndView();
		String view = null;
		List<Board> bList = null;
		int pNum = (pageNum == null) ? 1 : pageNum;
		System.out.println("pNum=" + pNum);
		// if(req.getSession().getAttribute("id")!=null) {
		bList = bDao.getBoardList(pNum);

		if (bList != null) {
			mav.addObject("bList", bList);
			mav.addObject("paging", getPaging(pNum));
			view = "boardList"; //jsp
		} else {
			view = "home";
		}
		mav.setViewName(view); // jsp
		return mav;
	}

	private String getPaging(int pNum) {
		int maxNum = bDao.getBoardCount(); // 전체 글의 개수
		int listCount = 10; // 10 // 페이지당 나타낼 글의 갯수
		int pageCount = 2; // 2 // 페이지그룹당 페이지 갯수
		String boardName = "boardlist"; // 게시판의 종류(게시판이 여러개일때 url)
		Paging paging = new Paging(maxNum, pNum, listCount, pageCount, boardName);
		return paging.makeHtmlPaging();
	}

	public ModelAndView getContents(Integer bNum) {
		mav = new ModelAndView();
		String view = null;
		// if(req.getSession().getAttribute("id")!=null) {
		Board board = bDao.getContents(bNum);
		mav.addObject("board", board);

		List<Reply> rList = bDao.getReplyList(bNum);
		mav.addObject("rList", rList);
		view = "boardContentsAjax"; // jsp

		mav.setViewName(view);
		return mav;
	}

//	public String replyInsert(Reply r) {
//		String json = null;
//		   if(bDao.replyInsert(r)) {
//		         List<Reply> rList=bDao.getReplyList(r.getR_bnum());
//		        // json=new Gson().toJson(rList);
//		        // System.out.println("json="+json);
//		      }
//		      else {
//		         //json=null;
//		      }
//		      return json;
//		   }

	public Map<String, List<Reply>> replyInsertJackSon(Reply r) {
		Map<String, List<Reply>> rMap = null;
		if (bDao.replyInsert(r)) {
			List<Reply> rList = bDao.getReplyList(r.getR_bnum());
			rMap = new HashMap<String, List<Reply>>();
			rMap.put("rList", rList);
			System.out.println("rMap=" + rMap);
		} else {
			rMap = null;
		}
		return rMap;
	}

	// RedirectAttributes는 Redirect전 session영역에 저장한 뒤 redirect 후 즉시 삭제
	// 삭제직전 session영역에 저장했던 데이터는 request객체에 저장한다.
	// addFlashAttribute :post방식(session에 저장후 1번 사용하면 삭제함)
	// attr.addAttribute : get방식 (session에 저장후 request객체에 저장 후 삭제함)
	@Transactional
	public ModelAndView boardDelete(Integer bNum, RedirectAttributes attr) { // 삭제 트랜젝션 (댓글,내용 삭제)
		System.out.println("bNum=" + bNum);
		mav = new ModelAndView();
		boolean r = bDao.replyDelete(bNum);
		boolean a = bDao.aticleDelete(bNum);

		if (a == false) { // 0개 원글을 삭제한 경우 예외발생시켜서 롤백
			throw new DbException();
		}
		if (r && a) {
			System.out.println("삭제 트랜젝션 성공");
			attr.addFlashAttribute("bNum", bNum); // post방식
			// attr.addAttribute("bNum",bNum); //get방식
		} else {
			System.out.println("삭제 트랜잭션 실패");
		}

		mav.setViewName("redirect:boardlist"); // 새로운 요청으로 boardlist로 이동
		return mav;
	}

	public ModelAndView getMemberlist() {
		mav = new ModelAndView();
		String view = null;
		List<Member> mList = null;
		// int memNum = (mNum == null) ? 1 : mNum;
		// System.out.println("memNum=" + memNum);
		// if(req.getSession().getAttribute("id")!=null) {
		mList = bDao.getMemberList();
		System.out.println("보드서비스 맴버리스트");
		System.out.println("mList="+mList.get(0).getM_id());
		if (mList != null) {
			mav.addObject("mList", mList);
			view = "boardList";
		} 
//		else {
//			view = "home";
//		}
		mav.setViewName(view); // jsp
		return mav;
	}

	@Transactional
	public ModelAndView boardwrite(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		System.out.println("서비스11111");
		String view = null;
		String title = multi.getParameter("b_title");
		String contents = multi.getParameter("b_contents");
		int check = Integer.parseInt(multi.getParameter("fileCheck"));
		String id = multi.getSession().getAttribute("id").toString();
		System.out.println("서비스");
		System.out.println("check=" + check); // 첨부1
		System.out.println("id=" + id);

		Board board = new Board();
		board.setB_title(title).setB_contents(contents).setB_id(id);
		boolean b = bDao.boardWrite(board); //100

		if (b) { // 글쓰기 성공
			view = "redirect:/boardlist";
		} else {
			view = "writeFrm";// jsp
		}

		boolean f = false;
		if (check == 1) { // 첨부파일 여부
			int bnum = bDao.getCurBoardNum(); // 현재 글 번호
			f = upload.fileUp(multi, board.getB_num());

			if (f) {
				view = "redirect:/boardlist"; // url
			} else {
				view = "writeFrm";// jsp
			}

			mav.setViewName(view);

		}
		return mav;
	}

}
