package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Annexure3DTO {
    private int id;
    private Date dateTimeFrom;
    private Date dateTimeTo;
    private String nameOfContractor;
    private String department;
    private String extensionFrom;  
    private String extensionTo;    
    private boolean isOptionOne;
    private boolean isOptionTwo;
    private List<MachineDTO> machineList;
    private List<CheckedByDTO> annexure3CheckedByList;
    private List<CheckpointRequestDTO> checkpointsRequests;
    private String wiremanLicense;

    @Data
    public static class MachineDTO {
        private int id;
        private String machineType;
        private String machineNo;
        private String tagNo;
        private String location;
        private String cwp;
        private String typeOfConnection;
    }

    @Data
    public static class CheckedByDTO {
        private int id;
        private String name;
        private Date dateTime;
        private String signature;
        private String status;
        private String epEcNo;
    }

    @Data
    public static class CheckpointRequestDTO {
        private int id;
        private String response;
        private String checkpointText;
    }
}

