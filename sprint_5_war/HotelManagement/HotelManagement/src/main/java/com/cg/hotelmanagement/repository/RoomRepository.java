package com.cg.hotelmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.hotelmanagement.dto.Room;
public interface RoomRepository extends JpaRepository<Room,Long> {

}
