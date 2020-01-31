package com.board.icia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dto.Member;
import com.board.icia.service.MemberManagement;

@Controller
public class HomeController {

	@Autowired
	private MemberManagement mm; // 회원관리 서비스 (BL)

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private ModelAndView mav;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.info("로그인화면으로 이동");
		mav = new ModelAndView();
		mav.setViewName("home"); // 로그인 화면
		
		return mav;
	}
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public ModelAndView access(Member mb) {
		logger.info("로그인화면으로 이동");
		mav = mm.memberAccess(mb);
		//logger.info("id="+mb.getM_id());
		System.out.println("id="+mb.getM_id());
		//logger.info("id="+mb.getM_pwd());
		System.out.println("pw="+mb.getM_pwd());
		//mav.setViewName("home"); // 로그인 화면
		return mav;
	}
	@RequestMapping(value = "/joinfrm", method = RequestMethod.GET)
	public ModelAndView joinFrm() {
		mav=new ModelAndView();
		mav.setViewName("joinFrm"); //jsp
		return mav;
	}
	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public ModelAndView memberjoin(Member mb) {
		mav=mm.memberjoin(mb);
		return mav;
	} 
}//Con End