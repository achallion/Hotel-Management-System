package bk.webdev.bookmyhotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bk.webdev.bookmyhotel.Dao.HotelDao;
import bk.webdev.bookmyhotel.Model.Hotel;

@Service
public class AdminService {
    @Autowired
    private HotelDao hotelDao;

    public ResponseEntity<String> addHotel(Hotel hotel) {
        if (hotel.getOccupiedRooms() > hotel.getTotalRooms())
            return new ResponseEntity<>("Failed To Create A New Hotel as Total Rooms is less than Occupied Rooms.",
                    HttpStatus.BAD_REQUEST);
        try {
            hotelDao.save(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed To Create A New Hotel", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Created New Hotel At Id " + hotel.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> allHotels = hotelDao.findAll();
        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }
}
