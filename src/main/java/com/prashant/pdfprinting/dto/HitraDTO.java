package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class HitraDTO {
	
    private int id;
    private LocalDateTime dateTime;
    private int plantId;
    private String siteName;
    private String noOfPeopleExposed;
    private String mainTask;
    private PersonDto hitraIssuer;
    private PersonDto hitraAcceptor;
    private PersonDto hitraSupervisor;
    private List<SubTaskDto> subTasks;
    private List<TeamMemberDto> hitraTeam;
  
    @Data
    public static class PersonDto {
        private int id;
        private String name;
        private LocalDateTime dateTime;
        private String sign;
    }
    @Data
    public static class SubTaskDto {
        private int id;
        private String subTaskTitle;
        private String hazardDescription;
        private String initialImpact;
        private String initialProbability;
        private String initialRisk;
        private List<ControlDto> controls;
    }
    @Data
    public static class ControlDto {
        private int id;
        private String controlText;
        private String actionParty;
    }
    @Data
    public static class TeamMemberDto {
        private int id;
        private String role;
        private String name;
        private LocalDateTime dateTime;
        private String sign;
    }
}

