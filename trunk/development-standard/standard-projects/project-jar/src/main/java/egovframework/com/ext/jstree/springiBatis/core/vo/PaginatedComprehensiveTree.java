/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.ext.jstree.springiBatis.core.vo;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 8. 2.
 * @version 1.0
 * @see <pre>
 * Class Name  : PaginatedComprehensiveTree.java
 * Description : 페이지네이션을 위한 ComprehensiveTree 확장 클래스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 8. 2.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class PaginatedComprehensiveTree extends ComprehensiveTree {

    private int page = 1;
    private int rowCount = 10;
    private int pageCount = 10;
    
    private int beginningRow;
    private int endRow;
    
    /** 전정부 페이지네이터 */
    private PaginationInfo paginationInfo;
    /** 페이지 번호 클릭 시 처리될 자바스크립트 콜백 함수 */
    private String jsFunction;
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRowCount() {
        return rowCount;
    }
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getBeginningRow() {
        return beginningRow;
    }
    public void setBeginningRow(int beginningRow) {
        this.beginningRow = beginningRow;
    }
    public int getEndRow() {
        return endRow;
    }
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }
    public String getJsFunction() {
        return jsFunction;
    }
    public void setJsFunction(String jsFunction) {
        this.jsFunction = jsFunction;
    }
    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }
}