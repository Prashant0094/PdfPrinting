package com.prashant.pdfprinting.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

@Data
public class WeldingSafetyDTO {
    private int id;
    private String location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;

    private String contractorName;
    private String recommendation;

    private Certifier weldingMachineCertifiedBySuperVisor;
    private Certifier weldingMachineCertifiedByEngineer;

    private List<WeldingChecklistItem> weldingMachineList;

    @Data
    public static class Certifier {
        private int id;
        private String certifiedBy;
        private String name;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
        private Date dateTime;

        private String signature;
    }

    @Data
    public static class WeldingChecklistItem {
        private int id;
        private String checkListText;
        private String status;
    }
}
