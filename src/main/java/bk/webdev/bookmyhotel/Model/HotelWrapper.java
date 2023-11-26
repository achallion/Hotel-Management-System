package bk.webdev.bookmyhotel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelWrapper {
    private int id;
    private String name, owner, contact;
    private int price, occupiedRooms;

    public HotelWrapper(Hotel hotel) {
        this(hotel.getId(), hotel.getName(), hotel.getOwner(), hotel.getContact(), hotel.getPrice(), hotel.getOccupiedRooms());
    }

}
