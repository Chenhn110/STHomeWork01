package com.chn.bean;

import java.util.*;

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
            //问题37：是否每个switch-case语句都有最后一个default以确保处理了全集？否
            /*switch (choice){
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
            }*/

            //修改问题37后代码
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
                default:
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

        System.out.println("请输入出生日期(yyyy/MM/dd)：");
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
        //问题61：是否把方法中的重复代码抽象成函数
        /*Collections.sort(list, new Comparator<Student>(){
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
        });*/

        //修改问题61后
        Collections.sort(list, new IDComparator());
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
        for(int i = 0; i < list.size(); i++) {

            //问题19：if/if-else/if-else if-else/do-while/switch-case语句的格式是否符合规范
            /*if(list.get(i).getName().contains(name)){
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
                //问题：是否把方法中的重复代码抽象成函数
                *//*Collections.sort(list, new Comparator<Student>(){
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
                });*//*

                //修改后
                Collections.sort(list, new IDComparator());
                System.out.println("修改成功");
                System.out.println(" ");
                findStudent(list);
                return;
            }
        }
        if (flag == false){
            System.out.println("没有找到该学生");
        }*/

            // 修改问题19后
            if (list.get(i).getName().contains(name)) {
                flag = true;
                System.out.println("请输入新的学号：");
                int IDNew = sc.nextInt();
                System.out.println("输入新的姓名：");
                String nameNew = sc.next();

                System.out.println("输入新的出生日期(yyyy/MM/DD)：");
                String birDateNew = sc.next();

                System.out.println("输入新的性别：");
                String sexNew = sc.next();
                Boolean genderNew = null;
                if (sexNew.equals("男")) {
                    genderNew = true;
                } else if (sexNew.equals("女")) {
                    genderNew = false;
                } else {
                    System.out.println("您输入的性别不合法");
                }

                list.set(i, new Student(IDNew, nameNew, birDateNew, genderNew));
                Collections.sort(list, new IDComparator());
                System.out.println("修改成功");
                System.out.println(" ");
                findStudent(list);
            } else {
                System.out.println("没有找到该学生");
            }
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

    //修改问题61后
    static  class IDComparator implements Comparator{
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.<p>
         * <p>
         * The implementor must ensure that <tt>sgn(compare(x, y)) ==
         * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>compare(x, y)</tt> must throw an exception if and only
         * if <tt>compare(y, x)</tt> throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
         * <tt>compare(x, z)&gt;0</tt>.<p>
         * <p>
         * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
         * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
         * <tt>z</tt>.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            int tmp = s1.getID() - s2.getID();
            if(tmp > 0){
                return 1;
            }else if(tmp < 0){
                return -1;
            }
            return 0;
        }
    }
}


