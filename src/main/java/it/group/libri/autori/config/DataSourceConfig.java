package it.group.libri.autori.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({ JpaProperties.class })
@EnableJpaRepositories(basePackages = { DataSourceConfig.JPA_PROPERTIES_PACKAGE }, transactionManagerRef = DataSourceConfig.JPA_PROPERTIES_TXMANAGER)
@ConfigurationProperties(prefix = DataSourceConfig.JPA_PROPERTIES_PREFIX)
@EnableTransactionManagement
public class DataSourceConfig {
  public static final String JPA_PROPERTIES_PREFIX = "datasource-config";
  public static final String JPA_PROPERTIES_PACKAGE = "it.group.libri.autori";
  public static final String JPA_PROPERTIES_TXMANAGER = "txManagerLibriAutori";

  @Autowired
  private JpaProperties jpaProperties;

  @Autowired
  private GenericApplicationContext context;

  private DataSourceProperties dataSource;

  @Bean()
  public DataSource datasource() {

    DataSourceProperties dsProperties = getDataSource();

    HikariConfig configuration = new HikariConfig();
    configuration.setJdbcUrl(dsProperties.getUrl());
    configuration.setUsername(dsProperties.getUsername());
    configuration.setPassword(dsProperties.getPassword());
    configuration.setDriverClassName(dsProperties.getDriverClassName());
    configuration.setConnectionTimeout(30000);
    configuration.setMaxLifetime(300000);
    configuration.setIdleTimeout(30000);

    return new HikariDataSource(configuration);
  }


  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    Map<String, Object> hibernateProps = new LinkedHashMap<>();
    Map<String, String> prop = this.jpaProperties.getProperties();
    hibernateProps.putAll(prop);

    LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
    result.setDataSource(datasource());
    result.setPackagesToScan(JPA_PROPERTIES_PACKAGE);
    result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    result.setJpaPropertyMap(hibernateProps);

    return result;
  }

  @Bean(name = JPA_PROPERTIES_TXMANAGER)
  public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }


  public DataSourceProperties getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSourceProperties dataSource) {
    this.dataSource = dataSource;
  }
}
