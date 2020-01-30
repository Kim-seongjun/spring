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
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   private MemberManagement mm;
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView home() {
      
      ModelAndView mav=mm.access();
      return mav;
   }
   
}