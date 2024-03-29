package com.icia.www;


import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		logger.info("Welcome home!");

//		MemberMM mm=new MemberMM();
//		mm.access(id,pw);
		//일반적으로 서비스 클래스 생성
		ModelAndView mav=new ModelAndView();
		mav.addObject("result","loginOK");
		//String sleep = std.sleep();
		//mav.addObject("sleep", sleep);
		//mav.setViewName("home");
		//model.addAttribute("result","loginOK");
		
		return null;  //home.jsp로 이동
	}
	
}
