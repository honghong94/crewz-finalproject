package com.project.crewz.common.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalDto {
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
