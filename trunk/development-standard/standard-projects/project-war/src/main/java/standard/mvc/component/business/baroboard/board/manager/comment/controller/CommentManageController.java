package standard.mvc.component.business.baroboard.board.manager.comment.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.board.manager.comment.service.CommentManageService;
import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;

/**
 * 
 * Modification Information
 * 
 * @author 이종렬
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : PostsManageController.java
 * Description : 바로보드-게시판-admin-댓글관리 Controller
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.      이종렬                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/board/manager/comment")
public class CommentManageController {

	@Resource(name="CommentManageService")
	private CommentManageService commentManageService;
	
	@Resource(name="DefaultSettingService")
	private CoreService defaultSettingService;
	
	@RequestMapping(value = "/index.do", method=RequestMethod.GET)
	public String getComments(ModelMap modelMap, CommentManageVO commentManageVo) throws Exception{
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(1);
		List<DefaultSettingVO> list = defaultSettingService.getChildNode(defaultSettingVo);
		System.out.println(list.size());
		modelMap.put("boardInfo", list);
		modelMap.put("list", commentManageService.getComment(commentManageVo));
		return "/jsp/baroboard/board/manager/comment/index";
	}

	@RequestMapping(value = "/commentDelete.do", method=RequestMethod.POST)
	@ResponseBody
	public CommentManageVO commentDelete(@RequestBody CommentManageVO commentManageVo) throws Exception{
		return commentManageService.commentDelete(commentManageVo);
	}

}
