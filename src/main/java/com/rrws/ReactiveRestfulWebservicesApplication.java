package com.rrws;

import com.rrws.controller.FluxControllerDemo;
import com.rrws.controller.MonoControllerDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveRestfulWebservicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestfulWebservicesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		MonoControllerDemo.test();
		FluxControllerDemo.test();
	}
}
