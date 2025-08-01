package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class Appendix2DTO {
    private String phase; 
    private String location;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dateTime;
    private String maintenanceRepresentive;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date maintenanceRepresentiveDateTime;
    private List<appendixRequestList> appendixRequestList;
    @Data
	public static class appendixRequestList {
    	private String actualAns;
    }
}
