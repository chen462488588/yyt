/**
 * 
 */
package com.huawei.service;

import com.huawei.model.User;

/** @author create by urmagical
*   @date   2018年3月24日 上午12:44:02
*   @version 
*/
public interface IUserService {

	/**
	 * @param user
	 * @return
	 */
	User checkIsExist(User user);

}

