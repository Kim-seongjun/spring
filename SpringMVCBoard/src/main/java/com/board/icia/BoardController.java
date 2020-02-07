package com.board.icia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.icia.service.BoardManagement;

@Controller
public class BoardController {
	@Autowired
	private BoardManagement bm; //게시판 서비스 클래스
	
	ModelAndView mav;
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView boardList(Integer pageNum) { //null
		mav = bm.getBoardList(pageNum);
		//mav = bm.getMemberlist();
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
//	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)//method = RequestMethod.GET생략시 GET,POST 모두가능
//	public ModelAndView memberlist(Integer mNum) { //null
//		System.out.println("여긴오니1");
//		mav = bm.getMemberlist(mNum);
//		//attr.addFlashAttribute("bNum",bNum);
//		System.out.println("여기오니3");
//		return mav;
//	}
}
