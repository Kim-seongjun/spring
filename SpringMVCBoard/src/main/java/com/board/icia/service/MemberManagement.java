package com.board.icia.service;
//회원관리 서비스 클래스(model)

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dto.Member;
import com.board.icia.exception.IdCheckException;

//@Component
@Service
public class MemberManagement {
	@Autowired
	private IMemberDao mDao;

	private ModelAndView mav;

	private void HashMapTest(String id, String pwd) {
		Map<String, String> hMap = new HashMap<>();
		hMap.put("id", id);
		hMap.put("pw", pwd);
		boolean result = mDao.hashMapTest(hMap);
		System.out.println("result=" + result); // 로그인 성공(true), 실패:false
		hMap = mDao.hashMapTest2(id);
		System.out.println("name=" + hMap.get(id));
	}

	public ModelAndView memberAccess(Member mb, HttpServletRequest req) {
		mav = new ModelAndView();
		String view = null;
		// 스프링에선 복호화 메소드 없음.
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String pwdEncode = mDao.getSecurityPwd(mb.getM_id());
		System.out.println("pw=" + pwdEncode);

		// hashMap 로그인 테스트
		HashMapTest(mb.getM_id(), pwdEncode);

		if (pwdEncode != null) {
			if (pwdEncoder.matches(mb.getM_pwd(), pwdEncode)) { // 비교
				// 로그인 성공
				HttpSession session = req.getSession();
				session.setAttribute("id", mb.getM_id());
				// 로그인 후 회원정보를 화면 출력하기 위해
				mb = mDao.getMemberInfo(mb.getM_id());

				session.setAttribute("mb", mb); //세션에 회원정보 저장

				// mav.addObject("mb", mb); //request영역에 모델객체 저장
				// view = "boardList"; // jsp
				// view = "forward:/boardList"; //forward:url
				view = "redirect:/boardlist"; // redirect:url, POST,GET -->
			} else { // 비번오류
				view = "home";

				mav.addObject("check", 2); // 로그인 실패
			}
		} else { // 아이디가 오류시
			view = "home";
			mav.addObject("check", 2); // 로그인 실패
		}
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView memberjoin(Member mb) {
		mav = new ModelAndView();
		String view = null;
		// Encoder(암호화) <-->Decoder(복구화)
		// 스프링은 암호화는 가능하지만 복구가안됨
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		// 비번만 암호화해서 DB저장
		mb.setM_pwd(pwdEncoder.encode(mb.getM_pwd()));
		if (mDao.memberJoin(mb)) {
			view = "home"; // 회원가입 성공시 로그인
			mav.addObject("check", 1); // 성공
		} else {
			view = "joinFrm"; // 회원가입 실패시
		}
		mav.setViewName(view);
		return mav;
	}

//	public boolean idAvailable(String m_id) {
//		Member mb = mDao.getMemberInfo(m_id);
//		if (mb == null)
//			return true; //아이디를 사용할수 있다.
//		else
//			return false; //아이디를 사용할수 없다.
//	}
	public String idAvailable(String m_id) {
		Member mb = mDao.getMemberInfo(m_id);
		if (mb != null)
			throw new IdCheckException("사용불가 아이디입니다.");
		
		return "사용가능한 아이디입니다.";
	}

	
}// Class End