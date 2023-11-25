package bk.webdev.bookmyhotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bk.webdev.bookmyhotel.Model.Hotel;
import bk.webdev.bookmyhotel.Service.AdminService;

@RequestMapping("admin")
@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService = new AdminService();

    @PostMapping("addhotel")
    public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
        System.out.println("adding");
        return adminService.addHotel(hotel);
    }

    @GetMapping("allhotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return adminService.getAllHotels();
    }

}
