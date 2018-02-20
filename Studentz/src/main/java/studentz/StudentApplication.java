package studentz;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EntityScan(basePackages = {"studentz"})
@EnableJpaRepositories(basePackages = {"studentz.dao"})
@SpringBootApplication
public class StudentApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {

		SpringApplication.run(StudentApplication.class, args);

	}
}