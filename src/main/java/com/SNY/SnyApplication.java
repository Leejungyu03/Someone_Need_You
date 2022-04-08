package com.SNY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.SNY")   // com.marobiana 패키지 아래에 있는 스프링빈들 탐색
@SpringBootApplication    // 스프링 구동을 위한 필수 어노테이션
public class SnyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnyApplication.class, args);
	}

}
