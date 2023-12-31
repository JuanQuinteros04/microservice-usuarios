package com.formacionbdi.springboot.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServicioUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioUsuariosApplication.class, args);
    }

}
