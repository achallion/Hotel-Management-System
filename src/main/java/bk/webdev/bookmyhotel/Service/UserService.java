package bk.webdev.bookmyhotel.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bk.webdev.bookmyhotel.Dao.HotelDao;
import bk.webdev.bookmyhotel.Dao.UserDao;
import bk.webdev.bookmyhotel.Model.Hotel;
import bk.webdev.bookmyhotel.Model.HotelWrapper;
import bk.webdev.bookmyhotel.Model.User;

@Service
public class UserService {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private UserDao userDao;

    public ResponseEntity<List<HotelWrapper>> getAllHotels() {
        List<Hotel> hotelsList = hotelDao.findAll();
        List<HotelWrapper> allHotels = new ArrayList<>();
        for (Hotel h : hotelsList) {
            HotelWrapper hw = new HotelWrapper(h);
            allHotels.add(hw);
        }
        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }

    public ResponseEntity<HotelWrapper> getHotelInfo(int id) {

        Optional<Hotel> hotelOptional = hotelDao.findById(id);
        if (!hotelOptional.isPresent()) {
            throw new IllegalStateException("No Hotel Found With Such Id");
        }

        return new ResponseEntity<>(new HotelWrapper(hotelOptional.get()), HttpStatus.OK);
    }

    public ResponseEntity<String> bookHotel(int id, int numRooms) {
        Optional<Hotel> hotelOptional = hotelDao.findById(id);
        if (!hotelOptional.isPresent())
            throw new IllegalStateException("No Hotel Found With Such Id");
        Hotel hotel = hotelOptional.get();
        try {
            hotel.bookRooms(numRooms);
            hotelDao.save(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Booking Successfully Done", HttpStatus.OK);
    }

    public ResponseEntity<String> addUser(User user) {
        Optional<User> userOptional = userDao.existsByEmail(user.getEmail());
        if (userOptional.isPresent())
            return new ResponseEntity<>("User With Same Email Already Exists at id : " + userOptional.get().getEmail(),
                    HttpStatus.NOT_MODIFIED);
        try {
            user.generateAccessToken();
            userDao.save(user);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return new ResponseEntity<>("Successfully Created User at ID : " + user.getId(), HttpStatus.CREATED);
    }

}
