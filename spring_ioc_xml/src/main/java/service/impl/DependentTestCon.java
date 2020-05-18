package service.impl;

import java.util.Date;

/**
 * @program: spring_ioc_xml
 * @description: 依赖注入的测试类（构造函数注入）
 * @author: Su
 * @create: 2020-05-18 22:38
 **/
public class DependentTestCon {
    private String name;
    private Integer age;
    private Date birthday;
    public DependentTestCon(String name, Integer age, Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }
    public void save() {
        System.out.println(name);
    }
}
