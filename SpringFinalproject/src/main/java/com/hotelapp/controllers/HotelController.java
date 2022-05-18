package com.hotelapp.controllers;
import com.hotelapp.model.*;
import com.hotelapp.service.IFacilityService;
import com.hotelapp.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("hotel-api")
public class HotelController {

    private IHotelService hotelService;
    @Autowired
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    private IFacilityService facilityService;

    @Autowired
    public void setFacilityService(IFacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("/hotels")
    ResponseEntity<Void> addHotel(@RequestBody Hotel hotel){
//        Set<Booking> bookings = hotel.getBookings();
//        Set<Customer> customer = hotel.getCustomers();
//        for (Booking booking : bookings) {
//            booking.setCustomer((Customer)customer.toArray()[0]);
//        }

        Set<Facilities> facilities=hotel.getFacilities();
        Set<Facilities> facilitiesSet = new HashSet<>();
        for(Facilities facility: facilities){
            Facilities obj = facilityService.getFacilityById(facility.getFacilityId());
            facilitiesSet.add(obj);
        }
        hotel.setFacilities(facilitiesSet);

       // hotel.setFacilities(facilities);
        List<Rooms> rooms = hotel.getRooms();
        rooms.forEach(room -> room.setHotel(hotel));
        hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/hotels")
    ResponseEntity<Void> updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/hotels/id/{hotelId}")
    ResponseEntity<Void> deleteHotel(@PathVariable("hotelId")int hotelId){
        hotelService.deleteHotel(hotelId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting hotel by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/hotels/id/{hotelId}")
    ResponseEntity<Hotel> showHotelById(@PathVariable("hotelId")int hotelId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one hotel by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelById(hotelId));
    }

    @GetMapping("/hotels")
    ResponseEntity<List<Hotel>> showAllHotels(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getAllHotels());
    }

//    ResponseEntity<List<Hotel>> getByPropertyType(String propertyType){
//
//    }
//
//    ResponseEntity<List<Hotel>> getByStarRatings(String starRatings) {
//
//    }
//    ResponseEntity<List<Hotel>> getByNameStartingWith(String hotelName) {
//
//    }
//
//    ResponseEntity<List<Hotel>> getByFacilityChoice(String facility) {
//
//    }
//    ResponseEntity<List<Hotel>> getByPriceLessThan(double price) {
//
//    }
//
//    ResponseEntity<List<Hotel>> getByRatingsAndStarRatings(float ratings,String starRatings) {
//
//    }
//    ResponseEntity<List<Hotel>> getHotelByRatingsAndPropertyType(float ratings, String propertyType) {
//
//    }
//    ResponseEntity<List<Hotel>> getHotelByCityAndRatings(String city,float ratings) {
//
//    }
//    ResponseEntity<List<Hotel>> getByRoomType(String roomType) {
//
//    }
}
