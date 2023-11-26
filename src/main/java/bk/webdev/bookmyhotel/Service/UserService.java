package bk.webdev.bookmyhotel.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bk.webdev.bookmyhotel.Dao.HotelDao;
import bk.webdev.bookmyhotel.Model.Hotel;
import bk.webdev.bookmyhotel.Model.HotelWrapper;

@Service
public class UserService {

    @Autowired
    private HotelDao hotelDao;



    public ResponseEntity<List<HotelWrapper>> getAllHotels() {
        List<Hotel> hotelsList = hotelDao.findAll();
        List<HotelWrapper> allHotels = new ArrayList<>();
        for (Hotel h : hotelsList) {
            HotelWrapper hw = new HotelWrapper(h);
            allHotels.add(hw);
        }
        return new ResponseEntity<>(allHotels,HttpStatus.OK);
    }



    public ResponseEntity<HotelWrapper> getHotelInfo(int id) {

        Optional<Hotel> hotelOptional = hotelDao.findById(id);
        if(!hotelOptional.isPresent())
        {
            throw new IllegalStateException("No Hotel Found With Such Id");
        }

        return new ResponseEntity<>(new HotelWrapper(hotelOptional.get()),HttpStatus.OK);
    }

}
