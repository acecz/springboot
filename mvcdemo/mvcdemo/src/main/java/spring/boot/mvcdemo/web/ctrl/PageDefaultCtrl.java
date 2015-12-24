package spring.boot.mvcdemo.web.ctrl;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageDefaultCtrl {
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "index";
	}
}
