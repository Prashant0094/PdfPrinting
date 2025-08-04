package com.prashant.pdfprinting.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ToolBoxTalkDTO {


    private String topic;
    private String topicCover;
    private String tbtGiven;
    private String location;
    private String hazards;
    private String controls;
    private Date dateTime;
    private String tbtDeliveredByName;

    private List<Participant> participants;

   
    @Data
    public static class Participant {
        private String name;
        private String designation;
        private String gpNo;
    }
}
