package spring.boot.mvcdemo.web.ctrl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/page")
public class PageTestCtrl {
	@Value("${application.message:test}")
	private String message = "Hello World";
	
	@RequestMapping(value = "test/jsp", method = RequestMethod.GET)
	public ModelAndView testJsp() {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("message",message);
		return mv;
	}
	
	@RequestMapping("test/html")
	public String testHtml(Map<String, Object> model) {
		return "/templates/test.html";
	}
}
