package com.example.controller;


import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.example.model.Person;

@Path("res")
public class ResponseController {

    @GetRoute("json")
    public void printJson(Response response){
        Person person = new Person();
        person.setId(23);
        person.setName("hhh");
        response.json(person);

    }

    @GetRoute("cookie")
    public void writeCookie(@Param String c,Response response){
        response.cookie("test",c);
    }

    @GetRoute("redirect")
    public void redirect(Response response){
        response.redirect("http://www.baidu.com");
    }

    @GetRoute("render")
    public void render(Response response){
        response.render("login.html");
    }
}
