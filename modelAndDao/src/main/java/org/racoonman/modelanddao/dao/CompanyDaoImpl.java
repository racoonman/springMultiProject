package org.racoonman.modelanddao.dao;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import org.racoonman.modelanddao.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */
@Transactional
@Component
public class CompanyDaoImpl implements CompanyDao {
    
    @Autowired
    @Qualifier("pmfTransactionAware")
    private PersistenceManagerFactory pmf;

    @Override
    public Company getCompanyById(String identificator) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query q = pm.newQuery(Company.class, "identificator == :id");
        List<Company> list = (List<Company>) q.execute(identificator);
        
        if (list.size() == 1) {
            return list.get(0);
        }
        
        return null;
    }
    
}
