package com.batman.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.batman.dto.DummyDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class MainController {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException, DocumentException {

		String templateName = "sample.ftl";
		DummyDTO order = new DummyDTO();
		order.setName("honey singh");
		order.setAge(16);
		Map<String, Object> input = new HashMap<String, Object>();
		//put entire order object and read prop in ftl as ${object.field1}
		//no need to individually put each field in map
		input.put("user", order);
		input.put("invoice", order);
		freemarker.template.Configuration cnfg = new freemarker.template.Configuration();
		cnfg.setClassForTemplateLoading(MainController.class, "/");
		freemarker.template.Template template = cnfg.getTemplate(templateName);
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, input);

		System.out.println(html);

		Document document = new Document();
		//our output stream will be object which we get in method args
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("bin/html.pdf"));
		document.open();
		//inputstream is html string 
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes()));
		document.close();
		
		//we can make separate ftl and import based on needs

	}

}
