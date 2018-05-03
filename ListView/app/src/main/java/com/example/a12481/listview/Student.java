package com.example.a12481.listview;

/**
 * Created by 12481 on 2018/5/3.
 */

public class Student {
    private String name;
    private int classnum;
    private int num;
    private String sex;
    private int pho;
    public Student(String name,int classnum,int num,String sex,int pho){
        this.name = name;
        this.classnum = classnum;
        this.num = num;
        this.sex = sex;
        this.pho = pho;
    }
    public String getName(){
        return name;
    }
    public int getClassnum(){
        return classnum;
    }
    public String getSex(){
        return sex;
    }
    public int getNum(){
        return num;
    }
    public int getPho(){
        return pho;
    }
}
