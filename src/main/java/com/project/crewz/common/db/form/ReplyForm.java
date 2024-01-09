package com.project.crewz.common.db.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyForm {
    private Long reviewNo;
    private String memberId;
    private String content;

    @Override
    public String toString() {
        return "CommentForm{" +
                "reviewNo=" + reviewNo +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
