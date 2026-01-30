package wtf.vexel.platform.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import wtf.vexel.platform.model.User;
import wtf.vexel.platform.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the admin already exists so we don't create duplicates
            if (repository.findByUsername("admin").isEmpty()) {
                
                // Create the user
                User admin = new User();
                admin.setUsername("admin");
                // This encrypts the password "vexel123" using BCrypt
                admin.setPassword(passwordEncoder.encode("vexel123")); 
                admin.setRole("ADMIN");
                
                // Save to database
                repository.save(admin);
                System.out.println("ADMIN ACCOUNT CREATED: Username: admin | Password: vexel123");
            }
        };
    }
}