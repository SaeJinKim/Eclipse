package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.MemberNotFoundException;
import source.LoginRequest;
import source.Member;
import source.MemberLoginService;

@Controller
public class LoginController {
	
	@Autowired
	MemberLoginService mls;
	
	public LoginController() {
	}
	
	public LoginController(MemberLoginService mls) {
		this.mls = mls;
	}
	
	@RequestMapping("/login")
	public String form(@Valid LoginRequest loginRequest,Errors errors, @CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginRequest.setEmail(rCookie.getValue());
			loginRequest.setCheck(true);
		}
		
		return "logins/login";
	}
	
	
	@RequestMapping("/access")
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session, HttpServletResponse response) {
		try {
			Member member = mls.login(loginRequest);
			loginRequest.setName(member.getName());
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginRequest.getEmail());
			rememberCookie.setPath("/");
			
			if (loginRequest.isCheck()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			}
		}catch(MemberNotFoundException e) {
			
			Cookie rememberCookie = new Cookie("REMEMBER", "");
			rememberCookie.setMaxAge(0);

			return "redirect:login";
		}
		
		return "logins/success";
	}
	
}
