package com.jabejo.sbjpah2;

import com.jabejo.sbjpah2.repositories.StudentRepository;
import com.jabejo.sbjpah2.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sbjpah2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Sbjpah2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10001 -> {}", studentRepository.findById(10001L));
		logger.info("Inserting -> {}", studentRepository.save(new Student("John", "jhon@mail.com")));
		logger.info("Update ", studentRepository.save(new Student(10002L, "arif", "arif@mail.com")));
		studentRepository.deleteById(10001L);
		logger.info("All student -> {}", studentRepository.findAll());
	}

}
