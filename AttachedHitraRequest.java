package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AttachedHitraRequest {
	
    private Long id;
    private LocalDateTime dateTime;
    private Long plantId;
    private String siteName;
    private String noOfPeopleExposed;
    private String mainTask;
    private HitraIssuerRequest hitraIssuer;
    private HitraAcceptorRequest hitraAcceptor;
    private HitraContractorSupervisorRequest hitraSupervisor;
    private List<AttachedSubTaskRequest> subTasks = new ArrayList<>();
    private List<HitraTeamRequest> hitraTeam = new ArrayList<>();
    @Data
    public class AttachedSubTaskRequest {

        private Long id;

        private String subTaskTitle;

        private String hazardDescription;

        private String initialImpact;

        private String initialProbability;

        private String initialRisk;

        private String finalImpact;

        private String finalProbability;

        private String finalRisk;


        List<HitraSubTaskControlsRequest> controls = new ArrayList<>();


    }
    @Data
    public class HitraContractorSupervisorRequest {

        private  Long id;

        private String name;

        private LocalDateTime dateTime;

        private String sign;
    }
    @Data
    public class HitraAcceptorRequest {

        private  Long id;

        private String name;

        private LocalDateTime dateTime;

        private String sign;
    }
    @Data
    public class HitraIssuerRequest {

        private  Long id;

        private String name;

        private LocalDateTime dateTime;

        private String sign;
    }
    @Data
    public class HitraSubTaskControlsRequest {

        private Long id;

        private String controlText;

        private String actionParty;

    }

    @Data
    public class HitraTeamRequest {


        private Long id;

        private String role;

        private String name;

        private LocalDateTime dateTime;

        private String sign;
    }
}

