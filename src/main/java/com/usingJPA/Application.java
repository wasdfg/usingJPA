package com.usingJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		ApplicationContext context = SpringApplication.run(Application.class, args);

		// MemberController 빈 가져와서 main() 실행
		MemberController memberController = context.getBean(MemberController.class);
		memberController.main();
	}

}
