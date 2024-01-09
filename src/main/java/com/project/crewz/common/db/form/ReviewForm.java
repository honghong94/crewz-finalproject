package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class ReviewForm {
    private String memberId;
    private Long somoimNo;
    private String content;
    private MultipartFile[] photo;

    @Override
    public String toString() {
        return "ReviewForm{" +
                "memberId='" + memberId + '\'' +
                ", somoimNo=" + somoimNo +
                ", content='" + content + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
