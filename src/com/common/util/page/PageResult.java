
package com.common.util.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.common.util.kendoui.KPageParam;


/***
 * 分页结果
 * @author fuyingbin
 *
 */
public class PageResult<T> implements Serializable {
	/**
	 * 总数据条数
	 */
    private long total;
    
    /**
     * 总页数
     */
    private int totalPages;
    
    /**
     * 数据列表
     */
    private List<T> rows;
    
    /**
     * 当前页码
     */
    private int pageIndex;
    
    /**
     * 每页条数
     */
    private int pageLimit;

    public PageResult(int pageIndex,int pageLimit ,long total) {
        this.pageIndex = pageIndex;
        this.pageLimit = pageLimit;
        this.total = total;
        this.totalPages = (int)Math.ceil(total / (double)pageLimit);
        rows = new ArrayList<T>();
    }
    
    public PageResult(PageParam pageParam, long total)
    {
    	this(pageParam.getPageIndex(), pageParam.getPageLimit(),total);
    	
    }
    
    public PageResult(KPageParam pageParam, long total)
    {
    	this(pageParam.getPage(), pageParam.getPageSize(),total);
    	
    }

    public String toString() {
        return "{totalCount:" + total + ",result:" + rows + "}";
    }

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
}
