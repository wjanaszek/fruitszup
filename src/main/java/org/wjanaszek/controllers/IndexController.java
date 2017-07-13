package org.wjanaszek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wjanaszek.model.Fruit;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
