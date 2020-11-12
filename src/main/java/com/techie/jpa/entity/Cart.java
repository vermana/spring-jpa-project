package com.techie.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.action.internal.OrphanRemovalAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;


    public Cart(String name) {
        this.name = name;
    }

    @OneToMany( mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Item> itemList =new ArrayList<>();
}
