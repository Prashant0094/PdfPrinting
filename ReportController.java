package com.prashant.pdfprinting.controller;

import java.io.FileNotFoundException;
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

        GasCuttingRequest dto = objectMapper.readValue(is, GasCuttingRequest.class);

        
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

        WeldingMachineRequest dto = objectMapper.readValue(is, WeldingMachineRequest.class);

        
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateWeldingSafetyPdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=weldingSafety.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    
    @GetMapping("/lmra")
    public ResponseEntity<byte[]> generateLmraPdf() throws Exception {

        InputStream is = getClass().getResourceAsStream("/lmra.json");
        if (is == null) {
            throw new FileNotFoundException("lmra.json not found in resources.");
        }
        lmraRequest dto = objectMapper.readValue(is, lmraRequest.class);
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateLmraPdf(dto, params);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=lmra_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/appendix3")
    public ResponseEntity<byte[]> generateGasTestingPdf() throws Exception {

        InputStream is = getClass().getResourceAsStream("/appendix3json.json"); 
        if (is == null) {
            throw new FileNotFoundException("appendix3json.json not found in resources.");
        }
        Appendix3Request dto = objectMapper.readValue(is, Appendix3Request.class);
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateAppendix3Pdf(dto, params);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=appendix3.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/tbt")
    public ResponseEntity<byte[]> generateToolBoxTalkPdf() throws Exception {

        InputStream is = getClass().getResourceAsStream("/ToolBoxTalk.json"); 
        if (is == null) {
            throw new FileNotFoundException("toolboxtalk.json not found in resources.");
        }
        ToolBoxTalkRequest dto = objectMapper.readValue(is, ToolBoxTalkRequest.class);
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateToolBoxTalkPdf(dto, params);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=toolboxtalk.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/annexure3")
    public ResponseEntity<byte[]> generateAnnexure3Pdf() throws Exception {

        InputStream is = getClass().getResourceAsStream("/Annexure3json.json"); 
        if (is == null) {
            throw new FileNotFoundException("Annexure3.json not found in resources.");
        }
        Annexure3Request dto = objectMapper.readValue(is, Annexure3Request.class);
        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateAnnexure3Pdf(dto);	
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=annexure3.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    @GetMapping("/work-permit")
    public ResponseEntity<byte[]> generateWorkPermitPdf() throws Exception {
        InputStream is = getClass().getResourceAsStream("/WorkPermitSample.json");
        if (is == null) {
            throw new FileNotFoundException("WorkPermitSample.json not found in resources.");
        }

        WorkPermitDTO dto = objectMapper.readValue(is, WorkPermitDTO.class);

        byte[] pdf = reportService.generateWorkPermitPdf(dto);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=work_permit.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
    
    @GetMapping("/hitra")
    public ResponseEntity<byte[]> generateHitraReport() throws Exception {

        InputStream is = getClass().getResourceAsStream("/hitra.json");
        if (is == null) throw new RuntimeException("Where is hitrademo.json? again?");

        AttachedHitraRequest dto = objectMapper.readValue(is, AttachedHitraRequest.class);

        Map<String, Object> params = JsonFlattener.flatten(dto);
        byte[] pdf = reportService.generateHitraPdf(dto, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=hitra.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }



}

