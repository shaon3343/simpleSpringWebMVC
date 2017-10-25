package com.shaon.spring.webmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ashfak on 10/25/17.
 */
@Controller
public class LoginController {

    public static final String INDEX_ROUTE = "/";
    public static final String LOGIN_ROUTE = "/login";

    @GetMapping({INDEX_ROUTE, LOGIN_ROUTE})
    public String index() {
        return "/login";
    }
}
