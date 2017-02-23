package egovframework.rivalwar.api.snsLogin.service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.uss.umt.service.EgovMberManageService;
import egovframework.com.uss.umt.service.MberManageVO;
import egovframework.com.uss.umt.service.UserDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;
import org.springmodules.validation.commons.DefaultBeanValidator;

import javax.annotation.Resource;
import java.util.List;

@Service("FacebookLoginService")
public class FacebookLoginServiceImpl implements FacebookLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    /**
     * cmmUseService
     */
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    /** DefaultBeanValidator beanValidator */
    @Autowired
    private DefaultBeanValidator beanValidator;

    @Override
    public long getUserIdByLoginAndRegisterProcess(FacebookProfile facebookProfile) throws Exception {

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

            logger.info("register process");
            MberManageVO mberManageVO = new MberManageVO();
            mberManageVO.setMberId(facebookProfile.getId());
            mberManageVO.setMberNm(facebookProfile.getId());
            mberManageVO.setPassword(propertiesService.getString("tempPassword"));
            mberManageVO.setPasswordHint("P03");
            mberManageVO.setPasswordCnsr(propertiesService.getString("tempPasswordCnsr"));
            mberManageVO.setAreaNo("010");
            mberManageVO.setMiddleTelno("7313");
            mberManageVO.setEndTelno("7313");
            mberManageVO.setMberFxnum("facebook"); //소셜 타입 : facebook, google, etc...
            mberManageVO.setMoblphonNo("01031313131");
            mberManageVO.setMberEmailAdres("noreply@313.co.kr");
            mberManageVO.setZip("100775");
            mberManageVO.setAdres("서울중구무교동한국정보화진흥원");
            mberManageVO.setDetailAdres("custom field");
            mberManageVO.setMberSttus("P");
            //쭉쭉
            if (mberManageVO.getGroupId().equals("")) {
                mberManageVO.setGroupId(null);
            }
            mberManageService.insertMber(mberManageVO);

        } else {
            if (mberList.size() == 1) {
                logger.info("registered statistics process");

            } else {
                logger.info("what things?");
            }
        }

        //찾은 경우에 대한 사용자 아이디 리턴.
        return 313;
    }

    @Override
    public boolean getIsNickname(String userId) {
        return false;
    }

}
