package com.cg.hotelmanagement.ui;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyApplication {
	static long userIdSys = 1000;
	static long hotelIdSys = 1;
	static long roomIdSys = 4000;
	static long cityIdSys = 1;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		IAdminService adminService = new AdminService();
		
		
		ICustomerService customerService = new CustomerService();

		//ICustomerService customerService = new CustomerService();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		//adminService.makeBooking(2l, 1l, dateFormat.parse("2019-04-07"), dateFormat.parse("2019-05-08"), 1l, 1l);
		
		//adminService.updateHotel(2l, 1l, "Trident");
		
		//adminService.updateRoom(2l, 1l, 1l, "Premium");
		
//		try {
//			adminService.addCity(BigInteger.valueOf(cityIdSys), "Pune");
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		adminService.addHotel(BigInteger.valueOf(cityIdSys), "Taj", "Pune",
//				"8108734667", 4.9f);
//
//		adminService.addRoom(BigInteger.valueOf(cityIdSys), BigInteger.valueOf(hotelIdSys),
//				BigInteger.valueOf(roomIdSys), "Standard", 2000d, "101");

		String input;

		
		int role = 0;int adminChoice = 0;
		do {
			System.out.println("Specify Role :\n1 for Admin\n2 for Customer\n3 For GuestUser\n4 Exit");
			Long cityId;
			Long hotelId, roomId = null;
			String hotelName, hotelAddress, hotelPhone;
			role = 0;adminChoice = 0;
			while (true) {
				String s = sc.next();
				try {
					role = Integer.parseInt(s);
					break;
				} catch (Exception e) {
					System.out.println("Enter valid choice");
				}
			}
			
			switch (role) {

			case 1:
				do {
					printAdminDetails();
					while (true) {
						String s = sc.next();
						try {
							adminChoice = Integer.parseInt(s);
							break;
						} catch (Exception e) {
							System.out.println("Enter valid choice");
						}
					}

					switch (adminChoice) {
					case 1: {
						String cityName = new String();
						System.out.println("Enter new City Name");
						while (true) {
							input = sc.next();
							try {
								cityName = Validate.isStringOnlyAlphabet(input);
								break;
							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						
						    adminService.addCity(++cityIdSys, cityName);
						
//						catch(Exception e){
//							System.out.println("City already exists");
//						}
						break;
					}

					case 2: {
						System.out.println("Enter City Id to be Removed :");

						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input))
								break;
						}
						cityId = Long.parseLong(input);
						adminService.removeCity(cityId);
						break;
					}

					// ////////////////////////
					// case 3:{
					// System.out.println("Enter Hotel Id to be updated :");
					// BigInteger hotelId;
					// while(true) {
					// input=sc.next();
					// if(Validate.isNumeric(input)){
					// hotelId=new BigInteger(input);
					// break;
					// }
					// }
					//
					//
					// break;
					// }

					case 4: {
						// Long cityId1;
						System.out.println("Enter city Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = new Long(input);
								break;
							}
						}
						System.out.println("Enter new Hotel Details");
						System.out.println("Hotel Name:"); // can have alphanumeric
						hotelName = sc.next();
						System.out.println("Hotel Address:"); // can have alphanumeric
						hotelAddress = sc.next();
						System.out.println("Hotel Contact No:");
						while (true) {
							input = sc.next();
							try {
								hotelPhone = Validate.validateMobileNumber(input);
								break;
							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						System.out.println("Hotel Rating:");

						float hotelRating;

						while (true) {
							String s = sc.next();
							try {
								hotelRating = Float.parseFloat(s);
								break;
							} catch (Exception e) {
								System.out.println("Enter Rating in valid format");
							}
						}

						adminService.addHotel(cityId, hotelName, hotelAddress,
								hotelPhone, hotelRating);

						break;
					}

					case 5:

						System.out.println("Enter City Id in which Hotel is to be removed :");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = Long.parseLong(input);
								break;
							}
						}

						System.out.println("Enter Hotel Id to be removed:");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = new Long(input);
								break;
							}
						}

						adminService.removeHotel(cityId, hotelId);

						break;

					case 6:
						System.out.println("City id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = Long.parseLong(input);
								break;
							}
						}
						System.out.println("Enter hotel id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = Long.parseLong(input);
								break;
							}
						}
//						Hotel hotel = adminService.showHotel(cityId).get(hotelId);
//						if (hotel == null)
//							System.out.println("Hotel does not exist");
//						else {
//							System.out.println("Enter new Hotel name");
//							hotelName = sc.next(); // can have alphanumeric
//							//adminService.updateHotel(cityId, hotelId, hotelName);
//						}
						hotelName = sc.next();
						if(adminService.updateHotel(cityId, hotelId, hotelName)) {
							System.out.println("Updated successfully");
						}
						else {
							System.out.println("City/Hotel does not exist");
						}
						break;

					case 7: {

						System.out.println("Enter City Id in which Room is to be added :");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = Long.parseLong(input);
								break;
							}
						}
						System.out.println("Enter Hotel Id in which Room is to be added:");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = Long.parseLong(input);
								break;
							}
						}
						System.out.println("Enter new Room Details");
						System.out.println("Room Type:");
						String roomType = sc.next();
						System.out.println("Room Rent:");
						double roomRent;
						while (true) {
							String s = sc.next();
							try {
								roomRent = Double.parseDouble(s);
								break;
							} catch (Exception e) {
								System.out.println("Enter valid choice");
							}
						}
						System.out.println("Room No:");
						String roomNumber = sc.next(); // Room no can be alphanumeric
						adminService.addRoom(cityId, hotelId, ++roomIdSys, roomType, roomRent,
								roomNumber);
						break;
					}

					case 8: {

						System.out.println("Enter City Id in which Room is to be removed :");
						Long cityId4 = sc.nextLong();

						System.out.println("Enter Hotel Id in which Room is to be removed:");
						Long hotelId3 = sc.nextLong();

						System.out.println("Enter Room Id to be removed :");
						Long roomId1 = sc.nextLong();

						adminService.removeRoom(cityId4, hotelId3, roomId1);

						break;
					}

					case 9: {
						System.out.println("Enter City Id in which Room is to be updated :");
						cityId = sc.nextLong();

						System.out.println("Enter Hotel Id in which Room is to be updated:");
						hotelId = sc.nextLong();

						System.out.println("Enter Room Id to be updated :");
						roomId = sc.nextLong();
						String roomType;
						System.out.println("Enter new room type");
						while (true) {
							input = sc.next();
							try {
								roomType = Validate.isStringOnlyAlphabet(input);
								break;
							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						if(adminService.updateRoom(cityId, hotelId, roomId, roomType))
							System.out.println("Room updated successfully");
						else
							System.out.println("City/Hotel does not exist");
//						try {
//							Room room = adminService.showCity().get(cityId).getHotelList().get(hotelId).getRoomList()
//									.get(roomId);
//							if (room == null)
//								System.out.println("Room does not exist");
//							else {
//								String roomType;
//								System.out.println("Enter new room type");
//								while (true) {
//									input = sc.next();
//									try {
//										roomType = Validate.isStringOnlyAlphabet(input);
//										break;
//									} catch (HotelException e) {
//										System.out.println(e.getMessage());
//										continue;
//									}
//								}
//								//adminService.updateRoom(cityId, hotelId, roomId, roomType);
//							}
//						} catch (Exception e) {
//							System.out.println("Does not exist");
//						}
						break;

					}

					case 10: {
						List<City> cityList = adminService.showCity();
						for(City city:cityList)
							System.out.println(city.getCityId()+" "+city.getCityName());
						break;
					}

					case 11: {
						System.out.println("Enter city Id");
						Long cityId1;
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId1 = Long.parseLong(input);
								break;
							}
						}
						List<Hotel> hotelList = adminService.showHotel(cityId1);
						if(hotelList!=null){
							for(Hotel hotel:hotelList)
								System.out.println(hotel.getHotelId()+" "+hotel.getHotelName()+" "+hotel.getHotelAddress()+" "+hotel.getHotelPhoneNumber()+" "+hotel.getHotelRating());
						}
						else
							System.out.println("Does not exist");
						break;
					}

					case 12: {
						System.out.println("Enter city Id");
						Long cityId1;
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId1 = Long.parseLong(input);
								break;
							}
						}
						System.out.println("Enter hotel Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = Long.parseLong(input);
								break;
							}
						}
						List<Room> roomList = adminService.showRoom(cityId1, hotelId);
						for(Room room:roomList)
							System.out.println(room.getRoomId()+" "+room.getRoomNumber()+" "+room.getRoomType()+" "+room.getRoomRent());
						break;
					}
					case 13:
						break;
					default :
						System.out.println("Enter a valid choice");
					
					}
				} while (adminChoice != 13);
				break;

			case 2: {
				System.out.println("Enter details to Make Booking");
				System.out.println("Enter checkIn date in yyyy-MM-dd format");
				Date checkIn, checkOut;
				while (true) {
					input = sc.next();
					try {
						checkIn = dateFormat.parse(input);
						String[] checkInStr = input.split("-");
						if(Integer.parseInt(checkInStr[1])<13 && Integer.parseInt(checkInStr[1])<32)
							break;
						else
							throw new HotelException("Enter date in correct format");
					} catch (Exception e) {
						System.out.println("Enter date in correct format");
						continue;
					}
				}
				System.out.println("Enter check out date in yyyy-MM-dd");
				while (true) {
					input = sc.next();
					try {
						checkOut = dateFormat.parse(input);
						String[] checkOutStr = input.split("-");
						if(Integer.parseInt(checkOutStr[1])<13 && Integer.parseInt(checkOutStr[1])<32)
							break;
						else
							throw new HotelException("Enter date in correct format");
					} catch (Exception e) {
						System.out.println("Enter date in correct format");
						continue;
					}
				}
				if(!Validate.validateCheckInCheckOutDate(checkIn, checkOut)) {
					System.out.println("Check In date should be less than Check out");
					break;
				}
				System.out.println("Enter city id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						cityId = Long.parseLong(input);
						break;
					}
				}
				System.out.println("Enter hotel id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						hotelId = Long.parseLong(input);
						break;
					}
				}
				System.out.println("Enter room id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						roomId = Long.parseLong(input);
						break;
					}
				}
				//customerService.makeBooking(cityId, hotelId, checkIn, checkOut,
				//		roomId, adminService);
				break;
			}

			case 3: {
				int choiceForUser;
				do {
					printLoggedInUserDetails();
					choiceForUser = sc.nextInt();
					switch (choiceForUser) {
					case 1: {
//						Long userId;
//						System.out.println("Enter userId");
//						while (true) {
//							input = sc.next();
//							if (Validate.isNumeric(input)) {
//								userId = new Long(input);
//								break;
//							}
//						}
						String username;
						System.out.println("Enter username");
						while (true) {
							input = sc.next();
							try {
								username = Validate.isUsernameValid(input);
								break;
							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						String emailId;
						System.out.println("Enter emailId");
						while (true) {
							input = sc.next();
							try {
								emailId = Validate.validateEmail(input);
								break;
							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						
						LocalDate dateOfBirth = null;
						System.out.println("Enter dateOfBirth in yyyy-mm-dd");
					
						input = sc.next();
							
						dateOfBirth = LocalDate.parse(input);

						String userMobileNo;
						System.out.println("Enter mobile number");
						while (true) {
							input = sc.next();
							try {
								userMobileNo = Validate.validateMobileNumber(input);
								break;

							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						String firstName;
						System.out.println("Enter First name");
						while (true) {
							input = sc.next();
							try {
								firstName = Validate.isStringOnlyAlphabet(input);
								break;

							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						String lastName = null;
						System.out.println("Enter Last Name");
						while (true) {
							input = sc.next();
							try {
								lastName = Validate.isStringOnlyAlphabet(input);
								break;

							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						
						String gender;
						System.out.println("Enter Gender(Male/Female/Other)");
						gender=sc.next();
						
						
						BigInteger aadharNumber;
						System.out.println("Enter aadhar number");
						while (true) {
							input = sc.next();
							if (Validate.aadhar(input)) {
								aadharNumber = new BigInteger(input);
								break;
							}
						}

						customerService.register(firstName, lastName, gender,username, emailId, dateOfBirth, userMobileNo,aadharNumber.toString());
						break;
					}
					case 2: {
						System.out.println("Enter city Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = Long.parseLong(input);
								break;
							}
						}
						// BigInteger hotelId = null;
						// while(true) {
						// input = sc.next();
						// if(Validate.isNumeric(input)) {
						// hotelId =new BigInteger(input);
						// break;
						// }
						// }
						//customerService.viewHotels(cityId, adminService);
						break;
					}
					case 3:
						break;
					default:
					System.out.println("Enter a proper choice");
					break;
					}

				} while (choiceForUser != 3);
			}
			case 4:
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}
		}while(role!=4);
		// while (role != 1 || role != 2 || role != 3);

		sc.close();

	}

	public static void printAdminDetails() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Enter choice between 1 to 13");
		System.out.println("1: Add a City");
		System.out.println("2: Remove a City");
		// System.out.println("Enter 3 to Update a City");
		System.out.println("4: Add a Hotel");
		System.out.println("5: Remove a Hotel");
		System.out.println("6: Update a Hotel");
		System.out.println("7: Add a Room");
		System.out.println("8: Remove a Room");
		System.out.println("9: Update a Room");
		System.out.println("10: Show a City");
		System.out.println("11: Show a Hotel");
		System.out.println("12: Show a Room");
		System.out.println("13: Exit");
		System.out.println("---------------------------------------------------------");
	}

	public static void printLoggedInUserDetails() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Enter choice between 1 to 3");
		System.out.println("1: Register");
		System.out.println("2: View hotels");
		System.out.println("3: Exit");
		System.out.println("---------------------------------------------------------");
	}

	public static void printCustomerDetails() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Enter choice between 1 to 2");
		System.out.println("1: Make booking");
		//System.out.println("2: View booking");
		System.out.println("2: Exit");
		System.out.println("---------------------------------------------------------");
	}

}
