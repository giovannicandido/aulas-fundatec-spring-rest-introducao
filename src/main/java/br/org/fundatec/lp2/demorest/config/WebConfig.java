package br.org.fundatec.lp2.demorest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configura a segurança do navegador liberando que uma dominio do angular
 * na porta 4200 acesse o spring na porta 8080
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "PUT", "POST", "DELETE")
                .allowedOriginPatterns("*");
    }
}
