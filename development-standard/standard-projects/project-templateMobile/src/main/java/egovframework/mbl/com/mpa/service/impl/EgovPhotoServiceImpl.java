package egovframework.mbl.com.mpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.mpa.service.EgovPhotoService;
import egovframework.mbl.com.mpa.service.Photo;
import egovframework.mbl.com.mpa.service.PhotoVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**
 * 개요
 * - 사진 앨범에 대한 Service Interface를 구현한다.
 * 
 * 상세내용
 * - 사진에 대한 등록, 수정, 삭제, 조회 기능을 제공한다.
 * - 사진에 대한 조회기능은 목록, 상세조회로 구분된다.
 * @author 정홍규
 * @since 2011.08.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.10  정홍규          최초 생성
 *
 * </pre>
 */

@Service("PhotoService")
public class EgovPhotoServiceImpl extends AbstractServiceImpl implements
        EgovPhotoService {

    /**
     * PhotoDAO
     */
    @Resource(name = "PhotoDAO")
    private PhotoDAO photoDAO;

    /** ID Generation */
    @Resource(name = "egovPhotoIdGnrService")
    private EgovIdGnrService idgenService;

    /**
     * 사진 정보 삭제 관련 비즈니스 구현 메서드
     * @param photo
     * @throws Exception
     */
    public void deletePhoto(Photo photo) throws Exception {
        photoDAO.deletePhoto(photo);
    }

    /**
     * 사진 정보 등록 관련 비즈니스 구현 메서드
     * @param photo
     * @throws Exception
     */
    public void insertPhoto(Photo photo) throws Exception {

        log.debug(photo.toString());

        int sn = idgenService.getNextIntegerId();

        photo.setSn(sn);

        photoDAO.insertPhoto(photo);
    }

    /**
     * 사진 정보 상세 조회 관련 비즈니스 구현 메서드
     * @param photo
     * @return Photo 사진 정보
     * @throws Exception
     */
    public Photo selectPhoto(Photo photo) throws Exception {
        Photo ret = (Photo) photoDAO.selectPhoto(photo);
        return ret;
    }

    /**
     * 사진 목록을 조회 관련 비즈니스 구현 메서드
     * @param searchVO
     * @return List 사진 목록
     * @throws Exception
     */
    public List selectPhotoList(PhotoVO searchVO) throws Exception {
        return photoDAO.selectPhotoList(searchVO);
    }

    /**
     * 사진 정보 수정 관련 비즈니스 구현 메서드
     * @param photo
     * @throws Exception
     */
    public void updatePhoto(Photo photo) throws Exception {
        photoDAO.updatePhoto(photo);
    }

    /**
     * 사진 정보의 총 갯수를 조회한다.
     * @param searchVO
     * @return int
     */
    public int selectPhotoListTotCnt(PhotoVO searchVO) throws Exception {
        return photoDAO.selectPhotoListTotCnt(searchVO);
    }
}
