package com.board.icia.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dao.IBoardDao;
import com.board.icia.dto.Board;


@Service
public class BoardManagement {
	@Autowired
	private IBoardDao bDao;
	ModelAndView mav;
	public ModelAndView getBoardList(Integer pageNum, HttpServletRequest req) { 
		mav=new ModelAndView();
		String view = null;
		List<Board> bList = null;
		int pNum = (pageNum==null)? 1 : pageNum;
		System.out.println("pNum="+pNum);
		//if(req.getSession().getAttribute("id")!=null) {
			bList=bDao.getBoardList(pNum);
			if(bList!=null) {
				mav.addObject("bList",bList);
				view = "boardList";
			}	
		else {
			view ="home";
		}
		mav.setViewName(view); //jsp
		return mav;
	}
	public ModelAndView getContents(Integer bNum, HttpServletRequest req) {
		mav=new ModelAndView();
		String view=null;
		//if(req.getSession().getAttribute("id")!=null) {
			view="boardList";
		//}else {
		//	view = "home";
		//}
		mav.setViewName(view);
		return mav;
	}
}
