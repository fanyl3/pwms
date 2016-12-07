package com.common.util.kendoui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fuyingbin
 *
 */
public class Filter  implements Serializable{
	
	/**
	 * 查询条件
	 */
	private List<SubFilter> filters;

	private String logic;

	public List<SubFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<SubFilter> filters) {
		this.filters = filters;
	}

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}
	
	public List<FilterField> getFields(){
		List<FilterField> list = new ArrayList<FilterField>();
		if(filters!=null){
			for(SubFilter sub:filters){
				if(sub.getField()!=null && !sub.getField().trim().equals("")){
					list.add(sub);
				}
				if(sub.getFilters()!=null){
					for(FilterField f:sub.getFilters()){
						if(f.getField()!=null && !f.getField().trim().equals("")){
							list.add(f);
						}
					}
				}
			}
		}
		return list;
	}
	
	public String getHQL(String prefix){
		StringBuffer hql = new StringBuffer();
		int fieldSize = filters.size();
		for(int i=0;i<fieldSize;i++){
			SubFilter subFilter = filters.get(i);
			if(subFilter.getField()!=null && !"".equals(subFilter.getField().trim())){
				hql.append(subFilter.getHQL(prefix));
				if(i+1<fieldSize){
					hql.append(" ").append(this.getLogic()).append(" ");
				}
			}
			if(subFilter.getFilters()!=null){
				int subFieldSize = subFilter.getFilters().size();
				hql.append(" ( ");
				for(int j=0;j<subFieldSize;j++){
					FilterField field = subFilter.getFilters().get(j);
					hql.append(field.getHQL(prefix));
					if(j+1<subFieldSize){
						hql.append(" ").append(subFilter.getLogic()).append(" ");
					}
				}
				hql.append(" ) ");
				if(subFieldSize>0&&i+1<fieldSize){
					hql.append(" ").append(this.getLogic()).append(" ");
				}
			}
		}
		return hql.toString();
	}
	/***
	 * 如果查询条件里面存在 外部关联的字段
	 * @param prefix
	 * @param prefixAlias
	 * @return
	 */
	public String getHQL(String prefix,Map<String,String>prefixAlias){
		StringBuffer hql = new StringBuffer();
		int fieldSize = filters.size();
		for(int i=0;i<fieldSize;i++){
			SubFilter subFilter = filters.get(i);
			String fieldName = subFilter.getField().trim();
			if(subFilter.getField()!=null && !"".equals(fieldName)){
				//修改前缀
				if(prefixAlias.get(fieldName)!=null)
					hql.append(subFilter.getHQL(prefixAlias.get(fieldName)));
				else
					hql.append(subFilter.getHQL(prefix));
				
				if(i+1<fieldSize){
					hql.append(" ").append(this.getLogic()).append(" ");
				}
			}
			if(subFilter.getFilters()!=null){
				int subFieldSize = subFilter.getFilters().size();
				hql.append(" ( ");
				for(int j=0;j<subFieldSize;j++){
					FilterField field = subFilter.getFilters().get(j);
					fieldName = field.getField();
					//修改前缀
					if(prefixAlias.get(fieldName)!=null)
						hql.append(field.getHQL(prefixAlias.get(fieldName)));
					else
						hql.append(field.getHQL(prefix)); 
					
					if(j+1<subFieldSize){
						hql.append(" ").append(subFilter.getLogic()).append(" ");
					}
				}
				hql.append(" ) ");
				if(subFieldSize>0&&i+1<fieldSize){
					hql.append(" ").append(this.getLogic()).append(" ");
				}
			}
		}
		return hql.toString();
	}

}

