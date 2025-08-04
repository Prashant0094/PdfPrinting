package com.prashant.pdfprinting.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkPermitDTO {

    private int id;
    private String permitType;
    private int uniqueId;
    private int plantId;
    private int plantArea;
    private String equipmentName;
    private String equipmentTagNo;
    private String jobDescription;
    private String contractorName;
    private int personInvolved;
    private String status;
    private String stage;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private int noOfApprover;
    private int approver1;
    private int approver2;
    private int approver3;
    private int assignedIssuer;

    private SectionC sectionC;
    private SectionD sectionD;
    private SectionE sectionE;
    private SectionG sectionG;
    private SectionF sectionF;

    private List<SectionH> sectionH;
    private List<SectionK> sectionK;
    private List<SectionI> sectionI;
    
    @Data
    public static class SectionF {
        private int id;
        private String equipmentPreparation;
        private String otherPreparation;
    }


    @Data
    public static class SectionC {
        private int id;
        private String nature;
        private String otherNature;
    }

    @Data
    public static class SectionD {
        private int id;
        private String tools;
        private String otherTools;
    }

    @Data
    public static class SectionE {
        private int id;
        private String hazards;
        private String otherHazard;
        private int noOfPersons;
    }

    @Data
    public static class SectionG {
        private int id;
        private String preFire;
        private String otherPrefire;
        private int specialGloves;
        private String protectiveSuit;
    }

    @Data
    public static class SectionH {
        private int id;
        private String gasTest;
        private String result;
        private LocalDateTime dateTime;
        private String initials;
        private String sign;
    }

    @Data
    public static class SectionK {
        private int id;
        private String status;
        private String role;
        private String name;
        private LocalDateTime dateTime;
        private String sign;
    }

    @Data
    public static class SectionI {
        private int id;
        private String role;
        private String name;
        private LocalDateTime dateTime;
        private String sign;
    }
}

