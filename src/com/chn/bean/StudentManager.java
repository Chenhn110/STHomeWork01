package com.chn.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager implements StudentInterface {
    public  static void app(){
        ArrayList<Student> list = new ArrayList<>();
        StudentManager stu = new StudentManager();
        boolean flag = true;
        while (flag){
            System.out.println(" ");
            System.out.println("********** 欢迎来到学生信息管理系统 ************");
            System.out.println("***************** 1. 插   入 ******************");
            System.out.println("***************** 2. 查   找 ******************");
            System.out.println("***************** 3. 删   除 ******************");
            System.out.println("***************** 4. 修   改 ******************");
            System.out.println("***************** 5. 输   出 ******************");
            System.out.println("***************** 6. 退   出 ******************");
            System.out.println("**********************************************");
            System.out.println("请输入您要操作的序号: ");
            // 序号选择
            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    //插入
                    stu.addStudent(list);
                    break;
                case 2:
                    // 查找
                    stu.findOnlyStudent(list);
                    break;
                case 3:
                    // 删除
                    stu.delStudent(list);
                    break;
                case 4:
                    // 修改
                    stu.changeStudent(list);
                    break;
                case 5:
                    // 输出
                    stu.findStudent(list);
                    break;
                case 6:
                    // 退出
                    flag=false;
                    System.out.println("程序退出成功");
                    break;
            }
        }
    }

    @Override
    public void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        int ID = sc.nextInt();

        System.out.println("请输入姓名：");
        String name = sc.next();

        System.out.println("请输入出生日期(XXXX/XX/XX)：");
        String birDate = sc.next();

        System.out.println("请输入性别：");
        String sex = sc.next();
        Boolean gender = null;
        if(sex.equals("男")){
            gender = true;
        }else if(sex.equals("女")){
            gender = false;
        }else{
            System.out.println("您输入的性别不合法！");
        }

        list.add(new Student(ID, name, birDate, gender));
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student stu1, Student stu2){
                int diff = stu1.getID() - stu2.getID();
                if(diff > 0){
                    return 1;
                }else if(diff < 0){
                    return -1;
                }
                return 0;
            }
        });

        System.out.println("添加成功");
    }

    @Override
    public void delStudent(ArrayList<Student> list ){
        //删除前检查是否有信息
        Scanner sc = new Scanner(System.in);
        if(list.size() == 0){
           //无信息
           System.out.println("无学生信息");
           return;
        }
        findStudent(list);
        System.out.println("请输入要删除的学生的姓名：");
        String name = sc.next();

        //判断list中是否有要删除的姓名
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().contains(name)){
                Object string = list.remove(i);
                System.out.println(string + "已删除成功");
                System.out.println(" ");
                findStudent(list);
            }else{
                System.out.println("不存在该学生");
            }
        }
    }
    @Override
    public void findStudent(ArrayList<Student> list){
        if(list.size() == 0){
            System.out.println("当前无学生信息");
        }
        //查询全部学生信息
        for(Student student:list){
            System.out.println("当前全部学生信息为：");
            System.out.println(student.toString());
        }
        return;
    }
    @Override
    public void changeStudent(ArrayList<Student> list){
        //修改学生信息
        Scanner sc = new Scanner(System.in);

        if(list.size() == 0){
            System.out.println("当前无学生信息");
            return;
        }
        System.out.println("请输入修改学生的姓名：");
        String name = sc.next();
        boolean flag = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().contains(name)){
                flag = true;
                System.out.println("请输入新的学号：");
                int IDNew = sc.nextInt();
                System.out.println("输入新的姓名：");
                String nameNew = sc.next();

                System.out.println("输入新的出生日期(XXXX/XX/XX)：");
                String birDateNew = sc.next();

                System.out.println("输入新的性别：");
                String sexNew = sc.next();
                Boolean genderNew = null;
                if(sexNew.equals("男")){
                     genderNew = true;
                }else if(sexNew.equals("女")){
                    genderNew = false;
                }else{
                    System.out.println("您输入的性别不合法");
                }

                list.set(i,new Student(IDNew, nameNew, birDateNew, genderNew));
                Collections.sort(list, new Comparator<Student>(){
                    @Override
                    public int compare(Student stu3, Student stu4){
                        int tmp = stu3.getID() - stu4.getID();
                        if(tmp > 0){
                            return 1;
                        }else if(tmp < 0){
                            return -1;
                        }
                        return 0;
                    }
                });
                System.out.println("修改成功");
                System.out.println(" ");
                findStudent(list);
                return;
            }
        }
        if (flag == false){
            System.out.println("没有找到该学生");
        }
    }

    @Override
    public void findOnlyStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要查找的学生的姓名：");
        String name = sc.next();

        for (Student stus:list){
                if (stus.getName().contains(name)){
                    System.out.println(stus.toString());
                }else{
                    System.out.println("您输入的姓名不存在");
                }
        }
    }
}
