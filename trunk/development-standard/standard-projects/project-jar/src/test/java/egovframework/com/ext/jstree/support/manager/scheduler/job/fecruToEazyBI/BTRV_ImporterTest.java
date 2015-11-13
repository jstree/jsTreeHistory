package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BTRV_ImporterTest
{
    @Test
    public void oldSpecCheckTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[이혜진][BT:DEMO-40 , DEMO-46][RV:이동민] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("V3LC-30");
        assertThat(csvDataMap.get("RV")).isEqualTo("오근현");
    }
    @Test
    public void newSpecCheckRealNotCommentTest(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "ASSERT 기능 구현 [bt] V3LC-30[rv] 오근현";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("V3LC-30");
        assertThat(csvDataMap.get("RV")).isEqualTo("오근현");
    }
    @Test
    public void newSpecCheckRealSVN특수문자연결Test(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[BT] N/A[RV] N/A[Title] 2.0.2 PM / LM 수정 사항 반영";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckRealSVN결과뒤집어지는현상Test(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "어플리케이션 재시작시 push 데이터 처리 문제 수정[rv] n/a[bt] AAI-8 1. 어플리케이션 재시작시 push 데이터를 처리할 수 있도록 수정";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        
        assertThat(csvDataMap.get("BT")).isEqualTo("AAI-8");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckBTRVFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "buildman";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
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
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("N/A");
        assertThat(csvDataMap.get("RV")).isEqualTo("RV-DEMO-313");
    }
    @Test
    public void newSpecCheckRVNOspaceFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[EPS P6][관리] Windows 8 family 지원[BT] EPS-2236[RV] n/acomment: BBNETELH Windows 8 빌드 환경 추가(현재 모듈의 동작은 지원되지 않음)";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("EPS-2236");
        assertThat(csvDataMap.get("RV")).isEqualTo("N/A");
    }
    @Test
    public void newSpecCheckEtcFormat(){
        Map<String, Object> csvDataMap = new HashMap<String, Object>();
        String commentText = "[박진곤][BT]WORKS:TZ-3340[RV]김유현 [문제의 원인]";
        if(BTRV_Importer.checkLimitBTFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkBT(commentText, csvDataMap);
        }else{
            csvDataMap.put("BT", "N/A");
        }
        if(BTRV_Importer.checkLimitRVFormat(commentText)){            
            csvDataMap = BTRV_Importer.checkRV(commentText, csvDataMap);
        }else{
            csvDataMap.put("RV", "N/A");
        }
        assertThat(csvDataMap.get("BT")).isEqualTo("WORKS:TZ-3340");
        assertThat(csvDataMap.get("RV")).isEqualTo("김유현");
    }
    

}
