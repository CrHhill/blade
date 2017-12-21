package com.example.model;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;
import lombok.Data;

@Data
@Table(value = "person")
public class Person extends ActiveRecord{
    private Integer id;
    private String name;
}
