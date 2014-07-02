package standard.mvc.controller.spring.community.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestController {

	@ResponseBody
	@RequestMapping(value = "/menu")
	public String menu() {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");

		try {

			value = mapper.writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

	@ResponseBody
	@RequestMapping(value = "/menu/list")
	public String list() {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");
		map.put("depth2", "list");

		try {

			value = mapper.writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

	@ResponseBody
	@RequestMapping(value = "/menu/list/sonhoseong")
	public String name() {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String value = null;

		map.put("depth1", "menu");
		map.put("depth2", "list");
		map.put("depth3", "sonhoseong");

		try {

			value = mapper.writeValueAsString(map);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

}
