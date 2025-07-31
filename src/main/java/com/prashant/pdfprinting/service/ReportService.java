package com.prashant.pdfprinting.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prashant.pdfprinting.dto.Annexure1DTO;
import com.prashant.pdfprinting.dto.Annexure2DTO;

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

}
