package com.techie.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)

@Data
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String model;

    @OneToOne( mappedBy = "car")
    private Owner owner;


/*    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }*/
}
