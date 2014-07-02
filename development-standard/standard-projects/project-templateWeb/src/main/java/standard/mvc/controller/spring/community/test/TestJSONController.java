package standard.mvc.controller.spring.community.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestJSONController {

	@ResponseBody
	@RequestMapping(value = "/menu")
	public String menu() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");

		try {

			value = writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return value;
	}

	@ResponseBody
	@RequestMapping(value = "/menu/list")
	public String list() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");
		map.put("depth2", "list");

		try {

			value = writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return value;
	}

	@ResponseBody
	@RequestMapping(value = "/menu/list/sonhoseong")
	public String name() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");
		map.put("depth2", "list");
		map.put("depth3", "sonhoseong");

		try {

			value = writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		return value;
	}
	
	private String writeValueAsString(Map<String, Object> map) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(map);
	}
	
}
