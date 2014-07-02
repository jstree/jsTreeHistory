package standard.mvc.util;


import java.util.ArrayList;
import java.util.List;

public class Paginator {
    public int PAGE_LIMIT = 10;
    private int OFFSET_BASE = 0;
    private int limit;
    private int offset;
    private int count = 0;
    private int currentPage;
    
    public Paginator(int limit, int pageNo, int count) {
        this.limit = limit;
        this.offset = (pageNo - OFFSET_BASE) * limit;
        this.count = count;
        this.currentPage = pageNo;
    }
    
    /**
     * 총 페이지 수가 없는 경우
     */
    public Paginator(int limit, int pageNo) {
        this.limit = limit;
        this.offset = (pageNo - OFFSET_BASE) * limit;
        this.currentPage = pageNo;
        this.count = -1;
    }
    
    /**
     * 한 페이지에 가져올 row 갯수
     */
    public int getLimit() {
        return limit;
    }
    
    /**
     * pageNo에 대한 오프셋
     */
    public int getOffset() {
        return offset;
    }
    
    /**
     * 전체 카운트
     */
    public int getCount() {
        return count;
    }
    
    /**
     * 현재 페이지를 구한다
     */
    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * 이전 페이지를 구한다
     */
    public int getPrevPage() {
        return prevPageNo(currentPage);
    }
    
    /**
     * 다음 페이지를 구한다
     */
    public int getNextPage() {
        return nextPageNo(currentPage);
    }
    
    /**
     * 이전 범위를 구한다
     */
    public int getPrevRange() {
        int cur = getCurrentPage();
        int prev = ((cur / PAGE_LIMIT) - 1) * PAGE_LIMIT;
        if (!isAvailable(prev)) {
            prev = 1;
        }
        return prev;
    }
    
    /**
     * 다음 범위를 구한다
     */
    public int getNextRange() {
        int cur = getCurrentPage();
        int next = ((cur / PAGE_LIMIT) + 1 ) * PAGE_LIMIT;
        if (!isAvailable(next)) {
            next = 0;
        }
        return next;
    }
    
    /**
     * 이전 범위가 있는가
     */
    public boolean hasPrevRange() {
        return currentPage > (PAGE_LIMIT - 1);
    }
    
    /**
     * 다음 범위가 있는가
     */
    public boolean hasNextRange() {
        int nextRange = getNextRange();
        if (0 == nextRange) {
            return false;
        }
        if (count == nextRange * limit) {
            return false;
        }
        return nextRange < getLastPage();
    }
    
    /**
     * 이전 페이지가 있는가
     */
    public boolean hasPrevPage() {
        return currentPage - getPrevPage() > 0;
    }
    
    /**
     * 다음 페이지가 있는가
     */
    public boolean hasNextPage() {
        return getLastPage() - getNextPage() > 0;
    }
    
    /**
     * 카운트가 없을때 처리
     */
    public boolean isUncountable() {
        return -1 == count;
    }
    
    /**
     * 페이지 목록을 배열로 돌려 준다
     */
    public List<Integer> getPageList() {
        List<Integer> list = new ArrayList<Integer>();
        int cur = getCurrentPage(); //현재페이지
        int first = getFirstPage(); //첫번째페이지
        int last = getLastPage();  //마지막페이지
        int sub = (cur / PAGE_LIMIT) * PAGE_LIMIT; //현재페이지 / 페이지개수
        for (int i = sub; i <= sub + PAGE_LIMIT; i++) {
            if (i >= first && i <= last) {
                list.add(new Integer(i));
            }
        }
        return list;
    }
    
    /**
     * 실제 페이징목록을 출력한다.
     * @return String
     * @author 유정민
     */
    public String renderPageList(){
    	
    	String paginator = "";
    	List<Integer> pageList = this.getPageList();
    	boolean prev = this.hasPrevRange();
    	boolean next = this.hasNextRange();
    	int totalCount = this.getLastPage();
    	int nowPage = this.getCurrentPage(); //현재 페이지
    	//int page = parameterParser.getInt("page", 1);
    	
    	paginator = paginator+"<div class='paginator'>";
    	paginator = paginator+"<div class='btn_first'></div>";
    	if(prev){
    		paginator = paginator+"<div class='btn_prev_true'></div>";
    	}else{
    		paginator = paginator+"<div class='btn_prev'></div>";
    	}
    	for (Integer pageNumber : pageList) {
    		if(nowPage == pageNumber){
    			paginator = paginator+"<div class='page_number_true font_07'><b>"+pageNumber+"</b></div>";
    		}else{
    			paginator = paginator+"<div class='page_number font_05'>"+pageNumber+"</div>";
    		}
		};
		if(next){
    		paginator = paginator+"<div class='btn_next_true'></div>";
    	}else{
    		paginator = paginator+"<div class='btn_next'></div>";
    	}
		paginator = paginator+"<div class='btn_end'></div>";
		paginator = paginator+"</div>";
		paginator = paginator+"<input type='hidden' id='pageTotalCount' value='"+totalCount+"'>";
		
    	return paginator;
		
	}
    
    /**
     * 첫번째 페이지를 구한다
     */
    public int getFirstPage() {
        return 1;
    }
    
    /**
     * 마지막 페이지를 구한다
     */
    public int getLastPage() {
        int last = count / limit;
        if (count % limit > 0) {
            return last + 1;
        } else {
            return last;
        }
    }
    
    private boolean isAvailable(int pageNo) {
        if (pageNo < 1) {
            return false;
        }
        if (count < (pageNo - 1) * limit) {
            return false;
        }
        
        return true;
    }
    
    private int prevPageNo(int pageNo) {
        int prev = pageNo - 1;
        if (!isAvailable(prev)) {
            prev = 1;
        }
        return prev;
    }
    
    private int nextPageNo(int pageNo) {
        int next = pageNo;
        if (!isAvailable(next)) {
            next = 1;
        }
        return next;
    }
}