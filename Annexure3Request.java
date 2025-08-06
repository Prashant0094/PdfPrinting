package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Annexure3Request  {
    private Long id;
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;
    private String nameOfContractor;
    private String department;
    private String extensionFrom;  
    private String extensionTo;    
    private Boolean isOptionOne=false;
    private Boolean isOptionTwo=false;
    private List<Annexure3MachineList> machineList = new ArrayList<>();
    private List<Annexure3CheckedBy> annexure3CheckedByList= new ArrayList<>();
    private List<Annexure3CheckpointsRequest> checkpointsRequests = new ArrayList<>();
    private String wiremanLicense;

    @Data
    public static class Annexure3MachineList {
        private Long id;
        private String machineType;
        private String machineNo;
        private String tagNo;
        private String location;
        private String cwp;
        private String typeOfConnection;
    }

    @Data
    public static class Annexure3CheckedBy {
        private Long id;
        private String name;
        private LocalDateTime dateTime;
        private String signature;
        private String status;
        private String EpEcNo;
    }

    @Data
    public static class Annexure3CheckpointsRequest {
        private Long id;
        private String response;
        private String checkpointText;
    }
}

