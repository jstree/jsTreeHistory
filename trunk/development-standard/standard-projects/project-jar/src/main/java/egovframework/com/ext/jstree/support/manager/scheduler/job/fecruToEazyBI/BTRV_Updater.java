package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.ext.jstree.support.util.StringUtils;

@Component
public class BTRV_Updater {

	@Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource(name = "BTRVService")
    BTRV_ServiceImpl btrvService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private BTRV_ComprehensiveTree btrvSearchNode;
    
	//@Scheduled(cron = "0 15 23 01 12 ?")
	@Scheduled(fixedDelay=10000000)
    public void execute()
    {
    	btrvSearchNode = new BTRV_ComprehensiveTree();
        try {
			List<BTRV_ComprehensiveTree> results = (List<BTRV_ComprehensiveTree>) btrvService.getNodeIds(btrvSearchNode);
			if (results.isEmpty())
	        {
				System.out.println("결과값 없음");
	        }else{
	        	for (BTRV_ComprehensiveTree btrv_ComprehensiveTree : results) {
	        		
	        		
	        		BTRV_ComprehensiveTree node = new BTRV_ComprehensiveTree();
	        		node = btrvService.getNode(btrv_ComprehensiveTree);
	        		System.out.println(node.getC_id() + "==" + node.getC_commitdate());
	        		String commitDate = node.getC_commitdate();
	        		int checkPointDate9 = test(commitDate, "2014-09", "end");
	        		int checkPointDate10 = test(commitDate, "2014-10", "end");
	        		int checkPointDate11 = test(commitDate, "2014-11", "end");
	        		int checkPointDate12 = test(commitDate, "2014-12", "end");
	        		if(checkPointDate9>0 || checkPointDate10>0 || checkPointDate11>0 || checkPointDate12>0){
	        			System.out.println(commitDate);
	        			continue;
	        		}else{
	        			
	        			String commentText = node.getC_svnlog();
	        			if(commentText != null){
	        				commentText = commentText.replace(System.getProperty("line.separator"), ""); 
	        				commentText = StringUtils.replace(commentText, "\r\n", " ");
	        				System.out.println(commentText);
	        				// BT 포맷이 있는지.
	        				int checkPointBT = test(commentText, "BT", "end");
	        				checkPointBT = (checkPointBT < 0) ? commentText.length() : checkPointBT;
	        				String filterBTstr = StringUtils.substring(commentText, checkPointBT);
	        				// logger.info("returnStr = " + filterBTstr);
	        				
	        				// BT가 있더라도 : 구분자가 있는지
	        				int checkPointDelimiter = test(filterBTstr, ":", "start");
	        				checkPointDelimiter = (checkPointDelimiter < 0) ? commentText.length()
	        						: checkPointDelimiter;
	        				String filterDelimiterstr = StringUtils.substring(filterBTstr, checkPointDelimiter);
	        				// logger.info("returnStr = " + filterDelimiterstr);
	        				
	        				// BT와 구분자가 있더라도 잘 닫았는지.
	        				int checkPointDivid = test(filterBTstr, "]", "start");
	        				checkPointDivid = (checkPointDivid < 0) ? 2 : checkPointDivid;
	        				String filterDividstr = StringUtils.substring(filterDelimiterstr, 1, checkPointDivid);
	        				String filterTrimdividStr = filterDividstr.trim();
	        				// logger.info("patternDelimiterReturnStr = " +
	        				// filterTrimdividStr);
	        				
	        				System.out.println("=========>" + filterTrimdividStr);
	        				if (StringUtils.lowerCase(filterTrimdividStr).equals("na")
	        						|| StringUtils.lowerCase(filterTrimdividStr).equals("n/a")) {
	        					node.setC_bt("N/A");
	        				} else if (filterTrimdividStr.isEmpty()) {
	        					node.setC_bt("N/A");
	        				} else {
	        					node.setC_bt(filterTrimdividStr);
	        				}
	        				
	        				btrvService.alterNodeBT(node);
	        			}else{
	        				node.setC_bt("N/A");
	        				btrvService.alterNodeBT(node);
	        			}
	        		}
	        	}
	        	System.out.println("끝");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//2. 가져온 리스트의 ID만큼 루프를 돌면서
    	//3. ID Node의 comment 를 파싱한다.
    	//4. 파싱한 데이터에서 BT를 분석하여 업데이트 한다.
    }
    
    private int test(String originStr, String checkStr, String matchPoint) {
		String lowerStr = originStr.toLowerCase();
		Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
		Matcher matcherObj = patternObj.matcher(lowerStr);
		int checkPointValue = 0;
		if (matcherObj.find()) {
			checkPointValue = (matchPoint.equals("end")) ? matcherObj.end() : matcherObj.start();
			logger.info("checkPoint = " + checkPointValue);
		} else {
			checkPointValue = -1;
		}
		return checkPointValue;
	}

}
