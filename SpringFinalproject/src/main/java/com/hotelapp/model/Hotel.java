package com.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Hotel {

    /**
     * This class contains all the variables of a hotel's characteristics
     */

    @Id
    @GeneratedValue(generator = "hotel_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "hotel_generator",sequenceName = "hotel_sequence",initialValue = 101,allocationSize = 1)
    @ToString.Exclude
    private Integer hotelId;
    @Column(length = 30)
    private String hotelName;
    private long phone;
    private Integer noOfRooms;
    private float ratings;
    private String starRatings;
    private String propertyType;

    /**
     * One hotel has many rooms
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    private List<Rooms> rooms;

    /**
     * Different hotels have different facilities
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "hotels")
    private Set<Facilities> facilities;

    /**
     * A hotel has a unique address
     */
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "hotel")
    private Address address;

    /**
     * Different hotels has many customers
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER,mappedBy = "hotels")
    private Set<Customer> customers;

    /**
     * A hotel can have many bookings at a time
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    private Set<Booking> bookings;

    public Hotel(String hotelName, long phone, Integer noOfRooms, float ratings, String starRatings, String propertyType, List<Rooms> rooms, Set<Facilities> facilities, Address address) {
        this.hotelName = hotelName;
        this.phone = phone;
        this.noOfRooms = noOfRooms;
        this.ratings = ratings;
        this.starRatings = starRatings;
        this.propertyType = propertyType;
        this.rooms = rooms;
        this.facilities = facilities;
        this.address = address;

    }

}
