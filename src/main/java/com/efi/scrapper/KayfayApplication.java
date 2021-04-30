package com.efi.scrapper;

import com.efi.scrapper.scrapp.StoreScrapped.SagaFalabellaScrapped;
import com.efi.scrapper.scrapp.temporal.SimulateScrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KayfayApplication implements CommandLineRunner {

	@Autowired
	SagaFalabellaScrapped sagaFalabellaScrapped;

	@Autowired
	SimulateScrapper shopScrapped;

	public static void main(String[] args) {
		SpringApplication.run(KayfayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sagaFalabellaScrapped.start("https://www.falabella.com.pe/falabella-pe/");
		shopScrapped.scrapShop("https://www.falabella.com.pe/falabella-pe/");
	}
}
