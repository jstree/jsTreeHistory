package standard.mvc.component.business.baroboard.board.manager.posts.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;
import standard.mvc.component.business.baroboard.board.manager.posts.service.PostsManageService;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;

/**
 * 
 * Modification Information
 * 
 * @author 이종렬
 * @since 2015. 6. 26.
 * @version 1.0
 * @see <pre>
 * Class Name  : PostsManageController.java
 * Description : 바로보드-게시판-admin-게시글관리 Controller
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 26.      이종렬                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Controller
@RequestMapping(value = "/board/manager/posts")
public class PostsManageController {

	@Resource(name="PostsManageService")
	private PostsManageService postsManageService;
	
	@Resource(name="DefaultSettingService")
	private CoreService defaultSettingService;
	
	@RequestMapping(value = "/index.do", method=RequestMethod.GET)
	public String getPosts(ModelMap map, PostsManageVO postsManageVo) throws Exception{
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(2);
		List<DefaultSettingVO> list = defaultSettingService.getChildNode(defaultSettingVo);
		map.put("boardInfo", list);
		//paging처리
		System.out.println(postsManageVo);
//		map.put("leftPage", null);
//		map.put("RightPage", postsManageService.getPostsRightPage(postsManageVo));
//		map.put("startNum", null);
//		map.put("rightNum", null);
//		map.put("curruntNum", null);
		map.put("list", postsManageService.getPosts(postsManageVo));
		return "/jsp/baroboard/board/manager/posts/index";
	}
	
	@RequestMapping(value = "/postsDelete.do", method=RequestMethod.POST)
	@ResponseBody
	public PostsManageVO postsDelete(@RequestBody PostsManageVO postsManageVo) throws Exception{
		
		return postsManageService.postsDelete(postsManageVo);
	}
	
	@RequestMapping(value = "/postsBoardMove.do", method=RequestMethod.POST)
	@ResponseBody
	public PostsManageVO postsBoardMove(@RequestBody PostsManageVO postsManageVo) throws Exception{
		return postsManageService.postsBoardMove(postsManageVo);
	}
	
}