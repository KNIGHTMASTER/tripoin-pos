package com.tripoin.pos.rest.desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on Oct 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@EntityScan("com.tripoin.pos")
@ComponentScan({"com.tripoin.pos"})
public class TripoinPosRestDesktopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripoinPosRestDesktopApplication.class);
    }
}
