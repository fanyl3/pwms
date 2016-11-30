package com.common.util.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页参数
 * @author fuyingbin
 *
 */
public class PageParam  implements Serializable{
	
	/**
	 * 当前页码,从1开始
	 */
	private int pageIndex;
	
	/**
	 * 每页条数
	 */
	private int pageLimit;
	
	/**
	 * 第一条数据位置
	 */
	//private int firstResult;
	
	/**
	 * 查询条件
	 */
	private Map<String,String> searchParam;

	public PageParam(int pageIndex, int pageLimit)
	{
		this.pageIndex = pageIndex;
		this.pageLimit = pageLimit;
		searchParam = new HashMap<String,String>();
		//this.firstResult = (pageIndex-1)*pageLimit;
		
	}
	
	public PageParam()
	{
		this(1,10);
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

	public Map<String, String> getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(Map<String, String> searchParam) {
		this.searchParam = searchParam;
	}

		
}
