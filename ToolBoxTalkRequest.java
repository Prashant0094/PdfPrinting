package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ToolBoxTalkRequest {

    private Long id;
    private String topic;
    private String topicCover;
    private String tbtGiven;
    private String location;
    private String hazards;
    private String controls;
    private LocalDateTime dateTime;
    private TbtDeliveredBy tbtDeliveredBy;

    private List<TbtParticipants> participants;

   
    @Data
    public static class TbtParticipants {
        private Long id;
        private String name;
        private String designation;
        private String gpNo;
        private String signature;
    }
    @Data
    public class TbtDeliveredBy {

        private Long id;

        private String name;

        private LocalDateTime dateTime;

        private String signature;

    }
}
