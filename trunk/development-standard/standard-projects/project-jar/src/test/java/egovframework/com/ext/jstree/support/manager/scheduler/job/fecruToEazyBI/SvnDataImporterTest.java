package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




import org.easymock.internal.matchers.GreaterThan;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

public class SvnDataImporterTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Test
    public void StringCheckTest(){
        String commentString = "[오근현][BT:DEMO-38][RV:이동민] 테스트 제거 [문제의 원인] - 테스트 제거 [개발/변경 사항] - 테스트 제거 [변경된 파일/모듈] - N/A [개발자 테스트 내용] - N/A [테스트 요청 사항] - N/A";
        String commentLowerText = commentString.toLowerCase();
        
        Pattern patternBT = Pattern.compile("BT:", Pattern.CASE_INSENSITIVE);
        Matcher matcherBT = patternBT.matcher(commentLowerText);
        int checkPointBT = 0;
        if (matcherBT.find())
        {
            checkPointBT = matcherBT.start();
        }
        logger.info("checkPointBT = " + checkPointBT);
        System.out.println("checkPointBT = " + checkPointBT);
        assertThat( checkPointBT, greaterThan(0));
    }
}
