package com.cg.hotelmanagement.dto;


public class Room {
	private String roomId;
	private String roomType;
	private Double roomRent;
	private String roomNumber;
	private String roomDescription;
	
	public Room() {
	}
	
	public Room(String roomId, String roomType, Double roomRent, String roomNumber, String roomDescription) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
		this.roomDescription = roomDescription;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(Double roomRent) {
		this.roomRent = roomRent;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomDescription == null) ? 0 : roomDescription.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((roomRent == null) ? 0 : roomRent.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomDescription == null) {
			if (other.roomDescription != null)
				return false;
		} else if (!roomDescription.equals(other.roomDescription))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (roomRent == null) {
			if (other.roomRent != null)
				return false;
		} else if (!roomRent.equals(other.roomRent))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRent=" + roomRent + ", roomNumber="
				+ roomNumber + ", roomDescription=" + roomDescription + "]";
	}
	
	
	
	
	

}
