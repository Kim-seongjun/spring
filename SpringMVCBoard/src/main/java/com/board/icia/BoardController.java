package com.board.icia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.service.BoardManagement;

@Controller
public class BoardController {
	@Autowired
	private BoardManagement bm; //게시판 서비스 클래스
	
	ModelAndView mav;
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView boardList(Integer pageNum) { //null
		mav = bm.getBoardList(pageNum);
		return mav;
	}
	@RequestMapping(value = "/contents", method = RequestMethod.GET)//method = RequestMethod.GET생략시 GET,POST 모두가능
	public ModelAndView contents(Integer bNum) { //null
		mav = bm.getContents(bNum);
		return mav;
	}

}
