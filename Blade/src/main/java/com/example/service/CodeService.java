package com.example.service;

import com.blade.ioc.annotation.Bean;

@Bean
public class CodeService {

    public Boolean valid(String code){
        return code.length()>3?true:false;
    }
}
