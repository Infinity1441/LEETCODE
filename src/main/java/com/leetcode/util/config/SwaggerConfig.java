//package com.leetcode.util.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.PathVariable;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Value("${api.version}")
//    private String apiVersion;package com.leetcode.util.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.PathVariable;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.List;
//
//    @Configuration
//    @EnableSwagger2
//    public class SwaggerConfig {
//
//        @Value("${api.version}")
//        private String apiVersion;
//
//        @Bean
//        public OpenAPI springOpenApi(){
//            return new OpenAPI()
//                    .info(new Info()
//                            .title("Spring 6 Swagger 2 LeetCode Project")
//                            .version(apiVersion)
//                            .contact(new Contact()
//                                    .email("nodiracanuz@gmail.com")
//                                    .name("nodiracan")
//                                    .url("https://github.com/nodiracan")))
//                    .servers(List.of(
//                                    new Server().url("http://localhost:8080").description("Production Server"),
//                                    new Server().url("http://localhost:9090").description("Test Server")
//                            )
//                    );
//        }
//
//
//
//    }
//
//
//    @Bean
//    public OpenAPI springOpenApi(){
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Spring 6 Swagger 2 LeetCode Project")
//                        .version(apiVersion)
//                        .contact(new Contact()
//                                .email("nodiracanuz@gmail.com")
//                                .name("nodiracan")
//                                .url("https://github.com/nodiracan")))
//                .servers(List.of(
//                        new Server().url("http://localhost:8080").description("Production Server"),
//                        new Server().url("http://localhost:9090").description("Test Server")
//                        )
//                );
//    }
//
//
//
//}
