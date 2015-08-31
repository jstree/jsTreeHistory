package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import egovframework.com.ext.jstree.support.util.StringUtils;

public class BTRV_ImporterTest
{
    @Test
    public void oldSpecCheckTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[이혜진][BT:DEMO-40 , DEMO-46][RV:이동민] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void oldSpecCheckSpaceTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[이혜진][BT: DEMO-40 , DEMO-46 ][RV: 이동민 ] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void oldSpecCheckNaBTNaRVTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[이혜진][BT: NA ][RV: N/A ] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [BT] ACM-41,DEMO-313 #time 2h #comment 각 지원 플랫폼 개발 +review RV-ACM @tskim [RV] 신현진 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("ACM-41,DEMO-313");
        assertThat(csvDataMap.get("RV")).isEqualTo("신현진");
    }
    @Test
    public void newSpecCheckSpaceTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [BT] ACM-41, DEMO-313 #time 2h #comment 각 지원 플랫폼 개발 +review RV-ACM @tskim [RV] 신현진 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("ACM-41,");
        assertThat(csvDataMap.get("RV")).isEqualTo("신현진");
    }
    @Test
    public void newSpecCheckNaBTNaRVTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [BT] n/a #time 2h #comment 각 지원 플랫폼 개발 +review RV-ACM @tskim [RV] n/a 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckRealTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [BT] V3LC-30[RV] 오근현 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("V3LC-30");
        assertThat(csvDataMap.get("RV")).isEqualTo("오근현");
    }
    @Test
    public void newSpecCheckReal뒷골Test(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [bt] V3LC-30[rv] 오근현 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("V3LC-30");
        assertThat(csvDataMap.get("RV")).isEqualTo("오근현");
    }
    @Test
    public void newSpecCheckBTRVFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "buildman";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }    
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckBTremainFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [BT] DEMO-313 #time 2h #comment 각 지원 플랫폼 개발 +review RV-ACM @tskim";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("DEMO-313");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckRVremainFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [RV] RV-DEMO-313 추후에 조사하고 추가하여야 함";
        if(checkLimitBTFormat(commentText)){            
            csvDataMap = checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(checkLimitRVFormat(commentText)){            
            csvDataMap = checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("RV-DEMO-313");
    }
    
    private Boolean checkLimitBTFormat(String commentText){
        String lowerStr = commentText.toLowerCase();
        Pattern oldPatternObj = Pattern.compile("BT:", Pattern.CASE_INSENSITIVE);
        Matcher oldMatcherObj = oldPatternObj.matcher(lowerStr);
        Pattern newPatternObj = Pattern.compile("BT]", Pattern.CASE_INSENSITIVE);
        Matcher newMatcherObj = newPatternObj.matcher(lowerStr);
        
        if (oldMatcherObj.find() || newMatcherObj.find())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private Boolean checkLimitRVFormat(String commentText){
        String lowerStr = commentText.toLowerCase();
        Pattern oldPatternObj = Pattern.compile("RV:", Pattern.CASE_INSENSITIVE);
        Matcher oldMatcherObj = oldPatternObj.matcher(lowerStr);
        Pattern newPatternObj = Pattern.compile("RV]", Pattern.CASE_INSENSITIVE);
        Matcher newMatcherObj = newPatternObj.matcher(lowerStr);
        
        if (oldMatcherObj.find() || newMatcherObj.find())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private Map<String, Object> checkBT(String commentText, Map<String, Object> csvDataMap)
    {
        //기존포맷
        //BT 포맷이 있는지.
        int checkPointOldBT = matchPointWithSoftCheck(commentText, "BT", "end");
        String filterOldBTstr = StringUtils.substring(commentText, checkPointOldBT);
        
        //BT가 있더라도 : 구분자가 있는지
        int checkPointOldBTDelimiter = matchPointWithSoftCheck(filterOldBTstr, ":", "start");
        String filterOldBTDelimiterStr = StringUtils.substring(filterOldBTstr, checkPointOldBTDelimiter);
        System.out.println("returnStr = " + filterOldBTDelimiterStr);
        
        //BT와 구분자가 있더라도 잘 닫았는지.
        int checkPointOldBTDivid = matchPointWithSoftCheck(filterOldBTDelimiterStr, "]", "start");
        String filterDividOldBTStr = StringUtils.substring(filterOldBTDelimiterStr, 1, checkPointOldBTDivid-1);
        String filterTrimOldBTDividStr = filterDividOldBTStr.trim();
        System.out.println("patternDelimiterReturnStr = " + filterTrimOldBTDividStr);
        
        if(filterTrimOldBTDividStr.isEmpty()){
            //BT 포맷이 있는지.
            int checkPointBT = matchPointWithHardCheck(commentText, "BT]", "end");
            String filterBTstr = StringUtils.substring(commentText, checkPointBT);
            
            int checkPointBTDivid = matchPointWithHardCheck(ltrim(filterBTstr), " ", "end");
            String filterBTDividStr = StringUtils.substring(filterBTstr, 1, checkPointBTDivid);
            String filterBTTrimDividStr = filterBTDividStr.trim();
            
            int checkPointBTMarkDivid = matchPointWithSoftCheck(filterBTTrimDividStr, "RV]", "start");
            String filterBTMarkDividStr = "";
            String filterBTMarkTrimDividStr = "";
            if(filterBTTrimDividStr.length() == checkPointBTMarkDivid){
                filterBTMarkDividStr = StringUtils.substring(filterBTTrimDividStr, 0, checkPointBTMarkDivid);
                filterBTMarkTrimDividStr = filterBTMarkDividStr.trim();
            }else{
                filterBTMarkDividStr = StringUtils.substring(filterBTTrimDividStr, 0, checkPointBTMarkDivid-1);
                filterBTMarkTrimDividStr = filterBTMarkDividStr.trim();
            }
            
            //여러개의 이슈를 연결하였는지 하나만 했는지 
            int checkPointMuiltiIssue = matchPointWithSoftCheck(filterBTMarkTrimDividStr, ",", "start");
            String filterPointMuiltiIssuetr = StringUtils.substring(filterBTMarkTrimDividStr, 0, checkPointMuiltiIssue);
            String filterPointMuiltiIssueTrimStr = filterPointMuiltiIssuetr.trim();
            
            //전위 이슈를 정규표현식으로 검증
            if(regMatch("^[_0-9a-zA-Z-]+-[0-9]*$", filterPointMuiltiIssueTrimStr)){
                csvDataMap.put("BT", filterBTMarkTrimDividStr);
            }else{
                csvDataMap.put("BT", "N/A");
            }
            
        }else{
            csvDataMap.put("BT", "N/A");
        }
        return csvDataMap;
    }

    private Map<String, Object> checkRV(String commentText, Map<String, Object> csvDataMap)
    {
        //기존포맷인지 체크
        //RV 포맷이 있는지.
        int checkPointOldSpecRV = matchPointWithSoftCheck(commentText, "RV", "end");
        String filterOldRVstr = StringUtils.substring(commentText, checkPointOldSpecRV);
        
        //RV가 있더라도 : 구분자가 있는지
        int checkPointOldRVDelimiter = matchPointWithSoftCheck(filterOldRVstr, ":", "start");
        String filterOldRVDelimiterStr = StringUtils.substring(filterOldRVstr, checkPointOldRVDelimiter);
        System.out.println("returnStr = " + filterOldRVDelimiterStr);
        
        //RV와 구분자가 있더라도 잘 닫았는지.
        int checkPointOldRVDivid = matchPointWithSoftCheck(filterOldRVDelimiterStr, "]", "start");
        String filterOldRVDividStr = StringUtils.substring(filterOldRVDelimiterStr, 1, checkPointOldRVDivid);
        String filterOldRVTrimDividStr = filterOldRVDividStr.trim();
        System.out.println("patternDelimiterReturnStr = " + filterOldRVTrimDividStr);
        
        if(filterOldRVDelimiterStr.isEmpty()){
            //RV 포맷이 있는지.
            int checkPointRV = matchPointWithHardCheck(commentText, "RV]", "end");
            String filterRVstr = StringUtils.substring(commentText, checkPointRV);
            
            //RV의 기록 데이터를 가져온다.
            int checkPointRVDivid = matchPointWithHardCheck(ltrim(filterRVstr), " ", "end");
            String filterRVDividStr = StringUtils.substring(filterRVstr, 1, checkPointRVDivid);
            String filterRVTrimDividStr = filterRVDividStr.trim();
            
            if(StringUtils.lowerCase(filterRVTrimDividStr).equals("na") || StringUtils.lowerCase(filterRVTrimDividStr).equals("n/a")){
                csvDataMap.put("RV", "N/A");
            }
            else if(filterRVTrimDividStr.isEmpty()){
                csvDataMap.put("RV", "N/A");;
            }else{
                csvDataMap.put("RV", filterRVTrimDividStr);
            }
        }else{
            csvDataMap.put("RV", "N/A");
        }
        return csvDataMap;
    }
    
    private boolean regMatch(String regEx, String filterPointMuiltiIssueTrimStr)
    {
        if(Pattern.matches(regEx, filterPointMuiltiIssueTrimStr)){
            return true;
        }else{
            return false;
        }
    }

    private int matchPointWithHardCheck(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
        }else{
            throw new RuntimeException();
        }
        return checkPointValue;
    }
    
    private int matchPointWithSoftCheck(String originStr, String checkStr, String matchPoint)
    {
        String lowerStr = originStr.toLowerCase();
        Pattern patternObj = Pattern.compile(checkStr, Pattern.CASE_INSENSITIVE);
        Matcher matcherObj = patternObj.matcher(lowerStr);
        int checkPointValue = 0;
        if (matcherObj.find())
        {
            //muilti issue
            checkPointValue = (matchPoint.equals("end"))?matcherObj.end():matcherObj.start();
        }else{
            //single issue
            checkPointValue = lowerStr.length();
        }
        return checkPointValue;
    }
    
    /**
     * 
     * @param s
     * @return
     */
    public static String ltrim(String s) 
    {
            char[] val = s.toCharArray();           
            int st  = 0;
            int len = s.length();
            while (st < len && val[st] <= ' ') 
            {
                    st++;
            }
            return s.substring(st, len);
    }

}
