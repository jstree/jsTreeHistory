package standard.mvc.component.business.baroboard.user.scrap.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class UserScrap extends ComprehensiveTree {

    /** 보드아이디 */
    private String boardId;
    
    /** 사용자 아이디 */
    private int userId;
    
	/** 글ID */
    private int postingId;
    
	/** 스크랩일시 */
    private String scrapDt;
    
    /** 제목 */
    private String boardTitle;
    
    /** 작성자 ID */
    private int regID;
    
    /** 작성일시 */
    private String regDt;
    
    /** 작성자 닉네임 */
    private String nickName;
    
	/** 조회수 */
    private int viewCnt;
    
    /** 추천수 */
    private int likeCount;
    
    /** 내용 */
    private String content;
    
    /** 첨부 파일 갯수 */
    private int attachmentCount;
    
    /** 페이지 */
	private int pageNum = 1;

	/** 페이지 사이즈 */
	private int pageSize = 10;
	
	/** 코멘트개수 */
	private int commentCnt;
    
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostingId() {
		return postingId;
	}

	public void setPostingId(int postingId) {
		this.postingId = postingId;
	}

	public String getScrapDt() {
		return scrapDt;
	}

	public void setScrapDt(String scrapDt) {
		this.scrapDt = scrapDt;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRegDt() {
		return regDt;
	}

	public void setRegDT(String regDt) {
		this.regDt = regDt;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
    
	public int getAttachmentCount() {
		return attachmentCount;
	}

	public void setAttachmentCount(int attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}


    @Override
    public String getSqlMapSelector() {
        return "userScrap";
    }
}
