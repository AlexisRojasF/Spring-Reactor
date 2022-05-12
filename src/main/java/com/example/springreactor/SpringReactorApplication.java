package com.example.springreactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<String> nombre = Flux.just("alexis","Katherin","Camila","f","alejandra","maria jose")
                .doOnNext(e -> {
                    if (e.isEmpty()){
                        throw new RuntimeException("Nombre no puede ser vacio");
                    }{
                        System.out.println(e);
                    }
                });

        nombre.subscribe(e -> {
                    log.info(e);
                }, error -> log.error(error.getMessage()),
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Ha terminado");
                    }
                });
    }
}
