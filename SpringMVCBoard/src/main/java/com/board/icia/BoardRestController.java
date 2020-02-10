package com.board.icia;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.board.icia.dto.Board;
import com.board.icia.dto.Reply;
import com.board.icia.service.BoardManagement;
import com.google.gson.Gson;

import lombok.Setter;

//@Controller
@RestController
@RequestMapping(value="/rest")
public class BoardRestController {
	//@Setter(onMethod = @Autowired)
	@Autowired
	private BoardManagement bm;
	
	ModelAndView mav;
	
	//Gson 활용
//	@RequestMapping(value="/replyinsert",produces = "application/json;charset=utf8")
	
//	public @ResponseBody String replyInsert(Reply r,HttpServletRequest req) {
//		System.out.println("r_bnum="+r.getR_bnum());
//		System.out.println("r_con="+r.getR_contents());
//		r.setR_id(req.getSession().getAttribute("id").toString());
//		String json = bm.replyInsert(r);
//		//String json = new Gson().toJson(r);
//		return json;
//		
//		//서블릿에서 사용 하던 방식을 @ResponseBody가 대신함
//		//PrinWriter out=res.getWriter();
//		//out.print(json);
//		
//		
//	}

	
	//jackson 활용
	@RequestMapping(value="/replyinsert",produces = "application/json;charset=utf8")
	
	public @ResponseBody Map<String,List<Reply>> replyInsert(Reply r,HttpServletRequest req) {
		r.setR_id(req.getSession().getAttribute("id").toString());
		Map<String,List<Reply>> rMap =bm.replyInsertJackSon(r);
		
		return rMap;
		
	}

//	@PostMapping(value="/boardwrite")
//	public String boardWrite(Board board, List<MultipartFile> files) {
//		//파일태그명과 일치
//		System.out.println("title="+board.getB_title());
//		System.out.println("file="+files.get(0).getOriginalFilename());
//		System.out.println("file="+files.get(1).getOriginalFilename());
//		
//		return new Gson().toJson(files);
//		
//	}
	@PostMapping(value="/boardwrite")
	public String boardWrite(MultipartHttpServletRequest multi) {
		//파일태그명과 일치
		System.out.println("title="+multi.getParameter("b_title"));
		System.out.println("fileCheck="+multi.getParameter("fileCheck"));
		List<MultipartFile> files = multi.getFiles("files");
		System.out.println("file="+files.get(0).getOriginalFilename());
		System.out.println("file="+files.get(1).getOriginalFilename());
		
		return new Gson().toJson(files);
		
	}
}
