package ru.raiffeisen.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", "xz123");
		SpringApplication.run(Application.class, args);
	}
}
