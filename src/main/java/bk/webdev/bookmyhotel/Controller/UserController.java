package bk.webdev.bookmyhotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bk.webdev.bookmyhotel.Model.HotelWrapper;
import bk.webdev.bookmyhotel.Model.User;
import bk.webdev.bookmyhotel.Service.UserService;

@RestController
@RequestMapping("userapi")
public class UserController {

    @Autowired
    private final UserService userService = new UserService();

    @GetMapping("{id}")
    public ResponseEntity<HotelWrapper> getHotelInfo(@PathVariable int id) {
        return userService.getHotelInfo(id);
    }

    @GetMapping("allhotels")
    public ResponseEntity<List<HotelWrapper>> getAllHotels() {
        return userService.getAllHotels();
    }

    @PostMapping("book/{hotelId}")
    public ResponseEntity<String> bookHotel(@PathVariable("hotelId") int id, @RequestParam("num_rooms") int numRooms) {
        return userService.bookHotel(id, numRooms);
    }

    @PostMapping("user/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
