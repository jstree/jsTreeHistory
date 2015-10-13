package standard.mvc.component.business.baroboard.user.manage.point.setting.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.util.StringUtils;

public class UserPointSetting extends ComprehensiveTree {
	
	private String pointUseFl; /* 포인트사용여부 */
	private String downloadProhFl; /* 다운로드금지여부 */
	private String articleReadProhFl; /* 금열람금지여부 */
	private int pointExpiryDate; /* 포인트유효기간 */
	private int userJoinPoint; /* 회원가입포인트 */
	private int loginPoint; /* 로그인포인트 */
	private int writingPoint; /* 글쓰기포인트 */
	private int answerPoint; /* 댓글포인트 */
	private int uploadPoint; /* 업로드포인트 */
	private int downloadPoint; /* 다운로드포인트 */
	private int recmnderPoint; /* 추천인포인트 */
	private int downloadDeduPoint; /* 다운로드차감포인트 */
	private int articleReadDeduPoint; /* 글열람차감포인트 */
	
	
	public String getPointUseFl() {
		return pointUseFl;
	}

	public void setPointUseFl(String pointUseFl) {
		if(StringUtils.isBlank(pointUseFl)){
			this.pointUseFl = "0";
		}
		
		this.pointUseFl = pointUseFl;
	}

	public String getDownloadProhFl() {
		return downloadProhFl;
	}

	public void setDownloadProhFl(String downloadProhFl) {
		if(StringUtils.isBlank(downloadProhFl)){
			this.downloadProhFl = "0";
		}
		
		this.downloadProhFl = downloadProhFl;
	}

	public String getArticleReadProhFl() {
		return articleReadProhFl;
	}

	public void setArticleReadProhFl(String articleReadProhFl) {
		if(StringUtils.isBlank(articleReadProhFl)){
			this.articleReadProhFl = "0";
		}
		
		this.articleReadProhFl = articleReadProhFl;
	}

	public int getPointExpiryDate() {
		return pointExpiryDate;
	}

	public void setPointExpiryDate(int pointExpiryDate) {
		this.pointExpiryDate = pointExpiryDate;
	}

	public int getUserJoinPoint() {
		return userJoinPoint;
	}

	public void setUserJoinPoint(int userJoinPoint) {
		this.userJoinPoint = userJoinPoint;
	}

	public int getLoginPoint() {
		return loginPoint;
	}

	public void setLoginPoint(int loginPoint) {
		this.loginPoint = loginPoint;
	}

	public int getWritingPoint() {
		return writingPoint;
	}

	public void setWritingPoint(int writingPoint) {
		this.writingPoint = writingPoint;
	}

	public int getAnswerPoint() {
		return answerPoint;
	}

	public void setAnswerPoint(int answerPoint) {
		this.answerPoint = answerPoint;
	}

	public int getUploadPoint() {
		return uploadPoint;
	}

	public void setUploadPoint(int uploadPoint) {
		this.uploadPoint = uploadPoint;
	}

	public int getDownloadPoint() {
		return downloadPoint;
	}

	public void setDownloadPoint(int downloadPoint) {
		this.downloadPoint = downloadPoint;
	}

	public int getRecmnderPoint() {
		return recmnderPoint;
	}

	public void setRecmnderPoint(int recmnderPoint) {
		this.recmnderPoint = recmnderPoint;
	}

	public int getDownloadDeduPoint() {
		return downloadDeduPoint;
	}

	public void setDownloadDeduPoint(int downloadDeduPoint) {
		this.downloadDeduPoint = downloadDeduPoint;
	}

	public int getArticleReadDeduPoint() {
		return articleReadDeduPoint;
	}

	public void setArticleReadDeduPoint(int articleReadDeduPoint) {
		this.articleReadDeduPoint = articleReadDeduPoint;
	}

	@Override
    public String getSqlMapSelector() {
        return this.getClass().getName();
    }
}
