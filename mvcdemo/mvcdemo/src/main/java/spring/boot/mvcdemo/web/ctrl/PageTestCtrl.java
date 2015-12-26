package spring.boot.mvcdemo.web.ctrl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/page")
public class PageTestCtrl {
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${application.message:test}")
	private String message = "Hello World";

	@RequestMapping(value = "test/jsp", method = RequestMethod.GET)
	public ModelAndView testJsp() {
		ModelAndView mv = new ModelAndView("test");
		logger.debug("test_jsp");
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping("test/404")
	public String to404(Map<String, Object> model) {
		logger.debug("test_404");
		return "404";
	}

	@RequestMapping("test/500")
	public String to500() {
		logger.debug("test_500");
		throw new RuntimeException();
	}
}
