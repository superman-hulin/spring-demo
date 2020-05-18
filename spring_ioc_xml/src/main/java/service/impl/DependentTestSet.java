package service.impl;

import java.util.Date;

/**
 * @program: spring_ioc_xml
 * @description: 依赖注入的测试类（set方法注入）
 * @author: Su
 * @create: 2020-05-18 23:01
 **/
public class DependentTestSet {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void save() {
        System.out.println(name);
    }
}
