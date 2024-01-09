package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SomoimSubForm {
    private Long somoimNo;
    private String memberId;

    @Override
    public String toString() {
        return "SubSomoimForm{" +
                "somoimNo=" + somoimNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
