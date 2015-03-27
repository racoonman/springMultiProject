package org.racoonman.modelanddao;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jdo.JdoTransactionManager;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.orm.jdo.TransactionAwarePersistenceManagerFactoryProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 *
 * @author daniel
 */
@Configuration
@EnableTransactionManagement
public class JdoConfiguration implements TransactionManagementConfigurer {

    @Bean
    public LocalPersistenceManagerFactoryBean localPersistenceManagerFactoryBean() throws Exception {
        LocalPersistenceManagerFactoryBean localPersistenceManagerFactoryBean = new LocalPersistenceManagerFactoryBean();

        String dnPath = System.getProperty("dnFile");
        if (dnPath == null) {
            throw new Exception("Falta fijar el parametro dnFile");
        }

        Properties props = new Properties();
        try {
            props.load(new FileInputStream(dnPath));
        } catch (Exception ex) {
            return null;
        }

        localPersistenceManagerFactoryBean.setJdoProperties(props);

        return localPersistenceManagerFactoryBean;
    }

    @Bean(name = "pmfTransactionAware")
//    @Scope(value= "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TransactionAwarePersistenceManagerFactoryProxy persistenceManagerFactoryProxy( //        HttpServletRequest req
            ) throws Exception {
//        req.getHeader("Accept");
        TransactionAwarePersistenceManagerFactoryProxy transactionAwarePersistenceManagerFactoryProxy
                = new TransactionAwarePersistenceManagerFactoryProxy();
        transactionAwarePersistenceManagerFactoryProxy.setTargetPersistenceManagerFactory(
                localPersistenceManagerFactoryBean().getObject());
        transactionAwarePersistenceManagerFactoryProxy.setAllowCreate(false);

        return transactionAwarePersistenceManagerFactoryProxy;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        JdoTransactionManager jdoTransactionManager = new JdoTransactionManager();

        try {
            jdoTransactionManager.setPersistenceManagerFactory(localPersistenceManagerFactoryBean().getObject());
        } catch (Exception ex) {
            Logger.getLogger(JdoConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return jdoTransactionManager;
    }

}
