package standard.mvc.component.business.widget.calendar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.widget.calendar.dao.CalendarDAO;
import standard.mvc.component.business.widget.calendar.service.CalendarService;
import standard.mvc.component.business.widget.calendar.vo.CalendarVO;

@Service("CalendarService")
public class CalendarServiceImpl implements CalendarService {

	@Resource(name = "CalendarDAO")
	CalendarDAO calendarDAO;
	
	@Override
	public List<CalendarVO> getInitialList() {
		// TODO Auto-generated method stub
		return calendarDAO.getInitialList();
	}

	@Override
	public List<CalendarVO> getSearchList() {
		// TODO Auto-generated method stub
		return calendarDAO.getSearchList();
	}

}
