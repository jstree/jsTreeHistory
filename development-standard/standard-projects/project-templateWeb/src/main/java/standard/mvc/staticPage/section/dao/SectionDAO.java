package standard.mvc.staticPage.section.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import standard.mvc.staticPage.section.vo.SectionVO;

@Repository("SectionDAO")
public class SectionDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public SectionVO getSection(SectionVO sectionVO){
		List<String> sectionList = new ArrayList<String>();
		
		sectionList.add("바로보드 소개");
		sectionList.add("개발도구");
		sectionList.add("모니터링");
		
		sectionVO.setSectionList(sectionList);
		
		logger.info("sectionVO : {}", Arrays.asList(sectionVO.getSectionList()));
		
		return sectionVO;
	}
}
