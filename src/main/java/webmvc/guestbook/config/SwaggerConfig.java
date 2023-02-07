package webmvc.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.POST,getArrayList())
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("webmvc.guestbook.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Service REST API Documentation",
                "REST Api Documentation",
                "1.0",
                "localhost:8089",
                new Contact("hogokok","","krh@gddd.com"),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

    private ArrayList<ResponseMessage> getArrayList(){
        ArrayList<ResponseMessage> list = new ArrayList<ResponseMessage>();
        list.add(new ResponseMessageBuilder().code(500).message("서버 잘못일까??").build());
        list.add(new ResponseMessageBuilder().code(401).message("클라이언트 잘못일까??").build());
        list.add(new ResponseMessageBuilder().code(403).message("클라 잘못일까????").build());

        return list;
    }
}
