package com.zanchenko.alexey.sfgclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //  I've given in a RequestMapping, a list of parameters
    //and I'm saying an empty string just slash index, index.html. What it means
    //is when there's a request that comes in to the root context or root slash
    //index or index.html, they're all going to match to this RequestMapping
    // Я дал в RequestMapping список параметров и я говорю, что пустая строка просто слэш-индекс,
    // index.html. Что это значит это когда есть запрос, который поступает в корневой контекст или
    // корневую косую черту index или index.html, все они будут соответствовать этому RequestMapping
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
    // it returns back index, the string index and what happens with Thymeleaf it is going to back and look for a template called index.
    // This wires up this controller for that. Это подключает этот контроллер для этого.
}
