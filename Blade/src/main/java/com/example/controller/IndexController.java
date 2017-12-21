package com.example.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.example.model.Person;
import com.example.service.CodeService;
import com.example.service.UserService;

/**
 * @author HongHuan
 */
@Path
public class IndexController {

    @GetRoute("users")
    public void users(Response response){
        System.out.println("访问了users请求！");
        response.text("Hello!~");
    }

    @GetRoute("saveusers")
    public void saveusers(Request request,Response response){
        String name = request.query("name","defalutName");
        response.text("you input is " + name);
    }

    @Inject
    private UserService userService;

    @Inject
    private CodeService codeService;

    @GetRoute("/getperson/:id")
    @JSON
    public Person getPerson(@PathParam Integer id){
        return userService.getPerson(id);
    }

    @GetRoute("/gettest/:valid")
    public void test(@PathParam String valid,Response response){

        response.text(String.valueOf(codeService.valid(valid)));
    }
}
