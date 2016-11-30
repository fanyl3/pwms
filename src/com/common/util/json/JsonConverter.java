package com.common.util.json;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/***
 * json 格式转换
 * @author song
 *
 */
public class JsonConverter {

	public static String jsonFromObjectNoProperties(Object obj,final Map<Class,List<String>>propers){
		String jsonString = null;
		 
		JsonConfig jsonConfig = new JsonConfig();
		//过滤掉 member属性
		jsonConfig.setJsonPropertyFilter(new PropertyFilter(){ 
			public boolean apply(Object source, String name, Object value) {
				List<String> props = propers.get(source.getClass());
				if(props!=null&&props.contains(name)){
					return true;
				}
				return false;
			}});
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		if (obj != null) {
			if ((obj instanceof Collection) || (obj instanceof Object[]))
				jsonString = JSONArray.fromObject(obj, jsonConfig)
						.toString();
			else {
				jsonString = JSONObject.fromObject(obj, jsonConfig)
						.toString();
			}
		}
		if(jsonString == null)jsonString="{}";
		return jsonString;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 