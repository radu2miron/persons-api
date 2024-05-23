package edu.tucn.ispse.personsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;

@SpringBootApplication
public class ServerappApplication {
    @Autowired
    Environment env;

    //todo: Access the swagger ui at: http://localhost:8082/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(ServerappApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        String url = env.getProperty("url");
        String dbDirPath = url.substring(url.lastIndexOf(":") + 1, url.lastIndexOf("/"));
        File dbDir = new File(dbDirPath);

        if (!dbDir.exists()) {
            dbDir.mkdirs();
        }

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(url);
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}