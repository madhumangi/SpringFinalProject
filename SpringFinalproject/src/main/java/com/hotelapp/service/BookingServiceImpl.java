package com.hotelapp.service;

import com.hotelapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelapp.respository.IBookingRepository;

import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService{

    private IBookingRepository bookingRepository;
    @Autowired
    public void setBookingRepository(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking getBookingById(int bookingId) {
           return bookingRepository.findById(bookingId).get();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
