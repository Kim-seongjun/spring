package com.board.icia;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.service.BoardManagement;
import com.board.icia.service.MemberManagement;
import com.board.icia.userClass.FileManager;

@Controller
public class BoardController {
	@Autowired
	private BoardManagement bm; //게시판 서비스 클래스
	
	ModelAndView mav;
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView boardList(Integer pageNum) { //null
		mav = bm.getBoardList(pageNum);
		//mav = mm.getMemberlist();
		return mav;
	}
	@RequestMapping(value = "/contents")//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView contents(Integer bNum) { //null
		mav = bm.getContents(bNum);
		return mav;
	}
	@RequestMapping(value = "/boarddelete")//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView boarddelete(Integer bNum,RedirectAttributes attr) { //null
		mav = bm.boardDelete(bNum,attr);
		//attr.addFlashAttribute("bNum",bNum);
		return mav;
	}
	@RequestMapping(value = "/writefrm")//method = RequestMethod.GET생략시 GET,POST 모두가능
	public String writefrm() { //null
		return "writefrm";
	}
	@RequestMapping(value = "/memberlist")//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView memberlist() { //null
		System.out.println("보드컨트룰러 맴버리스트");
		mav = bm.getMemberlist();
		//attr.addFlashAttribute("bNum",bNum);
		return mav;
	}
	@GetMapping(value = "/writefrm")
	public String writeFrm() {
		return "writefrm"; //jsp
	}
	@PostMapping(value = "/boardwrite")
	public ModelAndView writeWrite(MultipartHttpServletRequest multi) {
//		mav = new ModelAndView();
//		System.out.println("title="+multi.getParameter("b_title"));
//		System.out.println("fileCheck="+multi.getParameter("fileCheck"));
//		List<MultipartFile> files = multi.getFiles("files");
//		System.out.println("file="+files.get(0).getOriginalFilename());
//		System.out.println("file="+files.get(1).getOriginalFilename());
		//1개의 file Tag를 이용해서 여러파일을 첨부할 때
//		List<MultipartFile> file = multi.getFiles("files");
//		System.out.println("파일개수="+file.size());
//		for(int i =0;i<file.size();i++) {
//			String f = file.get(i).getOriginalFilename();
//			System.out.println("file="+f);
//		}
		System.out.println("컨트롤러");
		mav = new ModelAndView();
		mav = bm.boardwrite(multi);
		
		return mav;
	}
	@RequestMapping(value="/download")
    public void download(String sysFileName,HttpServletResponse resp) {
       String full="E:/springwork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCBoard/upload/"+sysFileName;
       
       FileManager d=new FileManager();
       try {
          d.download(full, sysFileName, resp);
       } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
    
    }
	@GetMapping(value = "/test")
	public ModelAndView myBatisTest(String cName, Integer search) {
		mav = bm.myBatisTest(cName,search);
		return mav;
	}
}
