package ua.sukhorutchenko.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.sukhorutchenko.library.config.YAMLConfig;

@SpringBootApplication
public class LibraryApplication {

    @Autowired
    private YAMLConfig config;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
