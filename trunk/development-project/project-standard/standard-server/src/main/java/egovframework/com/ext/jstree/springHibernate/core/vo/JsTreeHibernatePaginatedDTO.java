package egovframework.com.ext.jstree.springHibernate.core.vo;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;


@MappedSuperclass
public class JsTreeHibernatePaginatedDTO extends JsTreeHibernateBaseDTO implements Serializable{
	
	private static final long serialVersionUID = 3465234289025484577L;

	public JsTreeHibernatePaginatedDTO() {
		super();
	}

	public JsTreeHibernatePaginatedDTO(String searchCondition, String searchKeyword, String searchUseYn, int pageIndex,
			int pageUnit, int pageSize, int firstIndex, int lastIndex, int recordCountPerPage,
			String searchKeywordFrom, String searchKeywordTo) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
		this.searchUseYn = searchUseYn;
		this.pageIndex = pageIndex;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
		this.recordCountPerPage = recordCountPerPage;
		this.searchKeywordFrom = searchKeywordFrom;
		this.searchKeywordTo = searchKeywordTo;
	}

	/** 검색조건 */
	@JsonIgnore
    private String searchCondition = "";
    
    /** 검색Keyword */
	@JsonIgnore
    private String searchKeyword = "";
    
    /** 검색사용여부 */
	@JsonIgnore
    private String searchUseYn = "";
    
    /** 현재페이지 */
	@JsonIgnore
    private int pageIndex = 1;
    
    /** 페이지갯수 */
	@JsonIgnore
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
	@JsonIgnore
    private int pageSize = 10;

    /** firstIndex */
	@JsonIgnore
    private int firstIndex = 1;

    /** lastIndex */
	@JsonIgnore
    private int lastIndex = 1;

    /** recordCountPerPage */
	@JsonIgnore
    private int recordCountPerPage = 10;
    
    /** 검색KeywordFrom */
	@JsonIgnore
    private String searchKeywordFrom = "";    

	/** 검색KeywordTo */
	@JsonIgnore
    private String searchKeywordTo = "";  
    
    @Transient
	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	@Transient
	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	@Transient
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	@Transient
	public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    @Transient
    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    @Transient
    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    @Transient
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Transient
    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    @Transient
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    
    /**
	 * searchKeywordFrom attribute를 리턴한다.
	 * @return String
	 */
    @Transient
	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	/**
	 * searchKeywordFrom attribute 값을 설정한다.
	 * @param searchKeywordFrom String
	 */
	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	/**
	 * searchKeywordTo attribute를 리턴한다.
	 * @return String
	 */
	@Transient
	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}

	/**
	 * searchKeywordTo attribute 값을 설정한다.
	 * @param searchKeywordTo String
	 */
	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}
}
