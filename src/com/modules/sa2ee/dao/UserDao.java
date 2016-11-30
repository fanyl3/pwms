package com.modules.sa2ee.dao;

import com.common.dao.IBaseDao;
import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.sa2ee.model.User;


public interface UserDao extends IBaseDao<User>{
	public PageResult<User> getUserPage(KPageParam param);
}
