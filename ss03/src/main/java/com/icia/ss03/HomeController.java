package com.icia.ss03;

import org.springframework.security.access.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PreAuthorize("isAnonymous()")
	@GetMapping("/system/login")
	public String loginForm() {
		return "login";
	}
	
	@PreAuthorize("isAnonymous()")
	@GetMapping("/guest/list")
	public String guest() {
		return "guest";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/list")
	public String user() {
		return "user";
	}
	
	@Secured({"ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN"})
	@GetMapping("/member/list")
	public String member() {
		return "member";
	}
	
	@Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
	@GetMapping("/manager/list")
	public String manager() {
		return "manager";
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/list")
	public String admin() {
		return "admin";
	}
}