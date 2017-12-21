package com.example.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.kit.StringKit;
import com.example.model.Person;

@Bean
public class UserService {

    @Inject
    private CodeService codeService;

    /**
     * 根据用户ID获取一个Person
     *
     * @param id
     * @return person
     */
    public Person getPerson(Integer id) {
        Person person = new Person();
        person.setId(id);
        /**
         * 随机生成10位的数字
         */
        person.setName(StringKit.rand(10));
        return person;
    }


    public Boolean test(String code){

        return codeService.valid(code);
    }
}
