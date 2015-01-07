package net.codejava.spring.config;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.dao.ContactDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@ComponentScan(basePackages = "net.codejava.spring")
@EnableWebMvc
@Import({ JasperConfig.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	ServletContext servletContext;
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/infy_excercise");
		dataSource.setUsername("rajesh");
		dataSource.setPassword("rajesh");

		return dataSource;
	}

	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}

	/*
	 * @Bean public PdfRevenueReportView PdfRevenueSummary() { return new
	 * PdfRevenueReportView(); }
	 */


	@Bean(name = "pdfViewResolver")
	public ViewResolver getXmlViewResolver() {
		XmlViewResolver xmlViewRes = new XmlViewResolver();
		xmlViewRes.setLocation(new ServletContextResource(servletContext,
				"//WEB-INF/jasper-views.xml"));
		xmlViewRes.setOrder(1);
		return xmlViewRes;
	}
}
