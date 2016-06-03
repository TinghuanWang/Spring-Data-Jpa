package com.tiedate.csmiswh.business.SaTcapacitor.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wth on 2016/6/1.
 */
@Entity
@Table(name = "tbl_user")
public class UserModel {
    @Id
    private Integer uuid;
    private String name;
    private Integer age;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
