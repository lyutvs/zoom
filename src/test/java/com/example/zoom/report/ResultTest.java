package com.example.zoom.report;

import com.example.zoom.domain.report.domain.Report;
import com.example.zoom.domain.report.domain.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("Builder 사용해 Result 객체 생성 메소드")
    void createByBuilder() {
        //given
        String reason = "원인";
        Report report = Report.builder()
                .title("신고")
                .build();

        //when
        Result result = Result.builder()
                .reason(reason)
                .report(report)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(reason, result.getReason()),
                () -> Assertions.assertEquals(report, result.getReport())
        );
    }

}
