package com.example.demo.entity;
import javax.persistence.*;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity


@Table(name="Flight_Info")
@Data
public class Flight {
 @Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)

 private String flightId;
 private String carrierName;
 private String flightModel;
 private int seatCapacity;
 
}









