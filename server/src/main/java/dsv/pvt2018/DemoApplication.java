package dsv.pvt2018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CaptureTheFlag extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CaptureTheFlag.class, args);
		System.out.println("hell");
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CaptureTheFlag.class);
	}
}
