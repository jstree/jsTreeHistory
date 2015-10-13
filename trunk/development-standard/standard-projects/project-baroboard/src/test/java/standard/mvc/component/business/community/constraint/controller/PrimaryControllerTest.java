package standard.mvc.component.business.community.constraint.controller;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

import standard.mvc.component.business.community.constraint.vo.PrimaryComprehensiveTree;

public class PrimaryControllerTest {

	private PrimaryComprehensiveTree comprehensiveTree;
	private HttpServletRequest request;

	@Before
	public void setUp() throws Exception {
		comprehensiveTree = EasyMock.createMock(PrimaryComprehensiveTree.class);
		request = new MockHttpServletRequest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public void getChildNodeRuntimeExceptionTest() throws Exception {
		ModelMap model = new ModelMap();
		PrimaryController controller = new PrimaryController();

		EasyMock.expect(comprehensiveTree.getC_id()).andReturn(0);
		EasyMock.replay(comprehensiveTree);

		controller.getChildNode(comprehensiveTree, model, request);

		EasyMock.verify(comprehensiveTree);
	}

	@Test(expected = NullPointerException.class)
	public void getChildNodeNullPointerExceptionTest() throws Exception {
		ModelMap model = new ModelMap();
		PrimaryController controller = new PrimaryController();

		int c_id = (int) (Math.random() * Integer.MAX_VALUE + 1);
		EasyMock.expect(comprehensiveTree.getC_id()).andReturn(c_id);
		EasyMock.replay(comprehensiveTree);

		controller.getChildNode(comprehensiveTree, model, request);

		EasyMock.verify(comprehensiveTree);
	}

}
