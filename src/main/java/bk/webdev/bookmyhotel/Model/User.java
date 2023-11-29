package bk.webdev.bookmyhotel.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username, contact, password, accessToken;
    private Integer age;
    @Column(unique = true)
    private String email;

    // @ManyToMany
    // private List<HotelWrapper> hotelHistory;

    @ManyToMany(targetEntity = Hotel.class, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH })
    private List<HotelWrapper> currentHotels;

    private String generateHash(String str) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] sha256Hash = sha256.digest(str.getBytes());
        String sha256HashString = new BigInteger(1, sha256Hash).toString(16);
        return sha256HashString.substring(0, 10);
    }

    public void generateAccessToken(int unique) throws NoSuchAlgorithmException {
        System.out.println(this.getId());
        this.accessToken = generateHash(email) + unique + generateHash(password);
    }
}
