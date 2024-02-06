package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.unit.DataSize;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	UUID uuid1;
//	@Autowired
//	UUID uuid2;


	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		DemoApplication bean = context.getBean(DemoApplication.class);
		System.out.println(bean); //Meine Bohne

		FileSystem fileSystem = context.getBean(FileSystem.class);
		System.out.printf("%d GB%n",DataSize.ofBytes(fileSystem.getFreedDiskSpace()).toGigabytes());
	}

}
