package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import source.MemberRegisterService;
import source.RegisterRequest;

@Controller
public class RegisterController {
		@Autowired
		private MemberRegisterService rgs;
		
		public void setMemberRegisterService(MemberRegisterService rgs) {
			this.rgs = rgs;
		}

		@GetMapping("/register/step1")
		public String handleStep1() {
			return "register/step1";
		}
		
		@RequestMapping("/register/step2")
		public String handleStep2(Model model,@RequestParam(name = "agree", defaultValue = "false")Boolean agree, @RequestParam(name="disagree", defaultValue = "false")Boolean disagree) {
			if(disagree) {
				model.addAttribute("force", "회원가입에 동의가 필요합니다.");
				return "register/step1";
			}
			else if(agree){
				return "register/step2";
			}
			else {
				model.addAttribute("force", "회원가입에 동의가 필요합니다.");
				return "register/step1";
			}
		}
		
		@RequestMapping("/register/step3")
		public String handleStep3(RegisterRequest req) {
			try {
			rgs.regist(req);
			return "register/step3";
			
			}catch (exception.DuplicateMemberException e) {
				return "register/step2";
			}
		}
}
