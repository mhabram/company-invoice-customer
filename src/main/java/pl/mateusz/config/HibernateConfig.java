package pl.mateusz.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.mateusz.model.Company;
import pl.mateusz.model.Customer;
import pl.mateusz.model.Invoice;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "pl.mateusz")
public class HibernateConfig {

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?useSSL=false");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        Properties properties = new Properties();
//        properties.put("sql_show", "true");
        properties.put("hibernate.hbm2ddl.auto","update");
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setAnnotatedClasses(Company.class, Customer.class, Invoice.class);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
