package bk.webdev.bookmyhotel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelWrapper {
    private int id;
    private String name, owner;

}
