package my.yinkn.sprintboot.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by yinkn on 2017/7/9.
 */
public class User {
    @NotEmpty
    private String name;

    @NotEmpty
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
