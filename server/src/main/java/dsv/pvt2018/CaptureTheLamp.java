package dsv.pvt2018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CaptureTheLamp extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CaptureTheLamp.class, args);
		System.out.println("hell");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CaptureTheLamp.class);
	}

}
