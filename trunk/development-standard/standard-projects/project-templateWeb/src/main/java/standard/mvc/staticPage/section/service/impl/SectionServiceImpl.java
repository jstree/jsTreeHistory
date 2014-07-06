package standard.mvc.staticPage.section.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.staticPage.section.dao.SectionDAO;
import standard.mvc.staticPage.section.service.SectionService;
import standard.mvc.staticPage.section.vo.SectionVO;

@Service("SectionService")
public class SectionServiceImpl implements SectionService {

	@Resource(name="SectionDAO")
	private SectionDAO sectionDAO;

	@Override
	public SectionVO getSection() {
		SectionVO sectionVO = new SectionVO();
		return sectionDAO.getSection(sectionVO);
	}

}
