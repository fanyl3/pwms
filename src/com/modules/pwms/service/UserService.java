package com.modules.pwms.service;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.pwms.model.system.User;

public interface UserService {
	public PageResult<User> getUserPage(KPageParam param);
}
