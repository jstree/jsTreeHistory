package standard.mvc.component.business.widget.calendar.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import standard.mvc.component.business.widget.calendar.vo.CalendarVO;

@Repository("CalendarDAO")
public class CalendarDAO {
	
	public List<CalendarVO> getInitialList() {
		List<CalendarVO> calendarList = new ArrayList<CalendarVO>();

		CalendarVO cal1 = new CalendarVO();
		cal1.setStart("20140707");
		cal1.setEnd("20140708");
		cal1.setTitle("일정1");
		cal1.setDetail("일정1상세");

		CalendarVO cal2 = new CalendarVO();
		cal2.setStart("20140709");
		cal2.setEnd("20140710");
		cal2.setTitle("일정2");
		cal2.setDetail("일정2상세");

		calendarList.add(cal1);
		calendarList.add(cal2);

		return calendarList;

	}

	public List<CalendarVO> getSearchList() {
		List<CalendarVO> calendarList = new ArrayList<CalendarVO>();

		CalendarVO cal1 = new CalendarVO();
		cal1.setStart("20140707");
		cal1.setEnd("20140708");
		cal1.setTitle("일정1");
		cal1.setDetail("일정1상세");

		CalendarVO cal2 = new CalendarVO();
		cal2.setStart("20140709");
		cal2.setEnd("20140710");
		cal2.setTitle("일정2");
		cal2.setDetail("일정2상세");

		calendarList.add(cal1);
		calendarList.add(cal2);

		return calendarList;

	}
}
