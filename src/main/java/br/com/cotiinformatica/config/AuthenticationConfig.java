package br.com.cotiinformatica.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cotiinformatica.filters.AuthenticationFilter;

@Configuration
public class AuthenticationConfig {

	@Bean
	public FilterRegistrationBean<AuthenticationFilter> jwtFilter() {
		
		// Registrando o filter que irá validar os tokens
		FilterRegistrationBean<AuthenticationFilter> filter 
		= new FilterRegistrationBean<AuthenticationFilter>();
		
		filter.setFilter(new AuthenticationFilter());
		
		// Mapeando toda a API para exigir o token de autenticação
		filter.addUrlPatterns("/api/*");
		return filter;
	}
}
