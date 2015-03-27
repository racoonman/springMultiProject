package org.racoonman.modelanddao.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 *
 * @author daniel
 */
@PersistenceCapable
public class Person {
    
    @Persistent
    private String name;
    @Persistent
    private String email;
    @Persistent
    private String hash;
    @Persistent
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    /************************/
    public Person() {
    }
    
    public Person(Person p) {
        super();
        this.name = p.getName();
        this.role = p.getRole();
        this.email = p.getEmail();
        this.hash = p.getHash();
    }
    
    
    
}
