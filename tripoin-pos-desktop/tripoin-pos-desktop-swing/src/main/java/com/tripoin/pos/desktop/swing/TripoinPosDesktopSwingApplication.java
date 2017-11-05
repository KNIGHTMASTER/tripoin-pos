package com.tripoin.pos.desktop.swing;

import com.tripoin.pos.desktop.swing.dto.MenuHolderDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@ComponentScan("com.tripoin.pos")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class TripoinPosDesktopSwingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TripoinPosDesktopSwingApplication.class)
                .headless(false)
                .web(false)
                .run(args);
    }

    @Bean
    @Scope(scopeName = "prototype")
    public MenuHolderDTO menuHolderDTO() {
        return new MenuHolderDTO();
    }
}
