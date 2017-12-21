package com.example.config;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.mvc.view.template.JetbrickTemplateEngine;

/**
 * @author HongHuan
 */
@Bean
public class BeforeConfig implements BeanProcessor {

    @Override
    public void processor(Blade blade) {
        System.out.println("Before...");
        blade.templateEngine(new JetbrickTemplateEngine());
        System.out.println(blade.environment().get("app.version","0.0.1"));
    }
}
