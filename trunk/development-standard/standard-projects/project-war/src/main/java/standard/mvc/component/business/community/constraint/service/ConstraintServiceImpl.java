package standard.mvc.component.business.community.constraint.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

@Service(value = "ConstraintService")
public class ConstraintServiceImpl implements CoreService {

	@Resource(name = "CoreService")
	private CoreService coreService;

	@Override
	public <T extends ComprehensiveTree> List<T> getChildNode(
			T comprehensiveTree) throws Exception {
		// TODO Auto-generated method stub
		return coreService.getChildNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> List<String> searchNode(
			T comprehensiveTree) throws Exception {
		// TODO Auto-generated method stub
		return coreService.searchNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.addNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.removeNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.alterNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
			throws Exception {
		// TODO Auto-generated method stub
		return coreService.alterNodeType(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return coreService.moveNode(comprehensiveTree, request);
	}

}
