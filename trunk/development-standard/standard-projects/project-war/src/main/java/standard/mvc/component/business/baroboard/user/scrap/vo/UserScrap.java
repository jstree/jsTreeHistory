package standard.mvc.component.business.baroboard.user.scrap.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class UserScrap extends ComprehensiveTree {

    /** 보드아이디 */
    private int boardId;
    
    /** 사용자 아이디 */
    private int userId;
    
	/** 글ID */
    private int postingId;
    
	/** 스크랩일시 */
    private String scrapDt;
    
    /** 작성자 ID */
    private int regID;
    
    /** 작성일시 */
    private String regDt;
    
    /** 작성자 닉네임 */
    private String nickName;
    
    /** 페이지 */
	private int pageNum = 1;

	/** 페이지 사이즈 */
	private int pageSize = 10;
	
	/** 게시판 명 */
	private String boardName;
	
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
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

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}
	
	public String getRegDt() {
		return regDt;
	}

	public void setRegDT(String regDt) {
		this.regDt = regDt;
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
	
    @Override
    public String getSqlMapSelector() {
        return "userScrap";
    }
}
