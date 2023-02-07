package webmvc.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfiguration.class})
@ComponentScan(basePackages = {"webmvc.guestbook.repository","webmvc.guestbook.service"})
public class ApplicationConfiguration {
}
