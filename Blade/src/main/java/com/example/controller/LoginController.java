package com.example.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.blade.mvc.ui.ModelAndView;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Path("auth")
public class LoginController {

    @GetRoute("login")
    public void login(Response response){
//        return "login.html";
    response.render("login.html");

    }
    @GetRoute("login2")
    public ModelAndView login2(ModelAndView mdv){
        mdv.setView("login.html");
     return mdv;
    }



}
