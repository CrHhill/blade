package com.example.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;

@Path("user")
public class UserController {
    @GetRoute
    public String index(Request request){
        request.attribute("name","jack");
        return "user.html";
    }

}
