package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@AllArgsConstructor
public class CategoryForm {
    private String name;
    private MultipartFile mf;

    @Override
    public String toString() {
        return "CategoryForm{" +
                "name='" + name + '\'' +
                ", mf=" + mf +
                '}';
    }
}