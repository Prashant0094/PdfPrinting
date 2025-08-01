package com.prashant.pdfprinting.controller;

import java.io.InputStream;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; // changed from PostMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Appendix1DTO;
import com.prashant.pdfprinting.dto.Appendix2DTO;
import com.prashant.pdfprinting.dto.GasCuttingDTO;
import com.prashant.pdfprinting.dto.WeldingSafetyDTO;
import com.prashant.pdfprinting.flattner.JsonFlattener;
import com.prashant.pdfprinting.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    private final ObjectMapper objectMapper;

    public ReportController(ReportService reportService, ObjectMapper objectMapper) {
        this.reportService = reportService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/annexure1") 
    public ResponseEntity<byte[]> generateReport() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/annexure1demo.json");
        if (is == null) throw new RuntimeException("Where is annexure1demo.json?  again?");

        Annexure1DTO dto = objectMapper.readValue(is, Annexure1DTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateAnnexure1Pdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=annexure1.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/annexure2") 
    public ResponseEntity<byte[]> generateReport1() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/annexure2demo.json");
        if (is == null) throw new RuntimeException("Where is annexure2demo.json?  again?");

        Annexure2DTO dto1 = objectMapper.readValue(is, Annexure2DTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto1);
        byte[] pdf = reportService.generateAnnexure2Pdf(dto1, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=annexure2.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/appendix1") 
    public ResponseEntity<byte[]> generateReportAppendix1() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/appendix1demo.json");
        if (is == null) throw new RuntimeException("Where is appendix1demo.json?  again?");

        Appendix1DTO dto = objectMapper.readValue(is, Appendix1DTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateAppendix1Pdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appendix1.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/appendix2") 
    public ResponseEntity<byte[]> generateReportAppendix2() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/appendix2demo.json");
        if (is == null) throw new RuntimeException("Where is appendix2demo.json?  again?");

        Appendix2DTO dto = objectMapper.readValue(is, Appendix2DTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateAppendix2Pdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appendix2.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/gascut") 
    public ResponseEntity<byte[]> generateGasCuttingPdf() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/gascutting.json");
        if (is == null) throw new RuntimeException("Where is gascutting.json?  again?");

        GasCuttingDTO dto = objectMapper.readValue(is, GasCuttingDTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateGasCuttingPdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=gasCutting.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/welding") 
    public ResponseEntity<byte[]> generateWeldingSafetyPdf() throws Exception {
    
        InputStream is = getClass().getResourceAsStream("/weldingSafety.json");
        if (is == null) throw new RuntimeException("Where is weldingSafety.json?  again?");

        WeldingSafetyDTO dto = objectMapper.readValue(is, WeldingSafetyDTO.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateWeldingSafetyPdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=weldingSafety.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
