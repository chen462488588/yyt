/**
 * 
 */
package com.huawei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huawei.model.BrandInfo;
import com.huawei.service.IBrandInfoService;
import com.huawei.service.IExcelService;

/** @author create by urmagical
*   @date   2018年5月12日 下午7:43:28
*   @version 
*/
@Controller()
@RequestMapping("excel")
public class ExcelController {
	
//	@Autowired
//	private IExcelService excelService;
	@Autowired
	private IBrandInfoService brandInfoService;
	
	@RequestMapping("exportExcel/{id}")
	public String exportExcel(@PathVariable Integer id) {
		BrandInfo brandInfo = brandInfoService.getBrandInfoById(id);
		System.out.println(brandInfo);
		return "";
	}
}

