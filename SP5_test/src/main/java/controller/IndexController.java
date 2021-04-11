package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model, @RequestParam(value= "id", required = false) String id) {
		model.addAttribute("id",id);
		return "index";
	}
	
}
