package com.swzhou.mytodo.unit.controller;

import com.swzhou.mytodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("todo/index");
        modelAndView.addObject("todos", service.getAll());
        return modelAndView;
    }

}
