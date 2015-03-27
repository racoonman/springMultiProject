package org.racoonman.web.controller;

import java.util.UUID;
import org.racoonman.modelanddao.dao.PersonsDao;
import org.racoonman.modelanddao.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private PersonsDao daoService;

    @RequestMapping("/test")
    public String index() {
        StringBuilder sb = new StringBuilder();
        for (Person p : daoService.getPersons()) {
            sb.append(
                    p.getName()).append(", ");
        }

        return sb.toString();
    }

    @RequestMapping("/new")
    public String newPerson() {
        Person p = new Person();
        p.setName(UUID.randomUUID().toString());
        daoService.savePerson(p);
        return "OK :)";
    }

}
