package com.prashant.pdfprinting.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Appendix3DTO {
	private int id;
	private String jobDescription;


	private List<Participant> participants;

	@Data
	public static class Participant {
		private int id;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
		private Date dateTime;

		private String o2;
		private String lel;
		private String h2sPpm;
		private String nameOfFe;
	
    public String getDate() {
        if (dateTime == null) return "";
        return new java.text.SimpleDateFormat("dd-MM-yyyy").format(dateTime);
    }

    public String getTime() {
        if (dateTime == null) return "";
        return new java.text.SimpleDateFormat("HH:mm:ss").format(dateTime);
    }
}
}
