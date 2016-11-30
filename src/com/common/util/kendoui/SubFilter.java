package com.common.util.kendoui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fuyingbin
 *
 */
public class SubFilter extends FilterField  implements Serializable{
	
	private String logic;
	
	private List<FilterField> filters;

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public List<FilterField> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterField> filters) {
		this.filters = filters;
	}

	public SubFilter(){}{
		
	}
	
	public SubFilter(String field,String operator,String value){
		super(field,operator,value);
	}

}

