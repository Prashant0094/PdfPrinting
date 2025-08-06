package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Annexure2DTO {
    private String location;
    private String workDescription;
    private String acceptorName;
    private String contractorName;
    private String attendantName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;
    private String sign;
    private String drawing;

    @JsonProperty("annexure2CheckPointsList") 
    private List<Annexure2CheckPoint> annexure2CheckPointsList;

    @Data
    public static class Annexure2CheckPoint {
        private int id;
        private String nameOfPerson;
        private String empNo;
        private String inTime;
        private String outTime;
        private String signOfPerson;
        private String signOffTime;
        private String attendantSign;
    }
}


