package bk.webdev.bookmyhotel.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Hotel {
    @Id
    @SequenceGenerator(name = "hotel_id_gen", sequenceName = "hotel_seq", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_gen")
    private int id;
    private int totalRooms, occupiedRooms, price;
    private String owner, name, contact;

    public int getId() {
        return this.id;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalRooms() {
        return this.totalRooms;
    }

    public int getOccupiedRooms() {
        return this.occupiedRooms;
    }

    public int getFreeRooms() {
        return this.totalRooms - this.occupiedRooms;
    }

    public String getContact()
    {
        return this.contact;
    }

    public int getPrice() {
        return this.price;
    }
  
}
