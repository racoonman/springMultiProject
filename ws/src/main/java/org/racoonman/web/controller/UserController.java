package org.racoonman.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @RequestMapping("/test")
    public String get(){
        return "USER---- OK";
    }
    
}
