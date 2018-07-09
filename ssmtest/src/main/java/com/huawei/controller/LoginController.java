/**
 * 
 */
package com.huawei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.model.User;
import com.huawei.service.IUserService;

/**
 * @author create by urmagical
 * @date 2018年3月24日 上午12:36:19
 * @version
 */
@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private IUserService userService;

	@RequestMapping("checkIsExist")
	public String checkIsExist(User user) {
		user = userService.checkIsExist(user);
		if (null!=user) {
			return "index";
		}
		return "login";
	}

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
