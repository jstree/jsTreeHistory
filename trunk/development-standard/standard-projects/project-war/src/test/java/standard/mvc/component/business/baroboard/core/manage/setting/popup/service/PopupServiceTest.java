package standard.mvc.component.business.baroboard.core.manage.setting.popup.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import standard.mvc.component.business.baroboard.core.manage.setting.popup.vo.PopupVO;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import egovframework.com.ext.jstree.support.manager.test.DbUnitTest;

/**
 * Modification Information
 * 
 * @author 이태경
 * @since 2015. 6. 17.
 * @version 1.0
 * @see <pre>
 * Class Name  : PopupServiceTest.java
 * Description : 바로보드-일반설정-팝업설정 Service 테스트 
 * Information  : Have To Write Information
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------      ------------   -----------------------
 * 2015. 6. 17.  이태경                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@DatabaseSetup("PopupServiceTest.xml")
public class PopupServiceTest extends DbUnitTest<PopupVO> {

	@Autowired
	private PopupService popupService;
	
	@Test
	public void getPopup() throws Exception{
		PopupVO popupParam = new PopupVO();
		popupParam.setC_id(3);
		PopupVO popup = popupService.getPopup(popupParam);
		assertThat(popup.getPopupContent(),is("팝업입니다."));
	}

	@Test
	@ExpectedDatabase(value = "PopupServiceTest_AlterPopup.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void alterPopup() throws Exception{
		PopupVO popupParam = new PopupVO();
		popupParam.setC_id(3);
		PopupVO popup = popupService.getPopup(popupParam);
		popup.setPopupContent("변경된팝업");
		
		popupService.alterPopup(popup);
	}
	
	@Test
	public void getPopups() throws Exception{
		PopupVO popupParam = new PopupVO();
		popupParam.setC_id(2);
		List<PopupVO> popupList = popupService.getPopupList(popupParam);
		assertThat(popupList.size(), is(1));
		
	}
	
	@Ignore
	@Test
	@ExpectedDatabase(value = "PopupServiceTest_AddPopup.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void addPopup() throws Exception{
		PopupVO popup = new PopupVO();
		popup.setPopupContent("새로저장된거");
		popup.setC_title("새로저장된타이틀");
		popup.setWritngDe("20150603");
		popup.setExpiryDe("20150603");
		popup.setApplyFl("1");
		popup.setRePopupTerm(10);
		popup.setLayerLeft(200);
		popup.setLayerTop(200);
		popup.setLayerWidth(200);
		popup.setLayerHeight(200);
		
		popupService.addPopup(popup);
	}
	
	@Test
	@ExpectedDatabase(value = "PopupServiceTest_RemovePopup.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void removePopup() throws Exception{
		PopupVO popupParam = new PopupVO();
		popupParam.setC_id(3);
		PopupVO popup = popupService.getPopup(popupParam);
		List<PopupVO> removeItems = new ArrayList<PopupVO>();
		removeItems.add(popup);
		popupService.removePopups(removeItems);
	}
}
