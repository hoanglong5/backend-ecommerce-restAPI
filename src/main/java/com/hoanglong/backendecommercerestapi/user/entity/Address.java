package com.hoanglong.backendecommercerestapi.user.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "`ADDRESS`" )
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "street")
    private String street;
    @Column(name = "ward")
    private String ward;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private List<Customer> customers ;
    }
