package standard.mvc.component.business.widget.calendar.service;

import java.util.List;

import standard.mvc.component.business.widget.calendar.vo.CalendarVO;

public interface CalendarService {
	public List<CalendarVO> getInitialList();
	public List<CalendarVO> getSearchList();
}
