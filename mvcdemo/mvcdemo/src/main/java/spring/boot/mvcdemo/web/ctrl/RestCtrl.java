package spring.boot.mvcdemo.web.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class RestCtrl {
	@RequestMapping(value = "date", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, String> testDate(@RequestBody DateWrap date) {
		Map<String, String> map = new HashMap<>();
		map.put("aa", date.getDate().toString());
		return map;
	}
}
