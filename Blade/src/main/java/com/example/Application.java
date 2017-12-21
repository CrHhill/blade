package com.example;

import com.blade.Blade;
import com.blade.event.EventType;
import com.blade.mvc.WebContext;

public class Application {
    public static void main(String[] args) {
        Blade blade = Blade.me();
        blade.me()
                .get("/",((req,res) ->res.text("Hello Blade!")))
                .get("/hello",((req,res) ->{
                    res.html("<h1>Hello Blade!</h1>" + WebContext.blade().environment().get("server.port","9000"));
                }))
                .use(s ->{
                    System.out.println(s.getAction());
                    return true;
                })
                .event(EventType.SERVER_STARTING,e -> System.out.println("web服务准备启动了..."))
                .event(EventType.SERVER_STARTED,e -> System.out.println("服务器启动ok了"))
                .addStatics("/testfolders/")
                .start(Application.class,args);
    }
}
