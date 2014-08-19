package standard.mvc.component.sec.oauth2.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

/**
 * @author Ryan Heaton
 * @author Dave Syer
 */
@Controller
public class FacebookController {
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/facebook/info.do")
	public String photos(Model model,@Qualifier("facebookRestTemplate") RestOperations facebookRestTemplate) throws Exception {
		System.out.println("================facebook===================");
		Map<String, Object> result = facebookRestTemplate
				.getForObject("https://graph.facebook.com/me/friends", HashMap.class);
		
		System.out.println(result+"=================================><");
		ArrayList<Map> friends = (ArrayList<Map>) result.get("data");
		ArrayList<String> friendsName = new ArrayList<String>();
		for (Map map : friends) {
			friendsName.add((String) map.get("name"));
		}
		model.addAttribute("friends", friendsName);
		return "facebook";
	}

}
