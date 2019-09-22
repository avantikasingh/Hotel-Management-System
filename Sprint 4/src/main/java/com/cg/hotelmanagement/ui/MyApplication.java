package com.cg.hotelmanagement.ui;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

		AdminService adminService = new AdminService();

		//ICustomerService customerService = new CustomerService();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
			BigInteger cityId, hotelId, roomId = null;
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
						
						    adminService.addCity(BigInteger.valueOf(++cityIdSys), cityName);
						
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
						cityId = new BigInteger(input);
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
						// BigInteger cityId1;
						System.out.println("Enter city Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = new BigInteger(input);
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
								cityId = new BigInteger(input);
								break;
							}
						}

						System.out.println("Enter Hotel Id to be removed:");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = new BigInteger(input);
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
								cityId = new BigInteger(input);
								break;
							}
						}
						System.out.println("Enter hotel id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = new BigInteger(input);
								break;
							}
						}
						Hotel hotel = adminService.showHotel(cityId).get(hotelId);
						if (hotel == null)
							System.out.println("Hotel does not exist");
						else {
							System.out.println("Enter new Hotel name");
							hotelName = sc.next(); // can have alphanumeric
							//adminService.updateHotel(cityId, hotelId, hotelName);
						}
						break;

					case 7: {

						System.out.println("Enter City Id in which Room is to be added :");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = new BigInteger(input);
								break;
							}
						}
						System.out.println("Enter Hotel Id in which Room is to be added:");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = new BigInteger(input);
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
						adminService.addRoom(cityId, hotelId, BigInteger.valueOf(++roomIdSys), roomType, roomRent,
								roomNumber);
						break;
					}

					case 8: {

						System.out.println("Enter City Id in which Room is to be removed :");
						BigInteger cityId4 = sc.nextBigInteger();

						System.out.println("Enter Hotel Id in which Room is to be removed:");
						BigInteger hotelId3 = sc.nextBigInteger();

						System.out.println("Enter Room Id to be removed :");
						BigInteger roomId1 = sc.nextBigInteger();

						adminService.removeRoom(cityId4, hotelId3, roomId1);

						break;
					}

					case 9: {
						System.out.println("Enter City Id in which Room is to be updated :");
						cityId = sc.nextBigInteger();

						System.out.println("Enter Hotel Id in which Room is to be updated:");
						hotelId = sc.nextBigInteger();

						System.out.println("Enter Room Id to be updated :");
						roomId = sc.nextBigInteger();
						try {
							Room room = adminService.showCity().get(cityId).getHotelList().get(hotelId).getRoomList()
									.get(roomId);
							if (room == null)
								System.out.println("Room does not exist");
							else {
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
								//adminService.updateRoom(cityId, hotelId, roomId, roomType);
							}
						} catch (Exception e) {
							System.out.println("Does not exist");
						}
						break;

					}

					case 10: {
						Map<BigInteger, City> cityMap = adminService.showCity();
						for (Entry<BigInteger, City> entry : cityMap.entrySet()) {
							System.out.println("City Id = " + entry.getKey() + ", City Name = " + entry.getValue());
						}
						break;
					}

					case 11: {
						System.out.println("Enter city Id");
						BigInteger cityId1;
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId1 = new BigInteger(input);
								break;
							}
						}
						Map<BigInteger, Hotel> hotelMap = adminService.showHotel(cityId1);
						if(hotelMap!=null){
							for (Entry<BigInteger, Hotel> entry : hotelMap.entrySet()) {
								System.out.println(entry.getValue().toString());
								System.out.println("Hotel Id: "+entry.getValue().getHotelId());
								System.out.println("Hotel name: "+entry.getValue().getHotelName());
								System.out.println("Hotel address: "+entry.getValue().getHotelAddress());
								System.out.println("Hotel phone number: "+entry.getValue().getHotelPhoneNumber());
								System.out.println("Hotel rating: "+entry.getValue().getHotelRating());
								
							}
						}
						else
							System.out.println("Does not exist");
						break;
					}

					case 12: {
						System.out.println("Enter city Id");
						BigInteger cityId1;
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId1 = new BigInteger(input);
								break;
							}
						}
						System.out.println("Enter hotel Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								hotelId = new BigInteger(input);
								break;
							}
						}
						Map<BigInteger, Room> roomMap = adminService.showRoom(cityId1, hotelId);
						for (Entry<BigInteger, Room> entry : roomMap.entrySet()) {
							System.out.println(entry.getValue().toString());
						}
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
				System.out.println("Enter city id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						cityId = new BigInteger(input);
						break;
					}
				}
				System.out.println("Enter hotel id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						hotelId = new BigInteger(input);
						break;
					}
				}
				System.out.println("Enter room id");
				while (true) {
					input = sc.next();
					if (Validate.isNumeric(input)) {
						roomId = new BigInteger(input);
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
//						BigInteger userId;
//						System.out.println("Enter userId");
//						while (true) {
//							input = sc.next();
//							if (Validate.isNumeric(input)) {
//								userId = new BigInteger(input);
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
						Date dateOfBirth;
						System.out.println("Enter dateOfBirth");
						while (true) {
							input = sc.next();
							try {
								Date date = dateFormat.parse(input);
								break;

							} catch (ParseException e) {
								System.out.println("Enter date in proper format");
								continue;
							}
						}
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
								firstName = Validate.isStringOnlyAlphabet(input);
								break;

							} catch (HotelException e) {
								System.out.println(e.getMessage());
								continue;
							}
						}
						BigInteger aadharNumber;
						System.out.println("Enter aadhar number");
						while (true) {
							input = sc.next();
							if (Validate.aadhar(input)) {
								aadharNumber = new BigInteger(input);
								break;
							}
						}

						//customerService.register(BigInteger.valueOf(userIdSys++), null, firstName, lastName,
						//		aadharNumber);

						// customerService.register(userId,username,emailId,dateOfBirth,userMobileNo);
						break;
					}
					case 2: {
						System.out.println("Enter city Id");
						while (true) {
							input = sc.next();
							if (Validate.isNumeric(input)) {
								cityId = new BigInteger(input);
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
		System.out.println("Enter 1 to Add a City");
		System.out.println("Enter 2 to Remove a City");
		// System.out.println("Enter 3 to Update a City");
		System.out.println("Enter 4 to Add a Hotel");
		System.out.println("Enter 5 to Remove a Hotel");
		System.out.println("Enter 6 to Update a Hotel");
		System.out.println("Enter 7 to Add a Room");
		System.out.println("Enter 8 to Remove a Room");
		System.out.println("Enter 9 to Update a Room");
		System.out.println("Enter 10 to Show a City");
		System.out.println("Enter 11 to Show a Hotel");
		System.out.println("Enter 12 to Show a Room");
		System.out.println("Enter 13 to exit");
	}

	public static void printLoggedInUserDetails() {
		System.out.println("Enter 1 to Register");
		System.out.println("Enter 2 to view hotels");
		System.out.println("Enter 3 to exit");
	}

	public static void printCustomerDetails() {
		System.out.println("Enter 1 to make booking");
		System.out.println("Enter 2 to exit");
	}

}
