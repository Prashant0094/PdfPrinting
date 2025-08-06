package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WeldingMachineRequest {
	private Long id;
    private String location;
    private String plant;

    private String area;

    private String machineCapacity;
    private String makeMc;

    private LocalDateTime dateTime;

    private String contractorName;
    private String recommendation;

    private GasCuttingCertifiedByRequest weldingMachineCertifiedBySuperVisor;
    private GasCuttingCertifiedByRequest weldingMachineCertifiedByEngineer;

    private List<GasCuttingListRequest> weldingMachineList;

    @Data
    public static class GasCuttingCertifiedByRequest {
        private int id;
        private String certifiedBy;
        private String name;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
        private Date dateTime;

        private String signature;
    }

    @Data
    public static class GasCuttingListRequest {
        private Long id;
        private String checkListText;
        private String status;
    }
}
