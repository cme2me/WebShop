package com.gb.shop;

import com.gb.shop.dao.ProductRepository;
import com.gb.shop.dto.ProductDto;
import com.gb.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository repository;

	@Test
	void createProductTest() {
		var productDto = createProductDto();
		productService.saveProduct(productDto.getName(), productDto.getPrice());
		Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
	}

	private ProductDto createProductDto() {
		ProductDto dto = new ProductDto();
		dto.setPrice(25.5);
		dto.setName("SomeThing");
		dto.setId(UUID.randomUUID());
		return dto;
	}
}
