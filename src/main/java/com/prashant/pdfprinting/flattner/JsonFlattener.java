package com.prashant.pdfprinting.flattner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO.Annexure2CheckPoint;

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

        return params;
    }
}

