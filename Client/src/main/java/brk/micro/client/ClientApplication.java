package brk.micro.client;

import brk.micro.client.model.Client;
import brk.micro.client.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save( Client.builder().nom("benzbair ismail").age(23f).build());
            clientRepository.save( Client.builder().nom("sami ben alla").age(22f).build());
            clientRepository.save( Client.builder().nom("silya ben alla").age(22f).build());

        };
    }
}
