package org.example.redcomunicativa.Config.Swagger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class SwaggerAutoOpen implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        try {
            String url = "http://localhost:8080/swagger-ui/index.html";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Abre Swagger manualmente en: " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
