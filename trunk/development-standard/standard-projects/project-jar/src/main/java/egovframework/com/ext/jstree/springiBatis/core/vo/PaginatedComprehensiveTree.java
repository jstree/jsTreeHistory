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

    private int currentPage = 1;
    private int rowCountPerPage = 10;
    private int beginningRowOfRange;
    private int endRowOfRange;
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowCountPerPage() {
        return rowCountPerPage;
    }

    public void setRowCountPerPage(int rowCountPerPage) {
        this.rowCountPerPage = rowCountPerPage;
    }

    public int getBeginningRowOfRange() {
        return beginningRowOfRange;
    }

    public void setBeginningRowOfRange(int beginningRowOfRange) {
        this.beginningRowOfRange = beginningRowOfRange;
    }

    public int getEndRowOfRange() {
        return endRowOfRange;
    }

    public void setEndRowOfRange(int endRowOfRange) {
        this.endRowOfRange = endRowOfRange;
    }
}