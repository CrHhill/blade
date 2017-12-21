package com.example.controller;

import com.blade.mvc.annotation.*;
import com.blade.mvc.ui.RestResponse;
import com.example.model.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path(value = "person",restful = true)
public class PersonController {

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetRoute("/find/:id")
    public RestResponse query(@PathParam Integer id){
        return RestResponse.ok(new Person().find(id));
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetRoute("/find/:page/:limit")
    public RestResponse queryByLimit(@PathParam Integer page,@PathParam Integer limit){
        return RestResponse.ok(new Person().page(page,limit));
    }


    /**
     * 插入方法
     * @param name
     * @param id
     * @return
     */
    @GetRoute("/save/:name/:id")
    public RestResponse save(@PathParam String name,@PathParam Integer id) {
        Person person = new Person();
        person.setName(name);
        person.setId(id);
        RestResponse rr = null;
        try {
            rr = RestResponse.ok(person.save());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("插入数据有误！");
        }
        return rr;
    }


    @PostRoute("/save2")
    public RestResponse save2(Person person){
        Long uid = person.save();
        return RestResponse.ok(uid);
    }

    @PutRoute("/update")
    public RestResponse update(Person person){
        int result = person.update(person.getId());
        return RestResponse.ok(result);
    }

    @DeleteRoute("/delete/:id")
    public RestResponse delete(@PathParam Integer id){
        return RestResponse.ok(new Person().delete(id));
    }
}
