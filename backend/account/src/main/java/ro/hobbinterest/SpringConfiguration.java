package ro.hobbinterest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource("classpath:application-config.xml")
@ComponentScan(basePackages = "ro.hobbinterest")
@EnableMongoRepositories(basePackages = "ro.hobbinterest.repository")
public class SpringConfiguration {

    @Bean
    public MongoClientURI uri() {
        return new MongoClientURI("mongodb+srv://admin:<admin>@hobbinterest-xnijj.mongodb.net/test?retryWrites=true");
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(uri());
    }

    @Bean
    public MongoDatabase database() {
        return mongoClient().getDatabase("hobbinterest_db");
    }

    @Bean
    public MongoCredential mongoCredential() {
        char[] password = new char[]{'a','d','m','n'};
        return MongoCredential.createCredential("admin", "hibbinterest_db", password);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
