package bsb.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

	@GetMapping(value="/",produces=MediaType.TEXT_HTML_VALUE)
	public String index(@RequestParam(name="name", defaultValue="sir") String name) {
		return "goodevening";
	}
	
	@PostMapping(value="/sendFirstName", produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String sendFirstName(@RequestParam(name="fname", required=false) String fname ) {
		return "hello " + fname;
	}
	
	@GetMapping(value="/add/{math}")
	@ResponseBody
	public String add(@PathVariable("math") String math) {
		int result = 0;
		String[] vals = math.split("\\+");
		for (int x=0; x<vals.length; x++) {
			result += Integer.valueOf(vals[x]);
		}
		return math + "=" + result;
	}
}
