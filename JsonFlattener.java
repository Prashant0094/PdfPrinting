package com.prashant.pdfprinting.flattner;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO.Annexure2CheckPoint;
import com.prashant.pdfprinting.dto.Annexure3Request;
import com.prashant.pdfprinting.dto.Appendix1DTO;
import com.prashant.pdfprinting.dto.Appendix2DTO;
import com.prashant.pdfprinting.dto.Appendix3Request;
import com.prashant.pdfprinting.dto.AttachedHitraRequest;
import com.prashant.pdfprinting.dto.GasCuttingRequest;
import com.prashant.pdfprinting.dto.ToolBoxTalkRequest;
import com.prashant.pdfprinting.dto.WeldingMachineRequest;
import com.prashant.pdfprinting.dto.WorkPermitDTO;
import com.prashant.pdfprinting.dto.lmraRequest;

public class JsonFlattener {
	private static final DateTimeFormatter DATE_ONLY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

	public static Map<String, Object> flatten(GasCuttingRequest dto) {
	    Map<String, Object> params = new HashMap<>();

	    if (dto == null) return params;

	    // Top-level fields
	    params.put("id", dto.getId());
	    params.put("location", dto.getLocation());
	    params.put("plant", dto.getPlant());
	    params.put("contractorName", dto.getContractorName());
	    params.put("recommondation", dto.getRecommondation());

	    if (dto.getDateTime() != null) {
	        params.put("date", dto.getDateTime().format(DATE_FORMATTER));
	        params.put("time", dto.getDateTime().format(TIME_FORMATTER));
	    }

	    // Contractor Supervisor section
	    GasCuttingRequest.GasCuttingCertifiedByRequest supervisor = dto.getCertifiedByContractorSupervisor();
	    if (supervisor != null) {
	        params.put("contractorSupervisor_id", supervisor.getId());
	        params.put("contractorSupervisor_certifiedBy", supervisor.getCertifiedBy());
	        params.put("contractorSupervisor_name", supervisor.getName());
	        params.put("contractorSupervisor_signature", supervisor.getSignature());

	        if (supervisor.getDateTime() != null) {
	            params.put("contractorSupervisor_date", supervisor.getDateTime().format(DATE_FORMATTER));
	            params.put("contractorSupervisor_time", supervisor.getDateTime().format(TIME_FORMATTER));
	        }
	    }

	    // Engineer section
	    GasCuttingRequest.GasCuttingCertifiedByRequest engineer = dto.getCertifiedByEngineer();
	    if (engineer != null) {
	        params.put("engineer_id", engineer.getId());
	        params.put("engineer_certifiedBy", engineer.getCertifiedBy());
	        params.put("engineer_name", engineer.getName());
	        params.put("engineer_signature", engineer.getSignature());

	        if (engineer.getDateTime() != null) {
	            params.put("engineer_date", engineer.getDateTime().format(DATE_FORMATTER));
	            params.put("engineer_time", engineer.getDateTime().format(TIME_FORMATTER));
	        }
	    }

	    // Checklist items
	    List<GasCuttingRequest.GasCuttingListRequest> list = dto.getList();
	    if (list != null) {
	        for (int i = 0; i < list.size(); i++) {
	            int index = i + 1;
	            GasCuttingRequest.GasCuttingListRequest item = list.get(i);

	            params.put("checklist_id_" + index, item.getId());
	            params.put("checkListText_" + index, item.getCheckListText());
	            params.put("status_" + index, item.getStatus());
	        }
	    }

	    return params;
	}


	public static Map<String, Object> flatten(WeldingMachineRequest dto) {
	    Map<String, Object> params = new HashMap<>();

	    if (dto == null) return params;

	    // Top-level fields
	    params.put("id", dto.getId());
	    params.put("location", dto.getLocation());
	    params.put("plant", dto.getPlant());
	    params.put("area", dto.getArea());
	    params.put("machineCapacity", dto.getMachineCapacity());
	    params.put("makeMc", dto.getMakeMc());
	    params.put("contractorName", dto.getContractorName());
	    params.put("recommendation", dto.getRecommendation());

	    if (dto.getDateTime() != null) {
	        params.put("date", dto.getDateTime().format(DATE_FORMATTER));
	        params.put("time", dto.getDateTime().format(TIME_FORMATTER));
	    }

	    // Supervisor Section
	    WeldingMachineRequest.GasCuttingCertifiedByRequest supervisor = dto.getWeldingMachineCertifiedBySuperVisor();
	    if (supervisor != null) {
	        params.put("contractorSupervisor_id", supervisor.getId());
	        params.put("contractorSupervisor_certifiedBy", supervisor.getCertifiedBy());
	        params.put("contractorSupervisor_name", supervisor.getName());
	        params.put("contractorSupervisor_signature", supervisor.getSignature());

	        if (supervisor.getDateTime() != null) {
	            params.put("contractorSupervisor_date", new SimpleDateFormat("dd-MM-yyyy").format(supervisor.getDateTime()));
	            params.put("contractorSupervisor_time", new SimpleDateFormat("HH:mm:ss").format(supervisor.getDateTime()));
	        }
	    }

	    // Engineer Section
	    WeldingMachineRequest.GasCuttingCertifiedByRequest engineer = dto.getWeldingMachineCertifiedByEngineer();
	    if (engineer != null) {
	        params.put("engineer_id", engineer.getId());
	        params.put("engineer_certifiedBy", engineer.getCertifiedBy());
	        params.put("engineer_name", engineer.getName());
	        params.put("engineer_signature", engineer.getSignature());

	        if (engineer.getDateTime() != null) {
	            params.put("engineer_date", new SimpleDateFormat("dd-MM-yyyy").format(engineer.getDateTime()));
	            params.put("engineer_time", new SimpleDateFormat("HH:mm:ss").format(engineer.getDateTime()));
	        }
	    }

	    // Checklist Items
	    List<WeldingMachineRequest.GasCuttingListRequest> list = dto.getWeldingMachineList();
	    if (list != null) {
	        for (int i = 0; i < list.size(); i++) {
	            int index = i + 1;
	            WeldingMachineRequest.GasCuttingListRequest item = list.get(i);
	            params.put("checkListText_" + index, item.getCheckListText());
	            params.put("status_" + index, item.getStatus());
	            params.put("checklist_id_" + index, item.getId());
	        }
	    }

	    return params;
	}
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static Map<String, Object> flatten(lmraRequest dto) {
	    Map<String, Object> params = new HashMap<>();

	    if (dto == null) return params;

	    // Top-level fields
	    params.put("id", dto.getId());
	    params.put("company", dto.getCompany());
	    params.put("location", dto.getLocation());
	    params.put("task", dto.getTask());
	    params.put("additionalControls", dto.getAdditionalControls());
	    params.put("engineerName", dto.getEngineerName());
	    params.put("isJsaReviewed", dto.getIsJsaReviewed());

	    if (dto.getDateTime() != null) {
	        params.put("date", dto.getDateTime().format(DATE_FORMATTER));
	        params.put("time", dto.getDateTime().format(TIME_FORMATTER));
	    }

	    if (dto.getEngineerDateTime() != null) {
	        params.put("engineer_date", dto.getEngineerDateTime().format(DATE_FORMATTER));
	        params.put("engineer_time", dto.getEngineerDateTime().format(TIME_FORMATTER));
	    }

	    // Checklist (q1_yes/q1_no/q1_na ...)
	    List<lmraRequest.LmraCheckListRequest> checklist = dto.getLmraChecklist();
	    if (checklist != null) {
	        for (int i = 0; i < checklist.size(); i++) {
	            String prefix = "q" + (i + 1);
	            lmraRequest.LmraCheckListRequest item = checklist.get(i);
	            String remark = item.getRemark();
	            String normalized = remark == null ? "" : remark.trim().toUpperCase();

	            params.put(prefix + "_id", item.getId());
	            params.put(prefix + "_text", item.getCheckListText());
	            params.put(prefix + "_yes", normalized.equals("YES") ? "✓" : "");
	            params.put(prefix + "_no", normalized.equals("NO") ? "✓" : "");
	            params.put(prefix + "_na", (normalized.equals("NA") || normalized.equals("N/A")) ? "✓" : "");
	        }
	    }

	    // Worker Details
	    List<lmraRequest.LmraWorkerDetaiilsRequest> workers = dto.getWorkerDetaiils();
	    if (workers != null) {
	        for (int i = 0; i < workers.size(); i++) {
	            lmraRequest.LmraWorkerDetaiilsRequest w = workers.get(i);
	            int idx = i + 1;
	            params.put("worker_id_" + idx, w.getId());
	            params.put("workerName_" + idx, w.getWorkerName());
	            params.put("sign_" + idx, w.getSign());
	        }
	    }

	    return params;
	}


	public static Map<String, Object> flatten(Appendix3Request dto) {
		Map<String, Object> params = new HashMap<>();

		if (dto == null) return params;

		// Top-level fields
		params.put("id", dto.getId());
		params.put("jobDescription", dto.getJobDescription());
		params.put("issuerName", dto.getIssuerName());
		params.put("issuerSign", dto.getIssuerSign());
		params.put("gasTesterName", dto.getGasTesterName());
		params.put("gasTesterSign", dto.getGasTesterSign());

		if (dto.getIssuerDateTime() != null) {
			params.put("issuerDate", dto.getIssuerDateTime().format(DATE_FORMATTER));
			params.put("issuerTime", dto.getIssuerDateTime().format(TIME_FORMATTER));
		}

		if (dto.getGasTesterDateTime() != null) {
			params.put("gasTesterDate", dto.getGasTesterDateTime().format(DATE_FORMATTER));
			params.put("gasTesterTime", dto.getGasTesterDateTime().format(TIME_FORMATTER));
		}

		// Participants
		List<Appendix3Request.Appendix3List> participants = dto.getList() != null
				? new ArrayList<>(dto.getList())
				: new ArrayList<>();

		// Ensure 12 rows for PDF even if list is short
		while (participants.size() < 12) {
			participants.add(new Appendix3Request.Appendix3List());
		}

		for (int i = 0; i < participants.size(); i++) {
			Appendix3Request.Appendix3List p = participants.get(i);
			int index = i + 1;

			params.put("participant" + index + "_id", p.getId());
			params.put("participant" + index + "_name", p.getNameOfFe());
			params.put("participant" + index + "_o2", p.getPercentage());
			params.put("participant" + index + "_lel", p.getLel());
			params.put("participant" + index + "_h2sPpm", p.getH2s());
			params.put("participant" + index + "_sign", p.getSign());

			if (p.getDateTime() != null) {
				params.put("participant" + index + "_date", p.getDateTime().format(DATE_FORMATTER));
				params.put("participant" + index + "_time", p.getDateTime().format(TIME_FORMATTER));
			} else {
				params.put("participant" + index + "_date", "");
				params.put("participant" + index + "_time", "");
			}
		}

		// For JRBeanCollectionDataSource (if used)
		params.put("participants", new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(participants));

		return params;
	}

	public static Map<String, Object> flatten(ToolBoxTalkRequest dto) {
	    Map<String, Object> params = new HashMap<>();

	    if (dto == null) return params;

	    params.put("id", dto.getId());
	    params.put("topic", dto.getTopic());
	    params.put("topicCover", dto.getTopicCover());
	    params.put("tbtGiven", dto.getTbtGiven());
	    params.put("location", dto.getLocation());
	    params.put("hazards", dto.getHazards());
	    params.put("controls", dto.getControls());

	    if (dto.getDateTime() != null) {
	        params.put("date", dto.getDateTime().format(DATE_FORMATTER));
	        params.put("time", dto.getDateTime().format(TIME_FORMATTER));
	    }

	    ToolBoxTalkRequest.TbtDeliveredBy deliveredBy = dto.getTbtDeliveredBy();
	    if (deliveredBy != null) {
	        params.put("tbtDeliveredBy_id", deliveredBy.getId());
	        params.put("tbtDeliveredBy_name", deliveredBy.getName());
	        params.put("tbtDeliveredBy_signature", deliveredBy.getSignature());

	        if (deliveredBy.getDateTime() != null) {
	            params.put("tbtDeliveredBy_date", deliveredBy.getDateTime().format(DATE_FORMATTER));
	            params.put("tbtDeliveredBy_time", deliveredBy.getDateTime().format(TIME_FORMATTER));
	        }
	    }
	    List<ToolBoxTalkRequest.TbtParticipants> participants = dto.getParticipants();
	    if (participants != null && !participants.isEmpty()) {
	        for (int i = 0; i < participants.size(); i++) {
	            ToolBoxTalkRequest.TbtParticipants p = participants.get(i);
	            int index = i + 1;
	            params.put("participant_" + index + "_id", p.getId());
	            params.put("participant_" + index + "_name", p.getName());
	            params.put("participant_" + index + "_designation", p.getDesignation());
	            params.put("participant_" + index + "_gpNo", p.getGpNo());
	            params.put("participant_" + index + "_signature", p.getSignature());
	        }
	    }
	    return params;
	}

	public static Map<String, Object> flatten(Annexure3Request dto) {
	    Map<String, Object> flatMap = new HashMap<>();

	    if (dto == null) return flatMap;

	    flatMap.put("id", dto.getId());
	    flatMap.put("nameOfContractor", dto.getNameOfContractor());
	    flatMap.put("department", dto.getDepartment());
	    flatMap.put("extensionFrom", dto.getExtensionFrom());
	    flatMap.put("extensionTo", dto.getExtensionTo());
	    flatMap.put("isOptionOne", dto.getIsOptionOne());
	    flatMap.put("isOptionTwo", dto.getIsOptionTwo());
	    flatMap.put("wiremanLicense", dto.getWiremanLicense());

	    if (dto.getDateTimeFrom() != null) {
	        flatMap.put("dateTimeFrom_date", dto.getDateTimeFrom().format(DATE_FORMATTER));
	        flatMap.put("dateTimeFrom_time", dto.getDateTimeFrom().format(TIME_FORMATTER));
	    }
	    if (dto.getDateTimeTo() != null) {
	        flatMap.put("dateTimeTo_date", dto.getDateTimeTo().format(DATE_FORMATTER));
	        flatMap.put("dateTimeTo_time", dto.getDateTimeTo().format(TIME_FORMATTER));
	    }

	    List<Annexure3Request.Annexure3MachineList> machines = dto.getMachineList();
	    for (int i = 0; i < 3; i++) {
	        Annexure3Request.Annexure3MachineList m = (i < machines.size()) ? machines.get(i) : new Annexure3Request.Annexure3MachineList();
	        int idx = i + 1;
	        flatMap.put("machine_id_" + idx, m.getId());
	        flatMap.put("machineType_" + idx, m.getMachineType());
	        flatMap.put("machineNo_" + idx, m.getMachineNo());
	        flatMap.put("tagNo_" + idx, m.getTagNo());
	        flatMap.put("location_" + idx, m.getLocation());
	        flatMap.put("cwp_" + idx, m.getCwp());
	        flatMap.put("typeOfConnection_" + idx, m.getTypeOfConnection());
	    }

	    List<Annexure3Request.Annexure3CheckedBy> checkers = dto.getAnnexure3CheckedByList();
	    for (int i = 0; i < 3; i++) {
	        Annexure3Request.Annexure3CheckedBy c = (i < checkers.size()) ? checkers.get(i) : new Annexure3Request.Annexure3CheckedBy();
	        int idx = i + 1;
	        flatMap.put("checkedBy_id_" + idx, c.getId());
	        flatMap.put("checkedBy_name_" + idx, c.getName());
	        flatMap.put("checkedBy_signature_" + idx, c.getSignature());
	        flatMap.put("checkedBy_status_" + idx, c.getStatus());
	        flatMap.put("checkedBy_epEcNo_" + idx, c.getEpEcNo());

	        if (c.getDateTime() != null) {
	            flatMap.put("checkedBy_date_" + idx, c.getDateTime().toLocalDate().format(DATE_FORMATTER));
	            flatMap.put("checkedBy_time_" + idx, c.getDateTime().toLocalTime().format(TIME_FORMATTER));
	        }
	    }

	    List<Annexure3Request.Annexure3CheckpointsRequest> checkpoints = dto.getCheckpointsRequests();
	    if (checkpoints != null) {
	        for (int i = 0; i < checkpoints.size(); i++) {
	            Annexure3Request.Annexure3CheckpointsRequest cp = checkpoints.get(i);
	            int idx = i + 1;
	            flatMap.put("checkpoint_id_" + idx, cp.getId());
	            flatMap.put("checkpoint_text_" + idx, cp.getCheckpointText());
	            flatMap.put("response_" + idx, cp.getResponse());
	        }
	    }
	    return flatMap;
	}

	public static Map<String, Object> flatten(WorkPermitDTO dto) {
		Map<String, Object> flatMap = new HashMap<>();

		Map<String, String> permitTypes = Map.of("LIGHT HOT WORK", "prep_light_hot_work", "COLD WORK", "prep_cold_work",
				"CONFINED SPACE/VESSEL ENTRY", "prep_confined_space", "LINE BREAK", "prep_line_break", "HEAVY HOT WORK",
				"prep_heavy_hot_work");

		String dtoPermitType = Optional.ofNullable(dto.getPermitType())
				.map(s -> s.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_").replaceAll("_$", ""))
				.orElse("");

		permitTypes.forEach((label, key) -> {
			String normalizedLabel = label.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_")
					.replaceAll("_$", "");

			boolean found = normalizedLabel.equals(dtoPermitType);

			String symbol = found ? "\u2611" : "\u2610";
			flatMap.put(key, symbol);
		});
		if (dto.getValidFrom() != null) {
			flatMap.put("fromTime", dto.getValidFrom().toLocalTime().format(DateTimeFormatter.ofPattern("HH.mm")));
		}
		if (dto.getValidTo() != null) {
			flatMap.put("toTime", dto.getValidTo().toLocalTime().format(DateTimeFormatter.ofPattern("HH.mm")));
			flatMap.put("date", dto.getValidTo().toLocalDate().toString());
		}
		flatMap.put("equipmentName", dto.getEquipmentName());
		flatMap.put("equipmentTagNo", dto.getEquipmentTagNo());
		flatMap.put("contractorName", dto.getContractorName());
		flatMap.put("jobDescription", dto.getJobDescription());
		flatMap.put("personInvolved", dto.getPersonInvolved());
		flatMap.put("fadditionalInstructions", dto.getFadditionalInstructions());

		Map<String, Map<String, String>> sectionOptions = getSectionOptions();

		sectionOptions.forEach((section, options) -> {
			if ("sectionF".equals(section)) {
				List<WorkPermitDTO.SectionF> items = Optional.ofNullable(dto.getSectionF()).orElse(List.of());

				Set<String> selectedItems = items.stream().filter(p -> Boolean.TRUE.equals(p.getIsChecked()))
						.map(p -> p.getDescription().toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_")
								.replaceAll("_$", "").trim())

						.collect(Collectors.toSet());
				options.forEach((label, key) -> {
					String normalizedLabel = label.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_")
							.replaceAll("_$", "").trim();
					boolean found = selectedItems.contains(normalizedLabel);

					String symbol = found ? "\u2611" : "\u2610";
					flatMap.put(key, symbol);

					if (found) {
						items.stream().filter(p -> {
							String itemLabelNorm = p.getDescription().toLowerCase().replaceAll("[^a-z0-9]", "_")
									.replaceAll("_+", "_").replaceAll("_$", "").trim();
							String labelNorm = label.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_")
									.replaceAll("_$", "").trim();
							return itemLabelNorm.equals(labelNorm);
						})

								.findFirst().ifPresent(p -> {
									flatMap.put(key + "_a", p.getInputTextA());
									flatMap.put(key + "_b", p.getInputTextB());
									flatMap.put(key + "_c", p.getInputTextC());
								});
					}
				});
			} else {
				String data = switch (section) {
				case "sectionC" ->
					Optional.ofNullable(dto.getSectionC()).map(WorkPermitDTO.SectionC::getNature).orElse("");
				case "sectionD" ->
					Optional.ofNullable(dto.getSectionD()).map(WorkPermitDTO.SectionD::getTools).orElse("");
				case "sectionE" ->
					Optional.ofNullable(dto.getSectionE()).map(WorkPermitDTO.SectionE::getHazards).orElse("");
				case "sectionG" ->
					Optional.ofNullable(dto.getSectionG()).map(WorkPermitDTO.SectionG::getPreFire).orElse("");
				default -> "";
				};

				Set<String> selectedItems = Arrays.stream(data.split(",")).map(String::trim).map(
						s -> s.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_").replaceAll("_$", ""))
						.filter(s -> !s.isEmpty()).collect(Collectors.toSet());

				options.forEach((label, key) -> {
					String normalizedLabel = label.toLowerCase().replaceAll("[^a-z0-9]", "_").replaceAll("_+", "_")
							.replaceAll("_$", "");
					String symbol = selectedItems.contains(normalizedLabel) ? "\u2611" : "\u2610";
					flatMap.put(key, symbol);
				});

				if ("sectionC".equals(section) && dto.getSectionC() != null) {
					flatMap.put("nature_other_specify1", dto.getSectionC().getOtherNature());
				}
				if ("sectionD".equals(section) && dto.getSectionD() != null) {
					flatMap.put("tools_other_tools1", dto.getSectionD().getOtherTools());
				}
				if ("sectionE".equals(section) && dto.getSectionE() != null) {
					flatMap.put("hazard_other_hazard1", dto.getSectionE().getOtherHazard());
				}
				if ("sectionG".equals(section) && dto.getSectionG() != null) {
					flatMap.put("hazard_other_prefire1", dto.getSectionG().getOtherPrefire());
					flatMap.put("hazard_protective_suit1", dto.getSectionG().getProtectiveSuit());
				}
			}
		});

		// Section H
		List<WorkPermitDTO.SectionH> sectionHList = Optional.ofNullable(dto.getSectionH()).orElse(List.of());
		for (int i = 0; i < Math.min(6, sectionHList.size()); i++) {
			WorkPermitDTO.SectionH entry = sectionHList.get(i);
			int idx = i + 1;
			flatMap.put("gas_test_result_" + idx, entry.getResult());
			flatMap.put("gas_test_time_" + idx, entry.getDateTime() != null ? entry.getDateTime().toString() : "");

			flatMap.put("gas_test_gasTest_" + idx, entry.getGasTest());
			flatMap.put("gas_test_initials_" + idx, entry.getInitials());
			flatMap.put("gas_test_sign_" + idx, entry.getSign());
		}

		// Section I
		List<WorkPermitDTO.SectionI> sectionIList = Optional.ofNullable(dto.getSectionI()).orElse(List.of());
		for (int i = 0; i < Math.min(6, sectionIList.size()); i++) {
			WorkPermitDTO.SectionI entry = sectionIList.get(i);
			int idx = i + 1;
			flatMap.put("signatory_name_" + idx, entry.getName());
			if (entry.getDateTime() != null) {
				flatMap.put("signatory_date_" + idx, entry.getDateTime().toLocalDate().toString());
				flatMap.put("signatory_time_" + idx,
						entry.getDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
			}
			flatMap.put("signatory_sign_" + idx, entry.getSign());
			flatMap.put("signatory_role_" + idx, entry.getRole());
		}

		// Section K
		List<WorkPermitDTO.SectionK> sectionKList = Optional.ofNullable(dto.getSectionK()).orElse(List.of());
		for (int i = 0; i < Math.min(3, sectionKList.size()); i++) {
			WorkPermitDTO.SectionK entry = sectionKList.get(i);
			int idx = i + 1;
			flatMap.put("approval_name_" + idx, entry.getName());
			if (entry.getDateTime() != null) {
				flatMap.put("approval_date_" + idx, entry.getDateTime().toLocalDate().toString());
				flatMap.put("approval_time_" + idx,
						entry.getDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
			}
			flatMap.put("approval_status_" + idx, entry.getStatus());
			flatMap.put("approval_sign_" + idx, entry.getSign());
			flatMap.put("approval_role_" + idx, entry.getRole());
		}

		return flatMap;
	}

	private static Map<String, Map<String, String>> getSectionOptions() {
		return Map.of("sectionC",
				Map.ofEntries(Map.entry("welding/gas cutting", "nature_welding_gas_cutting"),
						Map.entry("radiation sources", "nature_radiation_sources"),
						Map.entry("opening of lines/ equipment", "nature_opening_lines_equipment"),
						Map.entry("work on electrical system", "nature_electrical_system"),
						Map.entry("hydrojetting", "nature_hydrojetting"), Map.entry("grinding", "nature_grinding"),
						Map.entry("working on instrument system", "nature_instrument_system"),
						Map.entry("photography", "nature_photography"),
						Map.entry("work on fragile roof", "nature_fragile_roof"),
						Map.entry("work at height", "nature_work_at_height"),
						Map.entry("isolation of fire water network", "nature_fire_water_isolation"),
						Map.entry("online leak sealing", "nature_online_leak_sealing"),
						Map.entry("excavation", "nature_excavation"), Map.entry("hot tapping", "nature_hot_tapping"),
						Map.entry("closure of roades", "nature_closure_of_roads"),
						Map.entry("others specify", "nature_others_specify"),
						Map.entry("preventive maintainance", "nature_preventive_maintenance"),
						Map.entry("insulation/painting", "nature_insulation_painting")),
				"sectionD",
				Map.ofEntries(Map.entry("welding machine", "tools_welding_machine"),
						Map.entry("hydrojetting machine", "tools_hydrojetting_machine"),
						Map.entry("gas cylinder", "tools_gas_cylinder"),
						Map.entry("air/hydralic operated equipment", "tools_air_hydralic"),
						Map.entry("non-flameproof equipment", "tools_non_flameproof"),
						Map.entry("others specify", "tools_others_specify"),
						Map.entry("vehicle no/crane no.", "tools_vehicle_crane"),
						Map.entry("portable electrical tool", "tools_portable_electrical"),
						Map.entry("grinding machine", "tools_grinding_machine"),
						Map.entry("stress releiving machine", "tools_stress_relieving")),
				"sectionE",
				Map.ofEntries(Map.entry("fire hazard", "hazard_fire"), Map.entry("electrical", "hazard_electrical"),
						Map.entry("pyrophric material", "hazard_pyrophoric"),
						Map.entry("presurized", "hazard_pressurized"),
						Map.entry("toxic material specify", "hazard_toxic"),
						Map.entry("oxygen deficient", "hazard_oxygen"),
						Map.entry("radiation hazards", "hazard_radiation"),
						Map.entry("conflicting activity", "hazard_conflict"),
						Map.entry("fall from height", "hazard_fall"), Map.entry("dust/fibres", "hazard_dust"),
						Map.entry("no of persons in confined space", "hazard_confined_space"),
						Map.entry("hot surface", "hazard_hot_surface"),
						Map.entry("underground hazards", "hazard_underground"),
						Map.entry("cave in hazards", "hazard_cavein"),
						Map.entry("others specify", "hazard_others_specify")),
				"sectionG",
				Map.ofEntries(Map.entry("fire extingusher", "hazard_fire_extinguisher"),
						Map.entry("fire blanket", "hazard_fire_blanket"),
						Map.entry("fire water hose ready/fire water available", "hazard_fire_water"),
						Map.entry("aireline mask", "hazard_aireline_mask"), Map.entry("scba", "hazard_scba"),
						Map.entry("cartridge gas mask", "hazard_cartridge_mask"),
						Map.entry("dust mask", "hazard_dust_mask"), Map.entry("face sheild", "hazard_face_shield"),
						Map.entry("chemical splash proof goggles", "hazard_goggles"),
						Map.entry("full body harness with life line", "hazard_body_harness"),
						Map.entry("others specify", "hazard_others_specify1"),
						Map.entry("protective suit specify", "hazard_protective_suit"),
						Map.entry("special gloves specify", "hazard_special_gloves")),
				"sectionF",
				Map.ofEntries(Map.entry("Isolated/Blinded", "prep_isolated_blinded"),
						Map.entry("Isolated/Blinded Check Sheet No", "prep_isolated_blinded_check_sheet_no"),
						Map.entry("Isolated/Blinded Tag Nos", "prep_isolated_blinded_tag_nos"),
						Map.entry("Depressurized/Drained Washed/Steamed/Purged Completely",
								"prep_depressurized_drained_washed_steamed_purged_completely"),
						Map.entry("Escape Route Checked & Clear", "prep_escape_route_checked_clear"),
						Map.entry("Electrical Isolation & Restoration Tag Nos",
								"prep_electrical_isolation_restoration_tag_nos"),
						Map.entry("Radioactive Source Isolated Tag Nos.", "prep_radioactive_source_isolated_tag_nos"),
						Map.entry("Filter Water Network Isolation Procedure",
								"prep_filter_water_network_isolation_procedure"),
						Map.entry("Compliance and Check Sheet No", "prep_compliance_and_check_sheet_no"),
						Map.entry("Online Leak Sealing Procedure Compliance",
								"prep_online_leak_sealing_procedure_compliance"),
						Map.entry("Full Body Harness with Life Line", "prep_full_body_harness_with_life_line"),
						Map.entry("Ventilation Ensured -blower/air Mover Provided",
								"prep_ventilation_ensured_blower_air_mover_provided"),
						Map.entry("Area Barricaded", "prep_area_barricaded"),
						Map.entry("Hot Tapping Procedure Compliance", "prep_hot_tapping_procedure_compliance"),
						Map.entry("Excavation Clearance obtained", "prep_excavation_clearance_obtained"),
						Map.entry("Ladders", "prep_ladders"), Map.entry("Scaffolding", "prep_scaffolding"),
						Map.entry("Pyrophoric Material Removed/Kept wet", "prep_pyrophoric_material_removed_kept_wet"),
						Map.entry("Risk Assessment Sheet No", "prep_risk_assessment_sheet_no"),
						Map.entry("Tool Box Talk Delivered", "prep_tool_box_talk_delivered"),
						Map.entry("8 Mts area checked for combustible material",
								"prep_8_mts_area_checked_for_combustible_material"),
						Map.entry("Hydro jetting Procedure Compliance", "prep_hydro_jetting_procedure_compliance"),
						Map.entry("Cover/Protect-sewer/Drain Channel", "prep_cover_protect_sewer_drain_channel"),
						Map.entry("Protect Surrounding area from Sparks & Fire",
								"prep_protect_surrounding_area_from_sparks_fire"),
						Map.entry("Ground the welding machine and Electrical Equipment",
								"prep_ground_the_welding_machine_and_electrical_equipment"),
						Map.entry("Use 24 Volt Hand Lamp (Flameproof)", "prep_use_24_volt_hand_lamp_flameproof"),
						Map.entry("Attendant/Firewatch Permit Holder required",
								"prep_attendant_firewatch_permit_holder_required"),
						Map.entry("Adequate Lighting", "prep_adequate_lighting"),
						Map.entry("Procedure Followed for Handrail/Grating Removal",
								"prep_procedure_followed_for_handrail_grating_removal"),
						Map.entry("Others Specify", "prep_others_specify")));
	}

	public static Map<String, Object> flatten(AttachedHitraRequest dto) {
	    Map<String, Object> params = new HashMap<>();

	    if (dto == null) return params;

	    // Top-level
	    params.put("id", dto.getId());
	    params.put("plantId", dto.getPlantId());
	    params.put("siteName", dto.getSiteName());
	    params.put("noOfPeopleExposed", dto.getNoOfPeopleExposed());
	    params.put("mainTask", dto.getMainTask());
	    if (dto.getDateTime() != null)
	        params.put("date", dto.getDateTime().format(DATE_FORMATTER));

	    // Issuer
	    if (dto.getHitraIssuer() != null) {
	        var issuer = dto.getHitraIssuer();
	        params.put("hitraIssuer_id", issuer.getId());
	        params.put("hitraIssuer_name", issuer.getName());
	        params.put("hitraIssuer_sign", issuer.getSign());
	        if (issuer.getDateTime() != null)
	            params.put("hitraIssuer_date", issuer.getDateTime().format(DATE_FORMATTER));
	    }

	    // Acceptor
	    if (dto.getHitraAcceptor() != null) {
	        var acceptor = dto.getHitraAcceptor();
	        params.put("hitraAcceptor_id", acceptor.getId());
	        params.put("hitraAcceptor_name", acceptor.getName());
	        params.put("hitraAcceptor_sign", acceptor.getSign());
	        if (acceptor.getDateTime() != null)
	            params.put("hitraAcceptor_date", acceptor.getDateTime().format(DATE_FORMATTER));
	    }

	    // Supervisor
	    if (dto.getHitraSupervisor() != null) {
	        var sup = dto.getHitraSupervisor();
	        params.put("hitraSupervisor_id", sup.getId());
	        params.put("hitraSupervisor_name", sup.getName());
	        params.put("hitraSupervisor_sign", sup.getSign());
	        if (sup.getDateTime() != null)
	            params.put("hitraSupervisor_date", sup.getDateTime().format(DATE_FORMATTER));
	    }

	    // Team (max 5)
	    List<AttachedHitraRequest.HitraTeamRequest> team = dto.getHitraTeam();
	    if (team != null) {
	        for (int i = 0; i < Math.min(team.size(), 5); i++) {
	            var member = team.get(i);
	            int idx = i + 1;
	            params.put("hitraTeam_id_" + idx, member.getId());
	            params.put("hitraTeam_name_" + idx, member.getName());
	            params.put("hitraTeam_role_" + idx, member.getRole());
	            params.put("hitraTeam_sign_" + idx, member.getSign());
	            if (member.getDateTime() != null)
	                params.put("hitraTeam_date_" + idx, member.getDateTime().format(DATE_FORMATTER));
	        }
	    }

	    // SubTasks (max 9)
	    List<AttachedHitraRequest.AttachedSubTaskRequest> subTasks = dto.getSubTasks();
	    if (subTasks != null) {
	        for (int i = 0; i < Math.min(subTasks.size(), 9); i++) {
	            var subTask = subTasks.get(i);
	            int taskIdx = i + 1;
	            params.put("subTask_id_" + taskIdx, subTask.getId());
	            params.put("subTaskTitle_" + taskIdx, subTask.getSubTaskTitle());
	            params.put("hazardDescription_" + taskIdx, subTask.getHazardDescription());
	            params.put("initialImpact_" + taskIdx, subTask.getInitialImpact());
	            params.put("initialProbability_" + taskIdx, subTask.getInitialProbability());
	            params.put("initialRisk_" + taskIdx, subTask.getInitialRisk());
	            params.put("finalImpact_" + taskIdx, subTask.getFinalImpact());
	            params.put("finalProbability_" + taskIdx, subTask.getFinalProbability());
	            params.put("finalRisk_" + taskIdx, subTask.getFinalRisk());

	            // Controls under each subtask
	            List<AttachedHitraRequest.HitraSubTaskControlsRequest> controls = subTask.getControls();
	            if (controls != null) {
	                for (int j = 0; j < controls.size(); j++) {
	                    int ctrlIdx = j + 1;
	                    var ctrl = controls.get(j);
	                    params.put("control_" + taskIdx + "_" + ctrlIdx + "_id", ctrl.getId());
	                    params.put("control_" + taskIdx + "_" + ctrlIdx + "_text", ctrl.getControlText());
	                    params.put("control_" + taskIdx + "_" + ctrlIdx + "_actionParty", ctrl.getActionParty());
	                }
	            }
	        }
	    }

	    return params;
	}

