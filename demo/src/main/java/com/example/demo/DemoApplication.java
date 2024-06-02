package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.unit.DataSize;


@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

//	@Autowired
//	UUID uuid1;
//	@Autowired
//	UUID uuid2;
@Autowired
private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		DemoApplication bean = context.getBean(DemoApplication.class);
		System.out.println(bean); //Meine Bohne

		FileSystem fileSystem = context.getBean(FileSystem.class);
		System.out.printf("%d GB%n",DataSize.ofBytes(fileSystem.getFreedDiskSpace()).toGigabytes());

	}
	@Override
	public void run(String... args) throws Exception {
		// SQL-Befehle zur Erstellung der Datenbank und der Tabelle
		String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS beaverbase";
		String createTableQuery = "CREATE TABLE IF NOT EXISTS beaverbase.users (" +
				"id INT AUTO_INCREMENT PRIMARY KEY," +
				"username VARCHAR(255) NOT NULL," +
				"email VARCHAR(255) NOT NULL" +
				")";

		// Ausführung der SQL-Befehle
		jdbcTemplate.execute(createDatabaseQuery);
		jdbcTemplate.execute(createTableQuery);

		System.out.println("Tabelle 'users' in der Datenbank 'beaverbase' erfolgreich erstellt.");
	}

	}


