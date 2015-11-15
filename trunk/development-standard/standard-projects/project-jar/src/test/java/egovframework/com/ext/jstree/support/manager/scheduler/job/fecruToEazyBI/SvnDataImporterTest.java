package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import egovframework.com.ext.jstree.support.util.StringUtils;

public class SvnDataImporterTest {

	@Test
	public void StringCheckTest() {
		String commentText = "[조경원][BT:DEMO-40 , DEMO-46][RV:이동민] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";

		// RV 포맷이 있는지.
		int checkPointRV = test(commentText, "RV", "end");
		String filterRVstr = StringUtils.substring(commentText, checkPointRV);
		System.out.println("returnStr = " + filterRVstr);

		// RV가 있더라도 : 구분자가 있는지
		int checkPointRVDelimiter = test(filterRVstr, ":", "start");
		String filterRVDelimiterStr = StringUtils.substring(filterRVstr, checkPointRVDelimiter);
		System.out.println("returnStr = " + filterRVDelimiterStr);

		// RV와 구분자가 있더라도 잘 닫았는지.
		int checkPointRVDivid = test(filterRVDelimiterStr, "]", "start");
		String filterRVDividStr = StringUtils.substring(filterRVDelimiterStr, 1, checkPointRVDivid);
		String filterRVTrimDividStr = filterRVDividStr.trim();
		System.out.println("patternDelimiterReturnStr = " + filterRVTrimDividStr);

		if (StringUtils.lowerCase(filterRVTrimDividStr).equals("na")
				|| StringUtils.lowerCase(filterRVTrimDividStr).equals("n/a")) {
			System.out.println("RV 비어있음.");
		}
		if (filterRVTrimDividStr.isEmpty()) {
			System.out.println("RV 비어있음.");
		}

		// BT 포맷이 있는지.
		int checkPointBT = test(commentText, "BT", "end");
		String filterBTstr = StringUtils.substring(commentText, checkPointBT);
		System.out.println("returnStr = " + filterBTstr);

		// BT가 있더라도 : 구분자가 있는지
		int checkPointDelimiter = test(filterBTstr, ":", "start");
		String filterDelimiterstr = StringUtils.substring(filterBTstr, checkPointDelimiter);
		System.out.println("returnStr = " + filterDelimiterstr);

		// BT와 구분자가 있더라도 잘 닫았는지.
		int checkPointDivid = test(filterBTstr, "]", "start");
		String filterDividstr = StringUtils.substring(filterDelimiterstr, 1, checkPointDivid - 1);
		String filterTrimdividStr = filterDividstr.trim();
		System.out.println("patternDelimiterReturnStr = " + filterTrimdividStr);

		// 여러개의 이슈를 연결하였는지 하나만 했는지
		int checkPointMuiltiIssue = test2(filterTrimdividStr, ",", "start");
		String filterPointMuiltiIssuetr = StringUtils.substring(filterTrimdividStr, 0, checkPointMuiltiIssue);
		String filterPointMuiltiIssueTrimStr = filterPointMuiltiIssuetr.trim();
		System.out.println("filterPointMuiltiIssueTrimStr = " + filterPointMuiltiIssueTrimStr);
		// 전위 이슈를 정규표현식으로 검증
		regMatch("^[_0-9a-zA-Z-]+-[0-9]*$", filterPointMuiltiIssueTrimStr);

		// 전위 이슈를 가져와서 - 구분후 숫자로만 되 있는지 검사
		int checkPointIssueNumber = test(filterTrimdividStr, "-", "start");
		String filterPointIssueNumber = StringUtils.substring(filterPointMuiltiIssuetr, checkPointIssueNumber + 1);
		String filterPointIssueTrimNumber = filterPointIssueNumber.trim();
		System.out.println("filterPointIssueTrimNumber = " + filterPointIssueTrimNumber);
		// 정규 표현식 검증.
		regMatch("^[0-9]*$", filterPointIssueTrimNumber);

		assertThat(checkPointBT, greaterThan(0));
	}

	private void regMatch(String regEx, String filterPointMuiltiIssueTrimStr) {
		if (Pattern.matches(regEx, filterPointMuiltiIssueTrimStr)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	private int test(String originStr, String checkStr, String matchPoint) {
		String lowerStr = originStr.toLowerCase();
		Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
		Matcher matcherObj = patternObj.matcher(lowerStr);
		int checkPointValue = 0;
		if (matcherObj.find()) {
			checkPointValue = (matchPoint.equals("end")) ? matcherObj.end() : matcherObj.start();
			System.out.println("checkPoint = " + checkPointValue);
		} else {
			throw new RuntimeException();
		}
		return checkPointValue;
	}

	private int test2(String originStr, String checkStr, String matchPoint) {
		String lowerStr = originStr.toLowerCase();
		Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
		Matcher matcherObj = patternObj.matcher(lowerStr);
		int checkPointValue = 0;
		if (matcherObj.find()) {
			// muilti issue
			checkPointValue = (matchPoint.equals("end")) ? matcherObj.end() : matcherObj.start();
			System.out.println("checkPoint = " + checkPointValue);
		} else {
			// single issue
			checkPointValue = lowerStr.length();
			System.out.println("checkPoint = " + checkPointValue);
		}
		return checkPointValue;
	}

}
