package com.example.hooks;

import com.blade.ioc.annotation.Bean;
import com.blade.mvc.hook.Signature;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Request;
import lombok.extern.slf4j.Slf4j;

@Bean
@Slf4j
public class AuthHook implements WebHook {
    @Override
    public boolean before(Signature signature) {
        log.debug("before...");
        Request request = signature.getRequest();
        log.info("Request URI: {} {}",request.method(),request.uri());
        log.info("Request UserAgent: {} {}",request.userAgent(),request.address());

        return true;
    }

    @Override
    public boolean after(Signature signature) {

        System.out.println("after");

        return true;
    }
}
