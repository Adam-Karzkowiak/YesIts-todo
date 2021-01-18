package com.app.YesItstodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class YesItsTodoApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(YesItsTodoApplication.class, args);
	}

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	@Override
	public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingRepositoryEventListener){
		validatingRepositoryEventListener.addValidator("beforeCreate",validator());
		validatingRepositoryEventListener.addValidator("beforeSave",validator());
	}



}
