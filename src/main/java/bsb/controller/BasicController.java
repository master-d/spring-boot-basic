package bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bsb.services.MathService;

@Component
@Controller
public class BasicController {

	@Value(value="#{app.name}")
	private static String appName;

	@Autowired
	MathService mathService;
	
	@GetMapping(value="/",produces=MediaType.TEXT_HTML_VALUE)
	public String index(@RequestParam(name="name", defaultValue="sir") String name) {
		return "goodevening";
	}
	
	@PostMapping(value="/sendFirstName", produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String sendFirstName(@RequestParam(name="fname", required=false) String fname ) {
		return "hello " + fname;
	}

	@GetMapping(value= {"/appName"}	,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String appName() {
		return appName;
	}

	@GetMapping(value= {"/calc/{expression}","/calc/{expression}/{divisor}"}
	,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String calc(@PathVariable("expression") String expression
			,@PathVariable(name="divisor",required=false) String divisor) {
		if (divisor != null)
			expression += "/" + divisor;
		return mathService.calc(expression).toPlainString();
	}
	
}
