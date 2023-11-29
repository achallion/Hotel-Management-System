package bk.webdev.bookmyhotel.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(targetEntity = User.class, mappedBy = "currentHotels", cascade = { CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    List<User> currentUsers;

    // List<User> userHistory;
    

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

    public String getContact() {
        return this.contact;
    }

    public int getPrice() {
        return this.price;
    }

    public void bookRooms(int numRooms) {
        if (this.getFreeRooms() < numRooms)
            throw new IllegalStateException("Required Number Of Free Rooms is not present in " + this.getName());
        this.setOccupiedRooms(this.getOccupiedRooms() + numRooms);
    }

}
