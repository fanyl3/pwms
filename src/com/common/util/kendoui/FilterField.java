package com.common.util.kendoui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fuyingbin
 *
 */
public class FilterField  implements Serializable{
	
	/**
	 * 过滤属性名称
	 */
	private String field;
	
	/**
	 * 操作符
	 */
	private String operator;
	/**
	 * 过滤值
	 */
	private String value;

	public FilterField(){}{
		
	}
	
	public FilterField(String field,String operator,String value){
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHQL(String prefix){
		if(this.field==null || "".equals(this.field)){
			return "";
		}
		String ope = "";
		if("eq".equals(this.operator)){
			ope = " = ";
		}else if("neq".equals(this.operator)){
			ope = " != ";
		}else if("startswith".equals(this.operator)){
			ope = " like ";
			this.value = this.value+"%";
		}else if("endswith".equals(this.operator)){
			ope = " like ";
			this.value = "%"+this.value;
		}else if("contains".equals(this.operator)){
			ope = " like ";
			this.value = "%"+this.value+"%";
		}else if("doesnotcontain".equals(this.operator)){
			ope = " not like ";
			this.value = "%"+this.value+"%";
		}else if("gt".equals(this.operator)){
			ope = " > ";
		}else if("gte".equals(this.operator)){
			ope = " >= ";
		}else if("lt".equals(this.operator)){
			ope = " < ";
		}else if("lte".equals(this.operator)){
			ope = " <= ";
		}
		return prefix+this.field+ope+"? ";
	}
 
}

