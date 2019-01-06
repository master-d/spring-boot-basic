package bsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasicController {

	@RequestMapping(value="/",produces="text/html")
	public String index(@RequestParam(name="name", defaultValue="sir") String name) {
		return "goodevening";
	}
}
