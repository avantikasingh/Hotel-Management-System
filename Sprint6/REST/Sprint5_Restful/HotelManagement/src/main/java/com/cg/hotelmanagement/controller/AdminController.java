package com.cg.hotelmanagement.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.exception.ResourceNotFoundException;
import com.cg.hotelmanagement.service.ExcelGenerator;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins ="http://localhost:4200")
public class AdminController {

	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerService customerService;

	Long cityID = null;
	Long hotelID = null;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	//----------------------City--------------------------
	
	/**
	 * Show all cities
	 * @return
	 * @throws HotelException
	 */
	@GetMapping("/cities")
	public List<City> getCities(){
		logger.trace("getCities in Controller");
		return adminService.showCity();
	}
	
	/**
	 * Find city by cityId
	 * @param cityId
	 * @return
	 */
	@GetMapping("/cities/{cityId}")
	public City getCity(@PathVariable long cityId) {
		logger.trace("getCity in Controller");
		return adminService.findCityById(cityId);
	}
	
	/**
	 * Add city
	 * @param city
	 * @return
	 */
	@PostMapping("/cities")
	public City addCity(@RequestBody City city) {
		logger.trace("addCity in Controller");
		return adminService.addCity(city);
	}
	
	/**
	 * Delete city by cityId
	 */
	@DeleteMapping("/cities/{cityId}")
	public boolean deleteCity(@PathVariable long cityId) {
		logger.trace("deleteCity in Controller"); 
		return adminService.removeCity(cityId);
	}
	
	/**
	 * Download excel
	 * @return File
	 * @throws IOException
	 */
	@GetMapping("/cities/download/cities.xlsx")
	public ResponseEntity<InputStreamResource> downloadCity() throws IOException {
		List<City> cityList = customerService.getCityList();

		ByteArrayInputStream in = ExcelGenerator.customersToExcel(cityList);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
		logger.trace("Download");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	/**
	 * Upload file
	 * @param reapExcelDataFile
	 * @throws IOException
	 */
	@PostMapping("/upload/city")
	public void uploadCity(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);

	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        City tempCity = new City();

	        XSSFRow row = worksheet.getRow(i);

	        tempCity.setCityName(row.getCell(0).getStringCellValue());
	        adminService.addCity(tempCity);
	        workbook.close();
	            
	    }
	}
	
	
	
	//----------------------Hotel--------------------------
	
	/**
	 * Get all hotels in a city
	 * @param cityId
	 * @return
	 */
	@GetMapping("/hotels/{cityId}")
	public List<Hotel> getHotels(@PathVariable long cityId){
		logger.trace("getHotels in Controller");
		List<Hotel> hotelList = adminService.showHotels(cityId);
		if(hotelList.size()==0)			
			throw new ResourceNotFoundException("No hotels in city with Id: "+cityId);
		System.out.println(hotelList);
		return hotelList;
	}
	
	/**
	 * Find a hotel using hotelId
	 * @param hotelId
	 * @return
	 */
	@GetMapping("/hotels")
	public Hotel getHotel(@RequestParam long hotelId){
		logger.trace("getHotel in Controller");
		return adminService.viewSingleHotel(hotelId);
	}
	
	
	/**
	 * Find hotel by Id
	 * @param cityId
	 * @param hotel
	 * @return
	 * @throws HotelException
	 */
	@PostMapping("/hotels")
	public Hotel addHotel(@RequestParam("cityId") long cityId, @RequestBody Hotel hotel) {
		adminService.addHotel(cityId, hotel);
		logger.trace("addHotel in Controller");
		return hotel;
	}
	
	/**
	 * Add hotel
	 * @param hotelId
	 * @param hotel
	 * @return
	 */
	@PutMapping("/hotels")
	public Hotel updateHotel(@RequestParam("hotelId") long hotelId, @RequestBody Hotel hotel) {
		adminService.updateHotel(hotelId, hotel);
		logger.trace("updateHotel in Controller");
		return hotel;
	}
	
	/**
	 * Delete hotel
	 * @param hotelId
	 * @return
	 */
	@DeleteMapping("/hotels/{hotelId}")
	public boolean deleteHotel(@PathVariable long hotelId) {
		logger.trace("deleteHotel in Controller");
		return adminService.removeHotel(hotelId);
	}
	
	
	//----------------------Room--------------------------
	
	/**
	 * Get all rooms in a given city and hotel
	 * @param cityId
	 * @param hotelId
	 * @return
	 */
	@GetMapping("/rooms")
	public List<Room> getRooms(@RequestParam("cityId") long cityId, @RequestParam("hotelId") long hotelId){
		logger.trace("getRooms in Controller");
		return adminService.showRooms(cityId, hotelId);
	}
	
	/**
	 * Find room by Id
	 * @param roomId
	 * @return
	 */
	@GetMapping("/rooms/{roomId}")
	public Room getRoom(@PathVariable long roomId) {
		logger.trace("getRoom in Controller");
		return adminService.viewSingleRoom(roomId);
	}
	
	/**
	 * Add room
	 * @param cityId
	 * @param hotelId
	 * @param room
	 * @return
	 */
	@PostMapping("/rooms")
	public Room addRoom(@RequestParam("cityId") long cityId, @RequestParam("hotelId") long hotelId, @RequestBody Room room) {
		logger.trace("addRoom in Controller");
		return adminService.addRoom(cityId, hotelId, room);
	}
	
	/**
	 * Update room
	 * @param roomId
	 * @param room
	 * @return
	 */
	@PutMapping("/rooms")
	public boolean updateRoom(@RequestParam("roomId") long roomId, @RequestBody Room room) {
		logger.trace("updateRoom in Controller");
		return adminService.updateRoom(roomId, room);
	}
	
	/**
	 * Delete room
	 * @param roomId
	 * @return
	 */
	@DeleteMapping("rooms/{roomId}")
	public boolean deleteRoom(@PathVariable long roomId) {
		logger.trace("deleteRoom in Controller");
		return adminService.removeRoom(roomId);
	}
	
}



