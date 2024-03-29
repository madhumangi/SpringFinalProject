package com.hotelapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Facilities {

    /**
     * This class stores the facilities of hotels
     */
    @Id
    @GeneratedValue(generator = "facilities_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "facilities_generator",sequenceName = "facilities_sequence",allocationSize = 1,initialValue = 1)
    @ToString.Exclude
    private Integer facilityId;
    private String facilityName;

    /**
     * Many facilities are there in one hotel
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "hotel_facilities",
            joinColumns=@JoinColumn(name="hotel_id"),
            inverseJoinColumns = @JoinColumn(name="facility_id"))
    private Set<Hotel> hotels;

    public Facilities(String facilityName) {
        this.facilityName = facilityName;
    }

    public Facilities(String facilityName, Set<Hotel> hotels) {
        this.facilityName = facilityName;

    }

}
