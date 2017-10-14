package my.pinkyo.demo.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by yinkn on 2017/7/9.
 */
public class User {
    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    @NotNull
    @Length(min = 1, max = 20)
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
