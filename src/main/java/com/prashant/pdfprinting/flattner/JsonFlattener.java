package com.prashant.pdfprinting.flattner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO.Annexure2CheckPoint;
import com.prashant.pdfprinting.dto.Annexure3DTO;
import com.prashant.pdfprinting.dto.Appendix1DTO;
import com.prashant.pdfprinting.dto.Appendix2DTO;
import com.prashant.pdfprinting.dto.Appendix3DTO;
import com.prashant.pdfprinting.dto.GasCuttingDTO;
import com.prashant.pdfprinting.dto.LmraDTO;
import com.prashant.pdfprinting.dto.LmraDTO.LmraWorkerDetails;
import com.prashant.pdfprinting.dto.ToolBoxTalkDTO;
import com.prashant.pdfprinting.dto.ToolBoxTalkDTO.Participant;
import com.prashant.pdfprinting.dto.WeldingSafetyDTO;
import com.prashant.pdfprinting.dto.WorkPermitDTO;

public class JsonFlattener {
	public static Map<String, Object> flatten(Annexure1DTO dto) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto.getLocation());
		params.put("areaExeName", dto.getAreaExeName());
		params.put("sign", dto.getSign());
		params.put("drawing", dto.getDrawing());
		params.put("dateTime", dto.getDateTime());

		List<Annexure1DTO.ChecklistItem> list = dto.getList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			params.put("status_" + index, list.get(i).getStatus());
			params.put("remark_" + index, list.get(i).getRemark());
		}

		return params;
	}

	public static Map<String, Object> flatten(Annexure2DTO dto1) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto1.getLocation());
		params.put("workDescription", dto1.getWorkDescription());
		params.put("acceptorName", dto1.getAcceptorName());
		params.put("contractorName", dto1.getContractorName());
		params.put("attendantName", dto1.getAttendantName());
		params.put("dateTime", dto1.getDateTime());

		List<Annexure2CheckPoint> list = dto1.getAnnexure2CheckPointsList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			params.put("nameOfPerson" + index, list.get(i).getNameOfPerson());
			params.put("empNo" + index, list.get(i).getEmpNo());
			params.put("inTime" + index, list.get(i).getInTime());
			params.put("outTime" + index, list.get(i).getOutTime());
		}
		while (list.size() < 16) {
			list.add(new Annexure2CheckPoint());
		}
		return params;
	}

	public static Map<String, Object> flatten(Appendix1DTO dto2) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto2.getLocation());
		params.put("phase", dto2.getPhase());
		params.put("dateTime", dto2.getDateTime());
		params.put("fieldExecutiveName", dto2.getFieldExecutiveName());
		params.put("fieldExecutiveDateTime", dto2.getFieldExecutiveDateTime());

		List<Appendix1DTO.appendixRequestList> list = dto2.getAppendixRequestList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			params.put("actualAns_" + index, list.get(i).getActualAns());
		}
		return params;
	}

	public static Map<String, Object> flatten(Appendix2DTO dto3) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto3.getLocation());
		params.put("phase", dto3.getPhase());
		params.put("dateTime", dto3.getDateTime());
		params.put("maintenanceRepresentive", dto3.getMaintenanceRepresentive());
		params.put("maintenanceRepresentiveDateTime", dto3.getMaintenanceRepresentiveDateTime());

		List<Appendix2DTO.appendixRequestList> list = dto3.getAppendixRequestList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			params.put("actualAns_" + index, list.get(i).getActualAns());
		}
		return params;
	}

	public static Map<String, Object> flatten(GasCuttingDTO dto) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto.getLocation());
		params.put("dateTime", dto.getDateTime());
		params.put("contractorName", dto.getContractorName());
		params.put("recommondation", dto.getRecommondation());

		if (dto.getCertifiedByContractorSupervisor() != null) {
			GasCuttingDTO.CertifiedBy c1 = dto.getCertifiedByContractorSupervisor();
			params.put("contractorSupervisor_certifiedBy", c1.getCertifiedBy());
			params.put("contractorSupervisor_name", c1.getName());
			params.put("contractorSupervisor_dateTime", c1.getDateTime());
		}

		if (dto.getCertifiedByEngineer() != null) {
			GasCuttingDTO.CertifiedBy c2 = dto.getCertifiedByEngineer();
			params.put("engineer_certifiedBy", c2.getCertifiedBy());
			params.put("engineer_name", c2.getName());
			params.put("engineer_dateTime", c2.getDateTime());
		}

		List<GasCuttingDTO.ChecklistItem> list = dto.getList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			params.put("status_" + index, list.get(i).getStatus());
			params.put("checkListText_" + index, list.get(i).getCheckListText());
		}
		return params;
	}

	public static Map<String, Object> flatten(WeldingSafetyDTO dto) {
		Map<String, Object> params = new HashMap<>();

		params.put("location", dto.getLocation());
		params.put("dateTime", dto.getDateTime());
		params.put("contractorName", dto.getContractorName());
		params.put("recommendation", dto.getRecommendation());

		WeldingSafetyDTO.Certifier supervisor = dto.getWeldingMachineCertifiedBySuperVisor();
		if (supervisor != null) {
			params.put("contractorSupervisor_certifiedBy", supervisor.getCertifiedBy());
			params.put("contractorSupervisor_name", supervisor.getName());
			params.put("contractorSupervisor_dateTime", supervisor.getDateTime());
		}

		WeldingSafetyDTO.Certifier engineer = dto.getWeldingMachineCertifiedByEngineer();
		if (engineer != null) {
			params.put("engineer_certifiedBy", engineer.getCertifiedBy());
			params.put("engineer_name", engineer.getName());
			params.put("engineer_dateTime", engineer.getDateTime());
		}

		List<WeldingSafetyDTO.WeldingChecklistItem> list = dto.getWeldingMachineList();
		for (int i = 0; i < list.size(); i++) {
			int index = i + 1;
			WeldingSafetyDTO.WeldingChecklistItem item = list.get(i);
			params.put("checkListText_" + index, item.getCheckListText());
			params.put("status_" + index, item.getStatus());
		}

		return params;
	}

	public static Map<String, Object> flatten(LmraDTO dto) {
		Map<String, Object> params = new HashMap<>();
		params.put("company", dto.getCompany());
		params.put("location", dto.getLocation());
		params.put("task", dto.getTask());
		params.put("additionalControls", dto.getAdditionalControls());
		params.put("engineerName", dto.getEngineerName());
		params.put("isJsaReviewed", dto.isJsaReviewed());
		params.put("date", formatDate(dto.getDateTime()));
		params.put("time", formatTime(dto.getDateTime()));
		params.put("engineer_date", formatDate(dto.getEnginnerDateTime()));
		params.put("engineer_time", formatTime(dto.getEnginnerDateTime()));

		List<LmraDTO.LmraChecklistItem> checklist = dto.getLmraChecklist();
		if (checklist != null) {
		for (int i = 0; i < checklist.size(); i++) {
			String prefix = "q" + (i + 1);
			String remark = checklist.get(i).getRemark();
			String normalized = remark == null ? "" : remark.trim().toUpperCase();
			params.put(prefix + "_yes", normalized.equals("YES") ? "✓" : "");
			params.put(prefix + "_no", normalized.equals("NO") ? "✓" : "");
			params.put(prefix + "_na", (normalized.equals("NA") || normalized.equals("N/A")) ? "✓" : "");
		}
		}
		List<LmraWorkerDetails> workers = dto.getLmraWorkerDetails();

		if (workers != null) {
			for (int i = 0; i < workers.size(); i++) {
				LmraWorkerDetails w = workers.get(i);
				params.put("workerName_" + (i + 1), w.getWorkerName());
				params.put("sign_" + (i + 1), w.getSign()); // Optional
			}
		}
		return params;
	}

	private static String formatDate(Date date) {
		return date == null ? "" : new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	private static String formatTime(Date date) {

		return date == null ? "" : new SimpleDateFormat("HH:mm:ss").format(date);
	}

	public static Map<String, Object> flatten(Appendix3DTO dto) {
	    Map<String, Object> params = new HashMap<>();

	    // Add other parameters
	    params.put("jobDescription", dto.getJobDescription());

	    // Ensure the participant list is not null
	    List<Appendix3DTO.Participant> participants = 
	        dto.getParticipants() != null ? new ArrayList<>(dto.getParticipants()) : new ArrayList<>();

	    // Pad the list to 12 participants
	    while (participants.size() < 12) {
	        participants.add(new Appendix3DTO.Participant());
	    }

	    // Add individual participant fields (optional, if needed in title band)
	    for (int i = 0; i < participants.size(); i++) {
	        Appendix3DTO.Participant p = participants.get(i);
	        int index = i + 1;

	        params.put("participant" + index + "_name", p.getNameOfFe());
	        params.put("participant" + index + "_o2", p.getO2());
	        params.put("participant" + index + "_lel", p.getLel());
	        params.put("participant" + index + "_h2sPpm", p.getH2sPpm());
	        params.put("participant" + index + "_date", formatDate1(p.getDateTime()));
	        params.put("participant" + index + "_time", formatTime1(p.getDateTime()));
	    }

	    // Put the full padded list as a collection for detail band
	    params.put("participants", new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(participants));

	    return params;
	}

	private static String formatDate1(Date date) {
	    return date == null ? "" : new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	private static String formatTime1(Date date) {
	    return date == null ? "" : new SimpleDateFormat("HH:mm:ss").format(date);
	}
	
	public static Map<String, Object> flatten(ToolBoxTalkDTO dto) {
        Map<String, Object> params = new HashMap<>();
        if (dto == null) {
            return params;
        }

        params.put("topic", dto.getTopic());
        params.put("topicCover", dto.getTopicCover());
        params.put("tbtGiven", dto.getTbtGiven());
        params.put("location", dto.getLocation());
        params.put("hazards", dto.getHazards());
        params.put("controls", dto.getControls());
        params.put("dateTime", dto.getDateTime());
        params.put("tbtDeliveredByName", dto.getTbtDeliveredByName());

        List<Participant> participants = dto.getParticipants();
        if (participants != null && !participants.isEmpty()) {
            for (int i = 0; i < participants.size(); i++) {
                Participant participant = participants.get(i);
                params.put("participant_" + i + "_name", participant.getName());
                params.put("participant_" + i + "_designation", participant.getDesignation());
                params.put("participant_" + i + "_gpNo", participant.getGpNo());
            }
        }
        return params;
    }
	public static Map<String, Object> flatten(Annexure3DTO dto) {
	    Map<String, Object> flatMap = new HashMap<>();

	    // Direct fields
	    flatMap.put("id", dto.getId());
	    flatMap.put("dateTimeFrom", dto.getDateTimeFrom());
	    flatMap.put("dateTimeTo", dto.getDateTimeTo());
	    flatMap.put("nameOfContractor", dto.getNameOfContractor());
	    flatMap.put("department", dto.getDepartment());
	    flatMap.put("extensionFrom", dto.getExtensionFrom());
	    flatMap.put("extensionTo", dto.getExtensionTo());
	    flatMap.put("isOptionOne", dto.isOptionOne());
	    flatMap.put("isOptionTwo", dto.isOptionTwo());
	    flatMap.put("wiremanLicense", dto.getWiremanLicense());

	    List<Annexure3DTO.MachineDTO> machines = dto.getMachineList();
	    for (int i = 0; i < 3; i++) {
	        Annexure3DTO.MachineDTO m = (i < machines.size()) ? machines.get(i) : new Annexure3DTO.MachineDTO();
	        int idx = i + 1;

	        flatMap.put("machineType_" + idx, m.getMachineType());
	        flatMap.put("machineNo_" + idx, m.getMachineNo());
	        flatMap.put("tagNo_" + idx, m.getTagNo());
	        flatMap.put("location_" + idx, m.getLocation());
	        flatMap.put("cwp_" + idx, m.getCwp());
	        flatMap.put("typeOfConnection_" + idx, m.getTypeOfConnection());
	    }

	    List<Annexure3DTO.CheckedByDTO> checkers = dto.getAnnexure3CheckedByList();
	    for (int i = 0; i < 3; i++) {
	        Annexure3DTO.CheckedByDTO c = (i < checkers.size()) ? checkers.get(i) : new Annexure3DTO.CheckedByDTO();
	        int idx = i + 1;

	        flatMap.put("checkedBy_name_" + idx, c.getName());
	        flatMap.put("checkedBy_dateTime_" + idx, c.getDateTime());
	        flatMap.put("checkedBy_signature_" + idx, c.getSignature());
	        flatMap.put("checkedBy_status_" + idx, c.getStatus());
	        flatMap.put("checkedBy_epEcNo_" + idx, c.getEpEcNo());
	    }
	    List<Annexure3DTO.CheckpointRequestDTO> checkpoints = dto.getCheckpointsRequests();
	    for (int i = 0; i < checkpoints.size(); i++) {
	    	Annexure3DTO.CheckpointRequestDTO cp = checkpoints.get(i);
	        int idx = i + 1;

	        flatMap.put("checkpoint_text_" + idx, cp.getCheckpointText());
	        flatMap.put("response_" + idx, cp.getResponse());  
	    }

	    return flatMap;
	}
	public static Map<String, Object> flatten(WorkPermitDTO dto) {
        Map<String, Object> flatMap = new HashMap<>();

        if (dto.getValidFrom() != null) {
            flatMap.put("fromTime", dto.getValidFrom().toLocalTime().toString());
        }
        if (dto.getValidTo() != null) {
            flatMap.put("toTime", dto.getValidTo().toLocalTime().toString());
            flatMap.put("date", dto.getValidTo().toLocalDate().toString());
        }

        flatMap.put("equipmentName", dto.getEquipmentName());
        flatMap.put("equipmentTagNo", dto.getEquipmentTagNo());
        flatMap.put("contractorName", dto.getContractorName());
        flatMap.put("jobDescription", dto.getJobDescription());
        flatMap.put("personInvolved", dto.getPersonInvolved());

        Map<String, Map<String, String>> sectionOptions = Map.of(
            "sectionC", Map.of(
                "Welding/Gas Cutting", "nature_welding",
                "Radiation Sources", "nature_radiation",
                "Opening of lines", "nature_lines",
                "Hydrojetting", "nature_hydrojetting",
                "Grinding", "nature_grinding"
            ),
            "sectionD", Map.of(
                "Welding Machine", "tools_welding_machine",
                "Gas Cylinder", "tools_gas_cylinder",
                "Air/Hydraulic", "tools_air_hydraulic",
                "Non-flameproof", "tools_non_flameproof"
            ),
            "sectionE", Map.of(
                "Fire Hazard", "hazard_fire",
                "Electrical", "hazard_electrical",
                "Toxic Material", "hazard_toxic",
                "Oxygen Deficient", "hazard_oxygen"
            ),
            "sectionF", Map.of(
                "Isolated/Blinded", "prep_isolated",
                "Ventilation Ensured", "prep_ventilation",
                "Area Barricaded", "prep_barricaded",
                "Clearance Obtained", "prep_clearance"
            ),
            "sectionG", Map.of(
                "Fire Extinguisher", "hazard_fire_extinguisher",
                "SCBA", "hazard_scba",
                "Face Shield", "hazard_face_shield",
                "Protective Suit", "hazard_protective_suit"
            )
        );

        sectionOptions.forEach((section, options) -> {
            String data = switch (section) {
                case "sectionC" -> dto.getSectionC() != null ? dto.getSectionC().getNature() : null;
                case "sectionD" -> dto.getSectionD() != null ? dto.getSectionD().getTools() : null;
                case "sectionE" -> dto.getSectionE() != null ? dto.getSectionE().getHazards() : null;
                case "sectionF" -> dto.getSectionF() != null ? dto.getSectionF().getEquipmentPreparation() : null;
                case "sectionG" -> dto.getSectionG() != null ? dto.getSectionG().getPreFire() : null;
                default -> null;
            };

            if (data != null) {
                Set<String> selected = Arrays.stream(data.split(","))
                    .map(String::trim)
                    .collect(Collectors.toSet());

                options.forEach((key, value) ->
                    flatMap.put(value, selected.contains(key) ? "\u2E93" : "\u2E92"));
            }
        });

        return flatMap;
    }


}

