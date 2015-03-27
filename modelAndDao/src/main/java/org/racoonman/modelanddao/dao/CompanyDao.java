package org.racoonman.modelanddao.dao;

import org.racoonman.modelanddao.model.Company;

/**
 *
 * @author daniel
 */
public interface CompanyDao {
    public Company getCompanyById(String identificator);
}
