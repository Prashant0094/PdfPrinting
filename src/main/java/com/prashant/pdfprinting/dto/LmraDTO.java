package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LmraDTO {
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;
    private String company;
    private String location;
    private String task;
    private boolean isJsaReviewed;
    private String additionalControls;
    private String engineerName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date enginnerDateTime;
    private String sign;

    private List<LmraChecklistItem> lmraChecklist;
    private List<LmraWorkerDetails> lmraWorkerDetails;

    @Data
    public static class LmraChecklistItem {
        private int id;
        private String checkListText;
        private String remark;    // For the place : Tick in "YES", "NO", or "N/A"
    }

    @Data
    public static class LmraWorkerDetails {
        private int id;
        private String workerName;
        private String sign;
        private boolean isDeleted;
    }
}
