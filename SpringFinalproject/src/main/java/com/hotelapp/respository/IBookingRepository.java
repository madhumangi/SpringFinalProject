package com.hotelapp.respository;

import com.hotelapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {

//    List<Booking> findByCheckInDate(LocalDate checkInDate);
//    List<Booking> findByCheckOutDate(LocalDate checkOutDate);
//    List<Booking> findByTotalCostLessThan(double totalCost);
//    List<Booking> findByBillingNo(int billingNo);
//    List<Booking> findByPaymentMode(String paymentMode);
//
//    List<Booking> findByCheckInDateAndNoOfPersons(LocalDate checkInDate,int noOfPersons);
//    List<Booking> findByCheckOutDateAndNoOfPersons(LocalDate checkOutDate,int noOfPersons);
//    List<Booking> findByHotelId(int hotelId);
//    List<Booking> findByCustomerId(int customerId);
//    List<Booking> findByRoomType(String roomType);
//    List<Booking> findByPropertyType(String propertyType);
//    List<Booking> findByCity(String city);
}
