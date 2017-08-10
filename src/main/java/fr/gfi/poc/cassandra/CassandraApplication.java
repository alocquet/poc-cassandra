package fr.gfi.poc.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import fr.gfi.poc.cassandra.resource.SireneResource;

@SpringBootApplication
@ComponentScan(basePackages = "fr.gfi.poc.cassandra")
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class CassandraApplication {

	@Autowired
	private SireneResource sireneClient;

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}

	@Bean
	CommandLineRunner test() {
		return (args) -> {
			// The result.
			System.out.println(sireneClient.findAllLoop());
		};
	}
}
