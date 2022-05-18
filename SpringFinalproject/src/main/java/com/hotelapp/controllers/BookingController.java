package com.hotelapp.controllers;

import com.hotelapp.model.Address;
import com.hotelapp.service.IBookingService;
import com.hotelapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("booking-api")
public class BookingController {
    
    private IBookingService bookingService;
    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    ResponseEntity<Void> addBooking(@RequestBody Booking booking){

        bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/bookings")
    ResponseEntity<Void> updateBooking(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/bookings/id/{bookingId}")
    ResponseEntity<Void> deleteBooking(@PathVariable("bookingId")int bookingId){
        bookingService.deleteBooking(bookingId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting booking by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/bookings/id/{bookingId}")
    ResponseEntity<Booking> showBookingById(@PathVariable("bookingId")int bookingId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one booking by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( bookingService.getBookingById(bookingId));
    }

    @GetMapping("/bookings")
    ResponseEntity<List<Booking>> showAllBookings(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all bookings.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getAllBookings());
    }
}
