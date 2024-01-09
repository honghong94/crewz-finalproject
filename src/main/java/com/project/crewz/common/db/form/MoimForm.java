package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class MoimForm {
    private Long categoryNo;
    private String memberId;
    private String info;
    private String title;
    private String content;
    private MultipartFile[] photo;

    @Override
    public String toString() {
        return "MoimForm{" +
                "categoryNo=" + categoryNo +
                ", memberId='" + memberId + '\'' +
                ", info='" + info + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}