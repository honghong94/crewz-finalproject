package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Local {
    public Long no;
    public String name;
    public String ename;
    public Long acc;

    @Override
    public String toString() {
        return "Local{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", acc=" + acc +
                '}';
    }
}
