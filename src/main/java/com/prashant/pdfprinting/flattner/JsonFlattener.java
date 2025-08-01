package com.prashant.pdfprinting.flattner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO.Annexure2CheckPoint;
import com.prashant.pdfprinting.dto.Appendix1DTO;
import com.prashant.pdfprinting.dto.Appendix2DTO;
import com.prashant.pdfprinting.dto.GasCuttingDTO;
import com.prashant.pdfprinting.dto.LmraDTO;
import com.prashant.pdfprinting.dto.LmraDTO.LmraWorkerDetails;
import com.prashant.pdfprinting.dto.WeldingSafetyDTO;

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
        params.put("phase",dto2.getPhase());
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
        params.put("phase",dto3.getPhase());
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

        // Unicode ✓ marker logic per checklist item
        List<LmraDTO.LmraChecklistItem> checklist = dto.getLmraChecklist();
        for (int i = 0; i < checklist.size(); i++) {
            String prefix = "q" + (i + 1);
            String remark = checklist.get(i).getRemark();

            params.put(prefix + "_yes", "YES".equalsIgnoreCase(remark) ? "✓" : "");
            params.put(prefix + "_no", "NO".equalsIgnoreCase(remark) ? "✓" : "");
            params.put(prefix + "_na", "N/A".equalsIgnoreCase(remark) ? "✓" : "");
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

}

