package com.example.controller;

import com.blade.kit.StringKit;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.multipart.FileItem;
import com.example.model.Person;

import java.io.FileOutputStream;
import java.util.Optional;

@Path("req")
public class RequestController {

    /**
     * ？带参数名风格
     * @param request
     */
    @GetRoute("name")
    public void getName(Request request) {
//        String name = request.query("name","jack");
//        System.out.println(name);

        Optional<String> optional = request.query("name");
        optional.ifPresent(name -> System.out.println(name));
    }

    /**
     * restful风格
     * @param request
     */
    @GetRoute("users/:id")
    public void getId(Request request, Response response){
        Integer id = request.pathInt("id");
        System.out.println("id = " + id);
        response.text("id = " + id);

    }

    @PostRoute("save")
    @JSON
    public Person savePerson(@BodyParam Person person){
        System.out.println(person);
        return person;
    }

    @PostRoute("saveperson")
    @JSON
    public Person savePerson2(@Param Person person){
        System.out.println(person);
        return person;
    }

    @PostRoute("upload")
    public void upload(Request request){
        Optional<FileItem> fileItem = request.fileItem("img");
        fileItem.ifPresent(item ->{
            System.out.println(item);
            byte[] data = item.getData();

            try {
                FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/img.jpg");
                fos.write(data);
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        });
    }
}
