package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Annexure1DTO {
    private String location;
    private String areaExeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;
    private String sign;
    private String drawing;
    private List<ChecklistItem> list;

    @Data
    public static class ChecklistItem {
    	private int id;
        private String checkListText;
        private String status;
        private String remark;
    }
}
