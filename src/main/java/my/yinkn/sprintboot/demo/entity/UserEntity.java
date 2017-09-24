package my.yinkn.sprintboot.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by yinkn on 2017/7/9.
 */
@Entity
@Table(name = "user", indexes = @Index(columnList = "name", unique = true))
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String name;

    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
