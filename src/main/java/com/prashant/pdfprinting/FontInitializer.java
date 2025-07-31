package com.prashant.pdfprinting;


import java.util.Collection;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.fonts.FontUtil;

@Component
public class FontInitializer {
	@PostConstruct
	public void initFonts() {
	    DefaultJasperReportsContext.getInstance(); 
	    System.out.println("✅ JasperReportsContext initialized.");

	    registerFonts(); 
	}

	public void registerFonts() {
	    FontUtil fontUtil = FontUtil.getInstance(DefaultJasperReportsContext.getInstance());
	    Collection<String> fonts = fontUtil.getFontFamilyNames(); 

	    System.out.println("✅ Registered font families:");
	    fonts.forEach(System.out::println);
	}
}
