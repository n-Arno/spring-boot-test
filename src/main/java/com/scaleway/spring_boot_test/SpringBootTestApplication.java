package com.scaleway.spring_boot_test;

import com.scaleway.spring_boot_test.model.Book;
import com.scaleway.spring_boot_test.repository.BookRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

        @Autowired
        BookRepository bookRepository;

        // Run this if app.db.init.enabled = true
        @Bean
        @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
        public CommandLineRunner initDbCommandLineRunner() {
            return args -> {

                System.out.println("Initializing DB...");

                Book b1 = new Book("A Tale of Two Cities",
                       "Charles Dickens",
                        BigDecimal.valueOf(15.99),
                        LocalDate.of(1859, 12, 2));
                Book b2 = new Book("Le Petit Prince",
                        "Antoine de Saint-Exupéry",
                        BigDecimal.valueOf(10.99),
                        LocalDate.of(1943, 4, 12));
                Book b3 = new Book("Alice's Adventures in Wonderland",
                       "Lewis Carroll",
                        BigDecimal.valueOf(19.99),
                        LocalDate.of(1865, 11, 10));
                Book b4 = new Book("To Kill a Mockingbird",
                       "Harper Lee",
                        BigDecimal.valueOf(9.99),
                        LocalDate.of(1960, 7, 11));
                Book b5 = new Book("And Then There Were None",
                        "Agatha Christie",
                        BigDecimal.valueOf(12.99),
                        LocalDate.of(1939, 11, 6));

                bookRepository.saveAll(List.of(b1, b2, b3, b4, b5));

                System.out.println("Done.");
            };
        }
}
