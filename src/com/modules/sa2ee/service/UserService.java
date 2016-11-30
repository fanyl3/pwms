package com.modules.sa2ee.service;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.sa2ee.model.User;

public interface UserService {
	public PageResult<User> getUserPage(KPageParam param);
}
