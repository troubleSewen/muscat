package com.bipo.iac;

import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.repository.EndUserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MuscatApplication {

    private static final Logger log = LoggerFactory.getLogger(MuscatApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MuscatApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            System.out.println("Springboot on profile " + profile);
        }
    }

    @Bean
    public CommandLineRunner demo(EndUserAccountRepository repository){
        return (args -> {
            for (String mobileSuffix : Arrays.asList("7001,7002,7003".split(","))) {
                EndUserAccount endUserAccount = new EndUserAccount("N#" + "1800000" + mobileSuffix, mobileSuffix, "123456");
                repository.save(endUserAccount);
                log.info("New account has been created");
            }

            log.info("Load all created end user accounts:");
            repository.findAll().forEach(endUserAccount -> log.info(endUserAccount.getName()));
        });
    }
}