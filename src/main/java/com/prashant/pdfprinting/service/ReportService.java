package com.prashant.pdfprinting.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;
import com.prashant.pdfprinting.dto.Annexure3DTO;
import com.prashant.pdfprinting.dto.Appendix1DTO;
import com.prashant.pdfprinting.dto.Appendix2DTO;
import com.prashant.pdfprinting.dto.Appendix3DTO;
import com.prashant.pdfprinting.dto.GasCuttingDTO;
import com.prashant.pdfprinting.dto.LmraDTO;
import com.prashant.pdfprinting.dto.ToolBoxTalkDTO;
import com.prashant.pdfprinting.dto.WeldingSafetyDTO;
import com.prashant.pdfprinting.dto.WorkPermitDTO;
import com.prashant.pdfprinting.flattner.JsonFlattener;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	public byte[] generateAnnexure1Pdf(Annexure1DTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Annexure-1.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getList());
	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateAnnexure2Pdf(Annexure2DTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Annexure-2.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getAnnexure2CheckPointsList());

	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateAppendix1Pdf(Appendix1DTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Appendix-1.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getAppendixRequestList());

	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateAppendix2Pdf(Appendix2DTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Appendix-2.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getAppendixRequestList());

	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateGasCuttingPdf(GasCuttingDTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Gas Cutting Safety.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getList());

	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateWeldingSafetyPdf(WeldingSafetyDTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Welding Safety.jrxml");
	    JasperReport report = JasperCompileManager.compileReport(template);

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getWeldingMachineList());

	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	
	public byte[] generateLmraPdf(LmraDTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/LMRA.jrxml");
	    if (template == null) {
	        throw new FileNotFoundException("LmraReport.jrxml template not found in resources.");
	    }
	    JasperReport report = JasperCompileManager.compileReport(template);
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getLmraWorkerDetails());
	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
	    return JasperExportManager.exportReportToPdf(print);
	}
	
	public byte[] generateAppendix3Pdf(Appendix3DTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/Appendix-3.jrxml");
	    if (template == null) {
	        throw new FileNotFoundException("Appendix-3.jrxml template not found in resources.");
	    }

	    List<Appendix3DTO.Participant> participants = new ArrayList<>(dto.getParticipants());
	    while (participants.size() < 12) {
	        participants.add(new Appendix3DTO.Participant()); 
	    }

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(participants);

	
	    JasperReport report = JasperCompileManager.compileReport(template);
	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateToolBoxTalkPdf(ToolBoxTalkDTO dto, Map<String, Object> params) throws JRException, IOException {
	    InputStream template = getClass().getResourceAsStream("/ToolBoxTalk.jrxml");
	    if (template == null) {
	        throw new FileNotFoundException("ToolBoxTalk.jrxml template not found in resources.");
	    }

	    List<ToolBoxTalkDTO.Participant> participants = new ArrayList<>(dto.getParticipants());
	    while (participants.size() < 16) {
	        participants.add(new ToolBoxTalkDTO.Participant()); 
	    }

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(participants);

	
	    JasperReport report = JasperCompileManager.compileReport(template);
	    JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);

	    return JasperExportManager.exportReportToPdf(print);
	}
	public byte[] generateAnnexure3Pdf(Annexure3DTO dto) throws JRException, IOException {
  
        Map<String, Object> params = JsonFlattener.flatten(dto);

        InputStream template = getClass().getResourceAsStream("/Annexure-3.jrxml");
        if (template == null) {
            throw new FileNotFoundException("Annexure-3.jrxml template not found in resources.");
        }

        JasperReport report = JasperCompileManager.compileReport(template);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto.getAnnexure3CheckedByList());

        JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
        return JasperExportManager.exportReportToPdf(print);
    }
	
}
