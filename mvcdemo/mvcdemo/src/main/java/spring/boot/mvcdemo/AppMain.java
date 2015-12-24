package spring.boot.mvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableAutoConfiguration
public class AppMain extends SpringBootServletInitializer {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppMain.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppMain.class);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/templates/notFound.html"));
		return factory;
	}

	// @Bean
	// public InternalResourceViewResolver setUpViewResolver() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix("/templates/");
	// resolver.setSuffix(".jsp");
	// return resolver;
	// }

}
