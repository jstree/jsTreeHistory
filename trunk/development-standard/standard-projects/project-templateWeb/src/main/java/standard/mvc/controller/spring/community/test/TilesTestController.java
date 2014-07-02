package standard.mvc.controller.spring.community.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesTestController {

	@RequestMapping(value="sample/sample")
	public String test(){
		
		return "tile:sample/sample";
	}
}
