package org.nedezkiiyasen.uha.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.nedezkiiyasen.uha.core")
@EnableJpaRepositories("org.nedezkiiyasen.uha.core.dao")
public class CoreConfig {
    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${jpa.database}")
    private Database database;
    @Value("${jpa.showsql}")
    private boolean showSql;
    @Value("${jpa.dialect}")
    private String dialect;
    @Value("${jpa.models}")
    private String models;
    @Value("${db.insert.schema}")
    private Boolean insertSchema;
    @Value("${db.insert.data}")
    private Boolean insertData;

    @Bean
    @Profile("default")
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application.properties"));
        return ppc;
    }

    @Bean
    @Profile("test")
    public static PropertyPlaceholderConfigurer testProperties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application-test.properties"));
        return ppc;
    }

    @Bean
    @Profile("default")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        if (insertSchema)
            DatabasePopulatorUtils.execute(databasePopulator("schema.sql"), dataSource);
        if (insertData)
            DatabasePopulatorUtils.execute(databasePopulator("data.sql"), dataSource);
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }

    private DatabasePopulator databasePopulator(String script) {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource(script));
        return databasePopulator;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(database);
        adapter.setShowSql(showSql);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform(dialect);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan(models);
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(
            LocalContainerEntityManagerFactoryBean emfb) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emfb.getObject());
        return transactionManager;
    }
}
