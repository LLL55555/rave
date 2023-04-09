/*
package com.cola.zhongdian.controller;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

*/
/**
 * 在线office预览
 *
 * @Author admin
 **//*

@Api(tags = "在线office预览")
@Controller
@RequestMapping("api/office")
public class OfficeApiController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("previewPdf")
    public void pdf(String url, HttpServletResponse response) throws Exception {
        if (StringUtils.isBlank(url)) {
            return;
        }
        File file = null;
        // 文件后缀
        String suffix = url.substring(url.lastIndexOf(".") + 1);
        // 如果是PDF
        if ("pdf".equals(suffix)) {
            HttpURLConnection httpUrl = (HttpURLConnection) new URL(url).openConnection();
            httpUrl.connect();
            file = PdfUtils.inputStreamToFile(httpUrl.getInputStream(), UUID.randomUUID().toString() + ".pdf");
            response.setContentType("application/pdf");
        }
        // 如果是文本
        else if ("txt".equals(suffix)) {
            HttpURLConnection httpUrl = (HttpURLConnection) new URL(url).openConnection();
            httpUrl.connect();
            file = PdfUtils.inputStreamToFile(httpUrl.getInputStream(), UUID.randomUUID().toString() + ".txt");
            response.setContentType("text/html");
        }
        // 如果是doc
        else if ("doc".equals(suffix) || "docx".equals(suffix)) {
            file = new File(PdfUtils.word2pdf(url, System.getProperty("user.dir") + UUID.randomUUID().toString() + ".pdf"));
            response.setContentType("application/pdf");
        }
        // 如果是excel
        else if ("xls".equals(suffix) || "xlsx".equals(suffix)) {
            file = new File(PdfUtils.excel2pdf(url, System.getProperty("user.dir") + UUID.randomUUID().toString() + ".pdf"));
            response.setContentType("application/pdf");
        }
        // 如果是ppt
        else if ("ppt".equals(suffix) || "pptx".equals(suffix)) {
            file = new File(PdfUtils.ppt2pdf(url, System.getProperty("user.dir") + UUID.randomUUID().toString() + ".pdf"));
            response.setContentType("application/pdf");
        }
        // 如果文件为空
        if (null == file) {
            return;
        }
        try {
            response.setCharacterEncoding("UTF-8");
            InputStream stream = new FileInputStream(file);
            ServletOutputStream out = response.getOutputStream();
            byte buff[] = new byte[1024];
            int length = 0;
            while ((length = stream.read(buff)) > 0) {
                out.write(buff, 0, length);
            }
            stream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
