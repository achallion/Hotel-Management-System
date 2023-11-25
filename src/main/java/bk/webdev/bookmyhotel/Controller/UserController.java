package bk.webdev.bookmyhotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bk.webdev.bookmyhotel.Model.Hotel;
import bk.webdev.bookmyhotel.Model.HotelWrapper;
import bk.webdev.bookmyhotel.Service.UserService;

@RestController
@RequestMapping("userapi")
public class UserController {

    @Autowired
    private UserService hotelService;

    @GetMapping("{id}")
    public Hotel getHotelInfo(@PathVariable int id) {
        return new Hotel();
    }

    @GetMapping("allhotels")
    public ResponseEntity<List<HotelWrapper>> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
