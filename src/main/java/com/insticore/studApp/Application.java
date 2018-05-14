package com.insticore.studApp;

import com.insticore.studApp.model.Product;
import com.insticore.studApp.model.User;
import com.insticore.studApp.repository.ProductRepository;
import com.insticore.studApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Consumer;

@SpringBootApplication
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger("JCG");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(ProductRepository productRepository, UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... evt) throws Exception {
                Arrays.asList(
                        "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                        .forEach(
                                new Consumer<String>() {
                                    @Override
                                    public void accept(String name) {
                                        User user = new User("peter", User.Role.ADMIN);
                                        userRepository.save(user);
                                        Product product = new Product(name, new BigDecimal(115), "desc", user);
                                        productRepository.save(product);
                                    }
                                });
            }
        };
    }
}

