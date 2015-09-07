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
package egovframework.com.ext.jstree.support.manager.mvc.tags.ui.pagination;

import java.text.MessageFormat;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 6. 17.
 * @version 1.0
 * @see <pre>
 * Class Name  : AsyncPaginationTextRenderer.java
 * Description : 화면에 출력될 페이지 번호에 대한 텍스트 형태의 렌더링 설정 클래스
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 6. 17.   류강하                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class AsyncPaginationTextRenderer extends AbstractPaginationRenderer {

    public AsyncPaginationTextRenderer() {
        
        firstPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\">◀◀</a>&#160;&#160;"; 
        previousPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\">◀</a>&#160;&#160;";
        currentPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\" class=\"currentPage\">{2}</a>&#160;&#160;";
        otherPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;&#160;";
        nextPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\">▶</a>&#160;&#160;";
        lastPageLabel = "<a href=\"javascript:void(0);\" onclick=\"{0}({1}); return false;\">▶▶</a>&#160;&#160;";
    }
    
    @Override
    public String renderPagination(PaginationInfo paginationInfo, String jsFunction) {
        
        StringBuffer sb = new StringBuffer();
        
        int firstPageNo = paginationInfo.getFirstPageNo();
        int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
        int totalPageCount = paginationInfo.getTotalPageCount();
        int pageSize = paginationInfo.getPageSize();
        int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
        int currentPageNo = paginationInfo.getCurrentPageNo();
        int lastPageNo = paginationInfo.getLastPageNo();
        
        if ( totalPageCount > pageSize) {
            if (firstPageNoOnPageList > pageSize) {
                sb.append(MessageFormat.format(firstPageLabel, new Object[] { jsFunction, Integer.toString(firstPageNo) }));
                sb.append(MessageFormat.format(previousPageLabel, new Object[] { jsFunction, Integer.toString(firstPageNoOnPageList - 1) }));
            } else {
                sb.append(MessageFormat.format(firstPageLabel, new Object[] { jsFunction, Integer.toString(firstPageNo) }));
                sb.append(MessageFormat.format(previousPageLabel, new Object[] { jsFunction, Integer.toString(firstPageNo) }));
            }
        }
        
        for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
            if (i == currentPageNo) {
                sb.append(MessageFormat.format(currentPageLabel, new Object[] { jsFunction, Integer.toString(i), Integer.toString(i) }));
            } else {
                sb.append(MessageFormat.format(otherPageLabel, new Object[] { jsFunction, Integer.toString(i), Integer.toString(i) }));
            }
        }
        
        if (totalPageCount > pageSize) {
            if (lastPageNoOnPageList < totalPageCount) {
                sb.append(MessageFormat.format(nextPageLabel, new Object[] {jsFunction,Integer.toString(firstPageNoOnPageList+pageSize)}));
                sb.append(MessageFormat.format(lastPageLabel, new Object[] {jsFunction,Integer.toString(lastPageNo)}));
            } else {
                sb.append(MessageFormat.format(nextPageLabel,new Object[] {jsFunction,Integer.toString(lastPageNo)}));
                sb.append(MessageFormat.format(lastPageLabel,new Object[] {jsFunction,Integer.toString(lastPageNo)}));
            }
        }
        
        return sb.toString();
    }
}