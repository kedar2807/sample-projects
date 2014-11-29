package event.organizer.config;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "event.organizer")
@EnableWebMvc
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("event.organizer.repositories")
public class SpringConfig {

	@Autowired
	private Environment environment;

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/jspfiles/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;

	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}

	@Bean(name="transactionManager")
	public JpaTransactionManager platformTransactionManager() {
		return new JpaTransactionManager(entityManagerFactoryBean().getObject());
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setDatabasePlatform(environment
				.getProperty("hibernate.dialect"));
		factory.setJpaProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] { "event.organizer.domain" });
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);

		return factory;

	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto",
						environment.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

}
