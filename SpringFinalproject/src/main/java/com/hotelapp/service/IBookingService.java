package com.hotelapp.service;

import com.hotelapp.model.Booking;

import java.util.List;

public interface IBookingService{

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(int bookingId);

    Booking getBookingById(int bookingId);

    List<Booking> getAllBookings();
}
