/**
 * 
 */
package com.huawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author create by urmagical
*   @date   2018年3月20日 下午11:31:41
*   @version 
*   控制页面的跳转
*/
@Controller
@RequestMapping("page")
public class PageController {

	@RequestMapping("/{name}")
	public String pageIndex(@PathVariable String name) {
		return name;
	}
}

