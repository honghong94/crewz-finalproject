package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class SomoimForm {
    private String memberId;
    private Long moimno;
    private String title;
    private String content;
    private MultipartFile mf;

    @Override
    public String toString() {
        return "SomoimForm{" +
                "memberId='" + memberId + '\'' +
                ", moimno=" + moimno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mf=" + mf +
                '}';
    }
}
