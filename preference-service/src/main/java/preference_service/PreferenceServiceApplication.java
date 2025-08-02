package preference_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PreferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreferenceServiceApplication.class, args);
	}

}
