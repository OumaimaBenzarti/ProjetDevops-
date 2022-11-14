package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class AchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

}
