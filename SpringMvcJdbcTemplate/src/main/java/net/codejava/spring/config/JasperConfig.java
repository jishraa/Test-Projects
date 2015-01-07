package net.codejava.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Configuration
public class JasperConfig {

	@Bean
	public JasperReportsPdfView contactReport() {
	
		JasperReportsPdfView pdfView = new JasperReportsPdfView();
		pdfView.setUrl("classpath:contact.jrxml");
		pdfView.setReportDataKey("contactDS");
		
		return pdfView;
	}
	
}
