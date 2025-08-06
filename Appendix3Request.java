package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Appendix3Request {

    private Long id;
    private String jobDescription;
    private String issuerName;
    private LocalDateTime issuerDateTime;
    private String issuerSign;
    private String gasTesterName;
    private LocalDateTime gasTesterDateTime;
    private String gasTesterSign;

    private List<Appendix3List> list = new ArrayList<>();

    @Data
    public static class Appendix3List {
        private Long id;
        private LocalDateTime dateTime; // ✅ Corrected type
        private String percentage;
        private String lel;
        private String h2s;
        private String nameOfFe;
        private String sign;

        public String getDate() {
            if (dateTime == null) return "";
            return dateTime.toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        public String getTime() {
            if (dateTime == null) return "";
            return dateTime.toLocalTime().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    }
}

