package com.techie.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import com.techie.jpa.dto.OrderRequest;
import com.techie.jpa.dto.Response;
import com.techie.jpa.entity.Customer;
import com.techie.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJpaProjectApplicationTest {



	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	private ObjectMapper objectMapper =new ObjectMapper();

   @BeforeAll
	public void setUp(){
    mockMvc	= MockMvcBuilders.webAppContextSetup(context).build();
	}


   @Test
   public void placeOrderTest() throws Exception {
	   OrderRequest orderRequest =new OrderRequest();
	   Customer customer =new Customer();
	   customer.setName("Anubhav");
	   customer.setEmail("abcd@gmail.com");
	   customer.setGender("Male");
	   Product banana =new Product();
	   banana.setProductName("Banana");
	   banana.setPrice(1000);
	   banana.setQty(100);
	   Product grapes =new Product();
	   grapes.setProductName("Grapes");
	   grapes.setPrice(2000);
	   grapes.setQty(200);
	   List<Product> productArraylist =new ArrayList<>();
	   productArraylist.add(banana);
	   productArraylist.add(grapes);
	   customer.setProductList(productArraylist);
	   orderRequest.setCustomer(customer);
     String orderJson= objectMapper.writeValueAsString(orderRequest);

    MvcResult result = mockMvc.perform(post("/placeOrder").content(orderJson).content(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String resultContent = result.getResponse().getContentAsString();

     Response response =objectMapper.readValue(resultContent, Response.class);

	 Assertions.assertTrue(response.isStatus()== Boolean.TRUE);

   }







}
