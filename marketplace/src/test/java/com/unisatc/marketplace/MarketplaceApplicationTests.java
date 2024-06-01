package com.unisatc.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unisatc.marketplace.controllers.ProductController;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MarketplaceApplicationTests {
	@Autowired
	ProductController productController;

	@Test
	void contextLoads() {
		assertThat(productController).isNotNull();
	}

}
