package com.cola.zhongdian.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Admin
 */
@RestController
public class WordToPdfController {
    
    @PostMapping("/upload002")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) throws DocumentException {
        try {
            // Read the Word document
            InputStream inputStream = file.getInputStream();
            XWPFDocument document = new XWPFDocument(inputStream);
            
            // Convert the Word document to PDF
            Document pdfDocument = new Document(PageSize.A4);
            PdfWriter.getInstance(pdfDocument, new FileOutputStream("output.pdf"));
            pdfDocument.open();
            
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null) {
                        Paragraph pdfParagraph = new Paragraph(text);
                        pdfParagraph.setAlignment(Element.ALIGN_LEFT);
                        pdfDocument.add(pdfParagraph);
                    }
                }
            }
            
            pdfDocument.close();
            
            // Return the PDF file for preview
            byte[] pdfContent = Files.readAllBytes(Paths.get("output.pdf"));
            return new ResponseEntity(pdfContent, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Unable to convert the file to PDF", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
