package com.common.util.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

public class JsonUtils {
	public static final String JSON_ATTRIBUTE = "json";

	public static Object getDTO(String jsonString, Class clazz) {
		JSONObject jsonObject = null;
		try {
			setDataFormat();
			jsonObject = JSONObject.fromObject(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toBean(jsonObject, clazz);
	}

	public static Object getDTO(String jsonString, Class clazz, Map map) {
		JSONObject jsonObject = null;
		try {
			setDataFormat();
			jsonObject = JSONObject.fromObject(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toBean(jsonObject, clazz, map);
	}

	public static Object[] getDTOArray(String jsonString, Class clazz) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); ++i) {
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz);
		}
		return obj;
	}

	public static Object[] getDTOArray(String jsonString, Class clazz, Map map) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); ++i) {
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz, map);
		}
		return obj;
	}

	public static List getDTOList(String jsonString, Class clazz) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		List list = new ArrayList();
		for (Iterator iter = array.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, clazz));
		}
		return list;
	}

	public static List getDTOList(String jsonString, Class clazz, Map map) {
		setDataFormat();
		JSONArray array = JSONArray.fromObject(jsonString);
		List list = new ArrayList();
		for (Iterator iter = array.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, clazz, map));
		}
		return list;
	}

	public static Map getMapFromJson(String jsonString) {
		setDataFormat();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Map map = new HashMap();
		for (Iterator iter = jsonObject.keys(); iter.hasNext();) {
			String key = (String) iter.next();
			map.put(key, jsonObject.get(key));
		}
		return map;
	}

	public static Object[] getObjectArray(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();
	}

	public static String getJSONString(Object object) {
		String jsonString = null;

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		if (object != null) {
			if ((object instanceof Collection) || (object instanceof Object[]) ){
				jsonString = JSONArray.fromObject(object, jsonConfig)
						.toString();
			}else {
				jsonString = JSONObject.fromObject(object, jsonConfig)
						.toString();
			}
		}
		return (jsonString == null) ? "{}" : jsonString;
	}
	

	public static String getJSONString(Object object, String[] excludes)
			throws Exception {
		String jsonString = null;
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.setExcludes(excludes);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		if (object != null) {
			if ((object instanceof Collection) || (object instanceof Object[]))
				jsonString = JSONArray.fromObject(object, jsonConfig)
						.toString();
			else {
				jsonString = JSONObject.fromObject(object, jsonConfig)
						.toString();
			}
		}
		return (jsonString == null) ? "{}" : jsonString;
	}

	private static void setDataFormat() {
		JSONUtils.getMorpherRegistry().registerMorpher(
				new MyDateMorpher(new String[] { "yyyy-MM-dd",
						"yyyy-MM-dd HH:mm:ss" }));
	}
	
	public static String getStringFromStringArray(Object objVal){
		String val = "";
		if (objVal instanceof String[]){
			String[] strs = (String[])objVal;
			for(int i=0;i<strs.length;i++){
    			val += strs[i];
    		}
			
		}else{
			objVal = (String)objVal;
			val = objVal.toString();
		}
		return val;
	}
	
	public static Map getMapValueIsString(Map map){
		Set<String> keys = map.keySet();
		Map<String,String> map1 = new HashMap();
		for(String key:keys){
			map1.put(key, getStringFromStringArray(map.get(key)));
		}
		return map1;
	}
	
	public static Set getSetFromList(List lis){
		Set set = new LinkedHashSet();
		for(Object obj:lis){
			set.add(obj);
		}
		return set;
	}

	public static void main(String[] arg) throws Exception {
		String s = "{status : 'success'}";
		System.out.println(" object : " + getJSONString(s));
	}
}
