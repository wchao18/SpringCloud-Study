package com.it.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DeptRest {


    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") long id) {
        return id;
    }

    @GetMapping
    public String retStr() {
        return "success";
    }


}
