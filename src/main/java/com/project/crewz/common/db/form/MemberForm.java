package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class MemberForm {
    private String id;
    private String pwd;
    private String name;
    private Date birth;
    private String tel;

    @Override
    public String toString() {
        return "MemberForm{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", tel='" + tel + '\'' +
                '}';
    }
}
