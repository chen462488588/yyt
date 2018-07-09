/**
 * 
 */
package com.huawei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huawei.mapper.UserMapper;
import com.huawei.model.User;
import com.huawei.model.UserExample;
import com.huawei.service.IUserService;

/**
 * @author create by urmagical
 * @date 2018年3月24日 上午12:44:28
 * @version
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huawei.service.IUserService#checkIsExist(com.huawei.model.User)
	 */
	@Override
	public User checkIsExist(User user) {
		UserExample example = new UserExample();
		if (null != user.getPassword()&&null !=user.getUsername()) {
			example.createCriteria().andUsernameEqualTo(user.getUsername());
			List<User> list = mapper.selectByExample(example);
			if (null != list && !list.isEmpty()) {
				User currentUser = list.get(0);
				if (currentUser.getPassword().equals(user.getPassword())) {
					return user;
				}
			}
		}
		return null;
	}

}
