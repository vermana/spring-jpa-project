package com.techie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@Data
public class Tag {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

    public Tag(String name) {
        this.name = name;
    }

    private String name;


    @ManyToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL,mappedBy ="tags")
    private Set<Post> posts = new HashSet<>();





}
