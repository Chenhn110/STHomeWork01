package com.chn.bean;

public class Student {
    private int ID; //学号
    private String name; //姓名
    private String birDate; //出生日期
    private Boolean gender; // 性别

    public Student(){
        //无参构造
    }

    public Student(int ID, String name, String birDate, Boolean gender){
        this.ID = ID;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBirDate(){
        return birDate;
    }

    public  void setBirDate(String birDate){
        this.birDate = birDate;
    }

    public Boolean getGender(){
        return gender;
    }

    public void setGender(Boolean gender){
        this.gender = gender;
    }

    @Override
    public  String toString(){
        if(this.gender){
            return "{学号: " + this.ID + ", 姓名: " + this.name + ", 出生日期: " + this.birDate + ", 性别: 男"  + "}";
        }else{
            return "{学号: " + this.ID + ", 姓名: " + this.name + ", 出生日期: " + this.birDate + ", 性别: 女" + "}";
        }
    }
}



