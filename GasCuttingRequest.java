package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GasCuttingRequest {
    private Long id;
    private String location;
    private String plant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime dateTime;

    private String contractorName;
    private String recommondation;

    private  GasCuttingCertifiedByRequest certifiedByEngineer;

    private  GasCuttingCertifiedByRequest certifiedByContractorSupervisor;

    private List<GasCuttingListRequest> list;

    @Data
    public class GasCuttingCertifiedByRequest {

        private Long id;

        private String certifiedBy;

        private String name;

        private LocalDateTime dateTime;

        private String signature;

    }

    @Data
    public static class GasCuttingListRequest {
        private int id;
        private String checkListText;
        private String status;
    }
}
