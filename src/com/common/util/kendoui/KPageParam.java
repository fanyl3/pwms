package com.common.util.kendoui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * 分页参数
 * @author fuyingbin
 *
 */
public class KPageParam  implements Serializable{
	
	/**
	 * 当前页码,从1开始
	 */
	private int page;
	
	/**
	 * 每页条数
	 */
	private int pageSize;
	
	/**
	 * 查询条件
	 */
	private Filter filter;
	
	private List<SortField> sort;
	
	/***
	 * 获取field的值，可以通过该函数判断条件中是否存在
	 * @param field
	 * @return
	 */
	public String getParam(String field){
		if(this.getFilter()==null)
			return null;
		for(FilterField f : this.getFilter().getFields()){
			if(f.getField().equals(field))
				return f.getValue();
		}
		return null;
	}
	/***
	 * 添加条件
	 * @param field
	 * @param value
	 * @param op
	 */
	public void addParam(String field,String value,String op){ 
		if(this.filter==null)
			this.filter = new Filter();
		this.filter.setLogic("and");
		if(null==this.filter.getFilters())
			this.filter.setFilters(new ArrayList<SubFilter>());
		
		//添加子项
		SubFilter sf = new SubFilter();
		sf.setField(field);
		sf.setLogic("and");
		sf.setValue(value);
		sf.setOperator(op); 
		this.filter.getFilters().add(sf);
	}
	
	/***
	 * 添加条件
	 * @param field
	 * @param value
	 * @param op
	 */
	public void addParam(String field,String value,String op,String logic){ 
		if(this.filter==null)
			this.filter = new Filter();
		this.filter.setLogic("and");
		if(null==this.filter.getFilters())
			this.filter.setFilters(new ArrayList<SubFilter>());
		
		//添加子项
		SubFilter sf = new SubFilter();
		sf.setField(field);
		sf.setLogic(logic);
		sf.setValue(value);
		sf.setOperator(op); 
		this.filter.getFilters().add(sf);
	}

	public KPageParam(int page, int pageSize)
	{
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public KPageParam()
	{
		this(1,10);
	}

	
	public static void main(String[]args){
		String json = "{\"take\":5,\"skip\":0,\"page\":1,\"pageSize\":5,\"sort\":[{\"field\":\"roleName\",\"dir\":\"asc\"}],\"filter\":{\"filters\":[{\"field\":\"roleName\",\"operator\":\"eq\",\"value\":\"12\"},{\"field\":\"roleName\",\"operator\":\"eq\",\"value\":\"23\"}],\"logic\":\"and\"},\"group\":[]} ";
		json = null;
		Gson gson = new Gson();
		KPageParam param = gson.fromJson(json, KPageParam.class);
		//System.out.println(param.getPage());
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public List<SortField> getSort() {
		return sort;
	}

	public void setSort(List<SortField> sort) {
		this.sort = sort;
	}
	

}

