//package com.example.testing.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan("com.example.testing")
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public DataSource dataSource() {
//        return new DriverManagerDataSource("/db.properties");
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//}
