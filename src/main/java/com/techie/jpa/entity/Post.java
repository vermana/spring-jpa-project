package com.techie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
@Data
public class Post {

    @Id
    @GeneratedValue
    private int id;

    private  String title ;

    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    private  String description;
    private  String content;
    private  Date postedAt =new Date();
    private  Date lastupdated = new Date();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private Set<Tag> tags = new HashSet<>();






}
