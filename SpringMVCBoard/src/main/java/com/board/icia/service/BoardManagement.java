package com.board.icia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.board.icia.dao.IBoardDao;
import com.board.icia.dto.Board;
import com.board.icia.dto.Reply;
import com.board.icia.userClass.Paging;
import com.google.gson.Gson;

@Service
public class BoardManagement {
	@Autowired
	private IBoardDao bDao;
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
			mav.addObject("paging",getPaging(pNum));
			view = "boardList";
		} else {
			view = "home";
		}
		mav.setViewName(view); // jsp
		return mav;
	}

	private String getPaging(int pNum) {
		int maxNum=bDao.getBoardCount();       // 전체 글의 개수
        int listCount=10; //10      // 페이지당 나타낼 글의 갯수
        int pageCount=2; //2      // 페이지그룹당 페이지 갯수
        String boardName="boardlist";    // 게시판의 종류(게시판이 여러개일때 url)
        Paging paging=new Paging(maxNum,pNum,listCount,pageCount,boardName);
    return paging.makeHtmlPaging();
	}

	public ModelAndView getContents(Integer bNum) {
		mav = new ModelAndView();
		String view = null;
		// if(req.getSession().getAttribute("id")!=null) {
		Board board = bDao.getContents(bNum);
		mav.addObject("board",board);
		
		List<Reply> rList = bDao.getReplyList(bNum);
		mav.addObject("rList",rList);
		view = "boardContentsAjax"; //jsp
		
		mav.setViewName(view);
		return mav;
	}

	public String replyInsert(Reply r) {
		String json = null;
		   if(bDao.replyInsert(r)) {
		         List<Reply> rList=bDao.getReplyList(r.getR_bnum());
		         json=new Gson().toJson(rList);
		         System.out.println("json="+json);
		      }
		      else {
		         json=null;
		      }
		      return json;
		   }

	public Map<String, List<Reply>> replyInsertJackSon(Reply r) {
		Map<String, List<Reply>> rMap = null;
		if(bDao.replyInsert(r)) {
			List<Reply> rList = bDao.getReplyList(r.getR_bnum());
			rMap = new HashMap<String, List<Reply>>();
			rMap.put("rList", rList);
			System.out.println("rMap="+rMap);
		}else {
			rMap=null;
		}
		return rMap;
	}
	

}
