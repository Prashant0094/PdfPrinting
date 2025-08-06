package com.prashant.pdfprinting.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class lmraRequest {
	private Long id;

    private LocalDateTime dateTime;

    private String company;

    private String location;

    private String task;

    private Boolean isJsaReviewed;

    private String additionalControls;

    private String engineerName;

    private LocalDateTime engineerDateTime;

    private String sign;

    private List<LmraCheckListRequest> lmraChecklist = new ArrayList<>();;

    private List<LmraWorkerDetaiilsRequest> workerDetaiils = new ArrayList<>();
    @Data
    public class LmraWorkerDetaiilsRequest {

        private Long id;

        private String workerName;

        private String sign;
    }
    @Data
    public class LmraCheckListRequest {

        private Long id;

        private String checkListText;

        private String remark;
    }
}
