package com.common.util.kendoui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fuyingbin
 *
 */
public class SortField  implements Serializable{
	
	/**
	 * 排序属性名称
	 */
	private String field;
	
	/**
	 * 排序方向
	 */
	private String dir;

	public SortField(){}{
		
	}
	
	public SortField(String field,String dir){
		this.field = field;
		this.dir = dir;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getHQL(String prefix){
		return prefix+this.field+" "+dir;
	}

}

