package com.vinfai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vinfai.mapper")//扫描mybatis dao 接口
public class MicrobootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrobootMybatisApplication.class, args);
	}
}
