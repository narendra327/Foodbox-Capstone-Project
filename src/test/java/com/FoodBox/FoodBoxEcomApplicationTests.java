package com.FoodBox;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FoodBox.Model.Category;
import com.FoodBox.Model.Product;
import com.FoodBox.Model.User;
import com.FoodBox.Repo.CategoryRepo;
import com.FoodBox.Repo.OrderDataRepository;
import com.FoodBox.Repo.ProductRepo;
import com.FoodBox.Repo.UserRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FoodBoxEcomApplicationTests {
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryrepo;
	@Autowired
	UserRepo userrepo;
	@Autowired
	OrderDataRepository orderRepo;

	@Test
	@Order(1)
	void ProductTest() {
		Product p = new Product();
		p.setId(22l);
		p.setName("jsaa");
		p.setPrice(7700);
		p.setWeight(1000);
		productRepo.save(p);
	}
	
	@Test
	@Order(2)
	public void TestProductReadAll() {
		List<Product> list=productRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	

	@Test
	@Order(3)
	public void TestCategoryReadAll() {
		List<Category> list=categoryrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(4)
	void UserTest() {
		User user = new User();
		user.setId(144l);
		user.setFirstName("sdahjash");
		user.setLastName("asdjas");
		user.setEmail("ahsh@gmail.com");
		user.setPassword("17777");
	
		userrepo.save(user);
	}
	
}
