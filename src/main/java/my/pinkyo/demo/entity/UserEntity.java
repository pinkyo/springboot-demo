package my.pinkyo.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    @CreationTimestamp
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_time")
    @UpdateTimestamp
    private Date lastUpdatedTime;

    public String getId() {
        return id;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }
}
