package com.cg.hotelmanagement.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.cg.hotelmanagement.dto.City;



public class ExcelReportView extends AbstractXlsView{
	 
	 @Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	 HttpServletResponse response) throws Exception {
	  
	 response.setHeader("Content-Disposition", "attachment;filename=\"cityData.xls\"");
	 List<City> cityList = (List<City>) model.get("cityList");
	 Sheet sheet = workbook.createSheet("User Data");
	 Row header = sheet.createRow(0);
	 header.createCell(0).setCellValue("City ID");
	 header.createCell(1).setCellValue("City Name");

	  
	 int rowNum = 1;
	 for(City city:cityList){
	 Row row = sheet.createRow(rowNum++);
	 row.createCell(0).setCellValue(city.getCityId().longValue());
	 row.createCell(1).setCellValue(city.getCityName());

	 }
	 }
}