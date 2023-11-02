package com.tobeto.spring.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//localhost:8080/api/persons
//Annatation = bir değişkene atanabililen @ işaretli, atandığı argümana özellikler kazandırır, hazırlar ve kullanımı kolaydır
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//spring devreye alır
		SpringApplication.run(Application.class, args);
	}

}
