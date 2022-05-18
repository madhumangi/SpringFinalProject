package com.hotelapp.respository;

import com.hotelapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Integer> {

    //derived queries

    /**
     * This method will allow us to filter hotels by property type
     * @param propertyType
     * @return List of hotels
     */
    List<Hotel> findByPropertyType(String propertyType);

    /**
     * This method will allow us to filter hotels by star ratings(5 star/4 star so on)
     * @param starRatings
     * @return List of hotels
     */
    List<Hotel> findByStarRatings(String starRatings);

    /**
     *
     * @param hotelName
     * @return
     */
    List<Hotel> findByHotelNameStartingWith(String hotelName);



    /**
     * This method will allow us to filter hotels by any of its facilities
     * @param facility
     * @return List of hotels
     */
//    List<Hotel> findByFacilityChoice(String facility);

//    List<Hotel> findByPriceLessThan(double price);

    // Customized queries

//    @Query("from Hotel h where h.ratings>=?1 and h.starRatings=?2")
//    List<Hotel> findByRatingsAndStarRatings(float ratings,String starRatings);
//
//    @Query("from Hotel h where h.ratings>=?1 and h.propertyType=?2")
//    List<Hotel> findHotelByRatingsAndPropertyType(float ratings, String propertyType);
//
//    @Query("from Hotel h inner join h.address a where a.city=?1 and h.ratings>=?2")
//    List<Hotel> findHotelByCityAndRatings(String city,float ratings);
//
//    @Query("from hotel h inner join h.rooms r where r.roomType=?1")
//    List<Hotel> findByRoomType(String roomType);



//    List<Hotel> findByCancellationAvailable(boolean cancellation);
//    List<Hotel> findByBookNowPayLater(boolean payLater);
//    List<Hotel> findByBreakfastIncluded(boolean breakfast);
//    List<Hotel> findByPayAtHotel(boolean payAtHotel);
}
