package com.example.myapplication;

import java.util.ArrayList;

public class myGroup {
    public ArrayList<String> child;
    public String groupName;
    myGroup(String name){
        groupName = name;
        child = new ArrayList<String>();
    }
}
