package com.techie.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Owner {


    @Id
    @GeneratedValue
    private int id;


    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id",referencedColumnName = "id")
    private Car car;


    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car.getModel() +
                '}';
    }
}
