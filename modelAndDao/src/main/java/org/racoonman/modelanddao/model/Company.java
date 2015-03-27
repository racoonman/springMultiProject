package org.racoonman.modelanddao.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 *
 * @author daniel
 */
@PersistenceCapable
public class Company {
    
    @Persistent
    private String identificator;
    @Persistent
    private String name;
    @Persistent
    private String secret;

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Company(Company c) {
        this.identificator = c.getIdentificator();
        this.name = c.getName();
        this.secret = c.getSecret();
    }
    
    /***********************************/
    
    
}
