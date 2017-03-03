package egovframework.rivalwar.api.snsLogin.service;

import egovframework.com.ext.jstree.support.util.StringUtils;
import egovframework.com.uss.umt.service.EgovMberManageService;
import egovframework.com.uss.umt.service.MberManageVO;
import egovframework.com.uss.umt.service.UserDefaultVO;
import egovframework.com.uss.umt.service.impl.MberManageDAO;
import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("FacebookLoginService")
public class FacebookLoginServiceImpl implements FacebookLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * mberManageDAO
     */
    @Resource(name = "mberManageDAO")
    private MberManageDAO mberManageDAO;

    /**
     * egovUsrCnfrmIdGnrService
     */
    @Resource(name = "egovUsrCnfrmIdGnrService")
    private EgovIdGnrService idgenService;
    /**
     * EgovPropertyService
     */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * mberManageService
     */
    @Resource(name = "mberManageService")
    private EgovMberManageService mberManageService;


    @Override
    public String getUserIdByLoginAndRegisterProcess(FacebookProfile facebookProfile) throws Exception {

        UserDefaultVO userSearchVO = new UserDefaultVO();
        userSearchVO.setSearchKeyword(facebookProfile.getId());

        /** EgovPropertyService */
        userSearchVO.setPageUnit(propertiesService.getInt("pageUnit"));
        userSearchVO.setPageSize(propertiesService.getInt("pageSize"));

        /** pageing */
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(userSearchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(userSearchVO.getPageUnit());
        paginationInfo.setPageSize(userSearchVO.getPageSize());

        userSearchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        userSearchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        userSearchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        userSearchVO.setPageIndex(1);
        userSearchVO.setSbscrbSttus("0");
        userSearchVO.setSearchCondition("1");

        List<?> mberList = mberManageService.selectMberList(userSearchVO);
        if (mberList.isEmpty() == true) {
            MberManageVO mberManageVO = new MberManageVO();
            mberManageVO.setMberId(facebookProfile.getId());
            mberManageVO.setMberNm(facebookProfile.getId());
            mberManageVO.setPassword(propertiesService.getString("tempPassword"));
            mberManageVO.setPasswordHint("P03");
            mberManageVO.setPasswordCnsr(propertiesService.getString("tempPasswordCnsr"));
            mberManageVO.setAreaNo("010");
            mberManageVO.setMiddleTelno("7313");
            mberManageVO.setEndTelno("7313");
            mberManageVO.setMberFxnum("facebook");
            mberManageVO.setMoblphonNo("01031313131");
            mberManageVO.setMberEmailAdres("noreply@313.co.kr");
            mberManageVO.setZip("100775");
            mberManageVO.setAdres("서울중구무교동한국정보화진흥원");
            mberManageVO.setDetailAdres("");//nickname
            mberManageVO.setMberSttus("P");
            mberManageVO.setGroupId("GROUP_00000000000000");
            //고유아이디 셋팅
            String uniqId = idgenService.getNextStringId();
            mberManageVO.setUniqId(uniqId);
            //패스워드 암호화
            String pass = EgovFileScrty.encryptPassword(mberManageVO.getPassword(), mberManageVO.getMberId());
            mberManageVO.setPassword(pass);
            mberManageDAO.insertMber(mberManageVO);
            return uniqId;
        } else {
            if (mberList.size() == 1) {
                EgovMap emp = (EgovMap) mberList.get(0);
                logger.info("-----------------" +  emp.get("nickname").toString());
                String nickName = emp.get("nickname").toString();
                if(StringUtils.isEmpty(nickName) || StringUtils.equalsIgnoreCase(nickName, facebookProfile.getId())){
                    //nickname is not appered
                    logger.info("--------------------needTheNickname");
                    return "needTheNickname";
                }else{
                    //nickname is apper
                    logger.info("--------------------joinedAccount");
                    return "joinedAccount";
                }

            } else {
                throw new RuntimeException("duplicate account check" + facebookProfile.getId());
            }
        }
    }

}
