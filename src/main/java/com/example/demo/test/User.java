package com.example.demo.test;

import java.util.List;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/21 周二
 * @time 15:37
 * @desc
 */
public class User {

    private  Integer id;
    private List<String>  list;

    public User() {
    }

    public User(Integer id, List<String> list) {
        this.id = id;
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
