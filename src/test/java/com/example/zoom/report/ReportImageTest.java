package com.example.zoom.report;

import com.example.zoom.domain.report.domain.Report;
import com.example.zoom.domain.report.domain.ReportImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReportImageTest {

    @Test
    @DisplayName("Builder를 활용하여 Medium객체를 생성하는 메소드")
    void createByBuilder() {
        //given
        Report report = Report.builder()
                .title("신고")
                .build();

        String path = "자료위치";

        //when
        ReportImage reportImage = ReportImage.builder()
                .report(report)
                .path(path)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(report, reportImage.getReport()),
                () -> Assertions.assertEquals(path, reportImage.getPath())
        );
    }


}
