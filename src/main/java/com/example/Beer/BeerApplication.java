package com.example.Beer;

import com.example.Beer.Entity.Beer;
import com.example.Beer.Reopsitory.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BeerApplication implements CommandLineRunner {

	private BeerRepository beerRepository;

	@Autowired
	public void setBeerRepository(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}
	@Override
	public void run(String... strings) throws Exception {

		Beer testBeer = new Beer();
		testBeer.setName("باريو");
		beerRepository.save(testBeer);
	}
	public static void main(String[] args) {
		SpringApplication.run(BeerApplication.class, args);
	}
}
