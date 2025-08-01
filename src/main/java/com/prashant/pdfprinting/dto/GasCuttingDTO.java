package com.prashant.pdfprinting.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

@Data
public class GasCuttingDTO {
    private int id;
    private String location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;

    private String contractorName;
    private String recommondation;

    private CertifiedBy certifiedByContractorSupervisor;
    private CertifiedBy certifiedByEngineer;

    private List<ChecklistItem> list;

    @Data
    public static class CertifiedBy {
        private int id;
        private String certifiedBy;
        private String name;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
        private Date dateTime;

        private String signature;
    }

    @Data
    public static class ChecklistItem {
        private int id;
        private String checkListText;
        private String status;
    }
}
