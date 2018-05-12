/**
 * 
 */
package com.huawei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.model.BrandInfo;
import com.huawei.service.IBrandInfoService;

/**
 * @author create by urmagical
 * @date 2018年3月18日 下午8:51:28
 * @version 商品的品牌信息crud
 */
@Controller
@RequestMapping("/brandInfo")
public class BrandInfoController {

	@Autowired
	private IBrandInfoService service;

	@RequestMapping(value = "getBrandInfoList/{pageNum}")
	public String getAll(@PathVariable(name = "pageNum") Integer startPage, ModelMap map) {
		// 1、设置从第几页开始，每页显示几条
		PageHelper.startPage(startPage, 10);
		// 2、查询，使用了aop
		List<BrandInfo> list = service.getAll();
		// 3、封装到pageInfo
		PageInfo<BrandInfo> pageInfo = new PageInfo<>(list, 3);
		map.put("pageInfo", pageInfo);
		return "BrandInfoList";
	}

	// 通过商品品牌名字来找
	@RequestMapping(value = "/getByName/{pageNum}")
	public String getBrandInfoByName(HttpServletRequest request, @PathVariable(name = "pageNum") Integer startPage, ModelMap map) {
		String brandName = request.getParameter("brandName");
		List<BrandInfo> list = null;
		PageHelper.startPage(startPage, 10);
		if (brandName==null ||"".equals(brandName.trim())) {
			list=service.getAll();
		}
		// 1、设置从第几页开始，每页显示几条
		if (brandName != null && !brandName.trim().equals("")) {

			list = service.getBrandInfoByName(brandName);
		}
		// 3、封装到pageInfo
		PageInfo<BrandInfo> pageInfo = new PageInfo<>(list, 3);
		map.put("pageInfo", pageInfo);
		map.put("pageType", "queryByName");
		map.put("brandName", brandName);
		return "BrandInfoList";
	}

	// 添加一个
	@RequestMapping("addBrandInfo")
	@ResponseBody
	public String addBrandInfo(BrandInfo brandInfo) {
		try {
			int row = service.addBrandInfo(brandInfo);
			if (row == 1) {
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

	// 通过id来查找
	@RequestMapping("/getBrandInfoById/{id}")
	public String getBrandInfoById(@PathVariable Integer id, ModelMap map) {
		BrandInfo brandInfo = service.getBrandInfoById(id);
		map.put("brandInfo", brandInfo);
		return "BrandInfo";
	}

	// delete brandinfo by id
	@RequestMapping("deleteOne")
	@ResponseBody
	public String deleteById(Integer id) {
		try {
			int row = service.deleteById(id);
			if (row == 1) {
				return "ok";
			}
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "fail";
	}

	// 批量删除
	@RequestMapping("deleteMany")
	@ResponseBody
	public String deleteMany(Integer[] ids) {
		try {
			int row = service.deleteBatchByIds(ids);
			if (row == ids.length) {
				return "ok";
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

	// 修改前的回显
	@RequestMapping("toUpdate")
	@ResponseBody
	public BrandInfo toUpdate(Integer id) {

		return service.getBrandInfoById(id);
	}

	// 修改数据
	@RequestMapping("updateBrandInfo")
	@ResponseBody
	public String updateBrandInfo(BrandInfo brandInfo) {
		try {
			int row = service.updateBrandInfo(brandInfo);
			if (row == 1) {
				return "ok";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

	/********** getter and setter *******************/
	public IBrandInfoService getService() {
		return service;
	}

	public void setService(IBrandInfoService service) {
		this.service = service;
	}

}
