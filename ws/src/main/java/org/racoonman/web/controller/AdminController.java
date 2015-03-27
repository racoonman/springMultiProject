package org.racoonman.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @RequestMapping("/test")
    public String get(){
        return "ADMIN---- OK";
    }
    
}
