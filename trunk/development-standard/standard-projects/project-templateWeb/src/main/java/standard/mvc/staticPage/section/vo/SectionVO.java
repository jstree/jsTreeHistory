package standard.mvc.staticPage.section.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectionVO implements Serializable {

	private List<String> sectionList;

	private static final long serialVersionUID = 1L;

	public SectionVO() {
		super();
		this.sectionList = new ArrayList<String>();
	}

	public List<String> getSectionList() {
		return this.sectionList;
	}

	public void setSectionList(List<String> sectionList) {
		this.sectionList = new ArrayList<String>(sectionList);
	}

}
