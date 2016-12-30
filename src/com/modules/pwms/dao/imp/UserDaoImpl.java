package com.modules.pwms.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDaoSupport;
import com.common.util.kendoui.FilterField;
import com.common.util.kendoui.KPageParam;
import com.common.util.kendoui.SortField;
import com.common.util.page.PageResult;

import com.modules.pwms.dao.UserDao;
import com.modules.pwms.model.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoSupport<User> implements UserDao{
	public PageResult<User> getUserPage(KPageParam param){
		StringBuffer hql = new StringBuffer("from User as entity ");
		if(param.getFilter()!=null){
			hql.append(" where ").append(param.getFilter().getHQL("entity."));
		}
		
		//hql.append(" order by entity.createDate desc");
		hql.append("order by ");
		
		if(param.getSort()!=null){
			for(SortField sort:param.getSort()){
				hql.append(sort.getHQL("entity.")).append(",");
			}
		}
		
		hql.append(" entity.id desc");
		
		
		
		System.out.println(hql.toString()); 
		
		Query query = getSession().createQuery(hql.toString());
		Query query2 = getSession().createQuery("select count(*) "+hql);
		//Query query2 = getSession().createQuery(hql2.toString());
		//参数赋值
		if(param.getFilter()!=null){
			int index = 0;
			for(FilterField field:param.getFilter().getFields()){
				query.setParameter(index, field.getValue());
				query2.setParameter(index, field.getValue());
				index++;
			}
		} 
		query.setFirstResult( (param.getPage()-1)*param.getPageSize())
			.setMaxResults(param.getPageSize());
		List<User> list = query.list();
		int total = Integer.parseInt(query2.list().get(0).toString());
		System.out.println(total);
		PageResult<User> page = new PageResult(param,total);
		page.setRows(list);
		
		return page; 
	}
	
}
