package bk.webdev.bookmyhotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bk.webdev.bookmyhotel.Model.Hotel;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

    
}
