/**
 * 
 */
package com.huawei.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.model.BrandInfo;
import com.huawei.service.IBrandInfoService;

/**
 * @author create by urmagical
 * @date 2018年5月12日 下午7:43:28
 * @version
 */
@Controller()
@RequestMapping("excel")
public class ExcelController {

	// @Autowired
	// private IExcelService excelService;
	@Autowired
	private IBrandInfoService brandInfoService;

	@RequestMapping("exportExcel/{id}")
	@ResponseBody
	public String exportExcel(@PathVariable Integer id) {
		// 拿到要导出的信息对象
		// TODO 此处可以优化，不要再进入数据库查询一次，直接从前端页面带来数据
		BrandInfo brandInfo = brandInfoService.getBrandInfoById(id);
		// 把查到的信息写入表格，并导出
		Resource res = new ClassPathResource("template/EnquiryPriceTemplate.xls");
		InputStream input;
		HSSFWorkbook workbook = null;
		Date date = new Date();
		try {
			input = res.getInputStream();
			// 读取工作薄
			workbook = new HSSFWorkbook(input);
			// 读取工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// B8单元格写入供应商名称
			HSSFRow row8 = sheet.getRow(7);
			HSSFCell cell82 = row8.getCell(1);
			cell82.setCellValue(brandInfo.getBrandName());
			// B9 tel
			HSSFRow row9 = sheet.getRow(8);
			HSSFCell cell92 = row9.getCell(1);
			cell92.setCellValue(brandInfo.getTel());
			// E8 Datum
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String formateStr = sdf.format(date);
			HSSFCell cell85 = row8.getCell(4);
			cell85.setCellValue(formateStr);
			// E9 email
			HSSFCell cell94 = row9.getCell(4);
			cell94.setCellValue(brandInfo.getEmail());
			// C10 、A16单号,用当前时间生成单号
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			formateStr = sdf.format(date);

			HSSFRow row10 = sheet.getRow(9);
			HSSFCell cell102 = row10.getCell(2);
			cell102.setCellValue(formateStr);

			HSSFRow row16 = sheet.getRow(15);
			HSSFCell cell161 = row16.getCell(0);
			cell161.setCellValue(formateStr);

			File file = new File("d:\\" + brandInfo.getBrandName() + ".xls");
			workbook.write(file);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FileNotExist";
		}

		return "ok";
	}

	// 修改模板
	@RequestMapping("updateTemplate")
	@ResponseBody
	public String updateTemplate(HttpServletRequest request) {
		String tel = request.getParameter("tel");
		String fax = request.getParameter("fax");
		String email = request.getParameter("email");
		String identNum = request.getParameter("identNum");

		// 把查到的信息写入表格，并导出
		Resource res = new ClassPathResource("template/EnquiryPriceTemplate.xls");
		InputStream input;
		HSSFWorkbook workbook = null;
		try {
			input = res.getInputStream();
			// 读取工作薄
			workbook = new HSSFWorkbook(input);
			// 读取工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			// A3单元格修改发送人tel
			HSSFRow row3 = sheet.getRow(2);
			HSSFCell cell31 = row3.getCell(0);

			if (tel != null && "" != tel.trim()) {
				cell31.setCellValue("Tel:" + tel);
			}
			// A4单元格修改发送人fax
			HSSFRow row4 = sheet.getRow(3);
			HSSFCell cell41 = row4.getCell(0);

			if (fax != null && "" != fax.trim()) {
				cell41.setCellValue("Fax:" + fax);
			}
			// A5单元格修改发送人email
			HSSFRow row5 = sheet.getRow(4);
			HSSFCell cell51 = row5.getCell(0);

			if (email != null && "" != email.trim()) {
				cell51.setCellValue("E-Mail:" + email);
			}
			// A6单元格修改发送人identNum
			HSSFRow row6 = sheet.getRow(5);
			HSSFCell cell61 = row6.getCell(0);

			if (identNum != null && "" != identNum.trim()) {
				cell61.setCellValue("Umsatzsteuer-Identnummer:" + identNum);
			}
			File file = ResourceUtils.getFile("classpath:template/EnquiryPriceTemplate.xls");  
			workbook.write(file);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "success";
	}
}
