package bsb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@RequestMapping(value="/*",produces="text/plain")
	public String index(@RequestParam(name="name", defaultValue="sir") String name) {
		return "goodevening " + name;
	}
}
