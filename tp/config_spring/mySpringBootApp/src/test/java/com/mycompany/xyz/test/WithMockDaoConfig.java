package com.mycompany.xyz.test;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.mycompany.xyz.repository.RepositoryDevise;

@Configuration
public class WithMockDaoConfig {

	 private static final Logger logger = LoggerFactory.getLogger(WithMockDaoConfig.class);

	    @Bean()
	    @Profile("mock-dao")
	    @Primary //for overriding default spring-data-jpa dao
	    public RepositoryDevise daoDeviseMock() {
	        logger.info("Mocking: {}", RepositoryDevise.class);
	        return Mockito.mock(RepositoryDevise.class);
	    }

}
