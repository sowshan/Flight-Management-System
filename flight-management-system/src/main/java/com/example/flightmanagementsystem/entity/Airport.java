package com.example.demo.entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name="Airports")
@Data
public class Airport {
 @Id
 private String airportId;
 private String airportName;
 private String airportLocation;
}