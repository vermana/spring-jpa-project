package com.techie.jpa;

import com.techie.jpa.entity.*;
import com.techie.jpa.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class SpringJpaProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringJpaProjectApplication.class);

    @Autowired
    static private CartRepository cartRepository;


    public static void main(String[] args) {

        // Customer - product One to Many
        // Cart - Item One to many and Many to one  Bi directional

        // Car - Owner One to One Bidirectional

        // Post -Tag Many to Many relationship


        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(SpringJpaProjectApplication.class, args);


        Cart cart = new Cart();
        cart.setName("VijayCart");

        Item shampoo = new Item();
        shampoo.setSerialNumber(22);
        shampoo.setCart(cart);

        Item choclate = new Item();
        choclate.setSerialNumber(23);
        choclate.setCart(cart);

        List<Item> itemList = new ArrayList<>();
        itemList.add(shampoo);
        itemList.add(choclate);

        cart.setItemList(itemList);

        CartRepository cartRepository = configurableApplicationContext.getBean(CartRepository.class);
        cartRepository.save(cart);


        OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);

        Car car = new Car();
        car.setModel("BMW");


        Owner owner = new Owner();
        owner.setName("Vijay Gupta");
        owner.setCar(car);

        ownerRepository.save(owner);
        CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);

        Optional<Car> carOptional = carRepository.findById(24);
        Optional<Owner> ownerOptional = ownerRepository.findById(23);

        if (carOptional.isPresent() && ownerOptional.isPresent()) {
			//log.info("Car : " + carRepository.findById(24) );
			//log.info("Car : " + carRepository.findById(24) + " is owned by " + ownerRepository.findById(23));
            log.info("Car : " + carOptional.get() + " is owned by " + ownerOptional.get());

        }


        Post post =new Post("Hibernate many to may example with Springboot","Hibernate many to may example with Springboot","Hibernate many to may example with Springboot");


        Tag springboot =new Tag("Springboot" );
        Tag hibernate = new Tag ("Hibernate");


        Set<Tag> tags =new HashSet<>();

        tags.add(springboot);
        tags.add(hibernate);


        post.setTags(tags);

        PostRepository postRepository = configurableApplicationContext.getBean(PostRepository.class);

        postRepository.save(post);








    }


}
