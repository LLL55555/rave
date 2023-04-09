package com.cola.zhongdian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * 对文件操作的接口
 */
@RestController("/file")
public class FileController {

    @Value("${file.upload.path}")
    private String uploadPath;

    /**
     * 文件通用下载(从项目路径resources目录下的路径下载pdf)
     * @param fileName
     * @return
     * @throws IOException
     */
    @GetMapping("/downloadPDF")
    public ResponseEntity<Resource> downloadPDF(@RequestParam String fileName) throws IOException {
        Path filePath = Paths.get(uploadPath, fileName);
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) {
        Path filePath = Paths.get(uploadPath, fileName);
        if (Files.exists(filePath)) {
            try {
                ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
                headers.setContentType(getMediaType(filePath));
                return new ResponseEntity<>(resource, headers, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private MediaType getMediaType(Path filePath) {
        String contentType = URLConnection.guessContentTypeFromName(filePath.toString());
        return MediaType.parseMediaType(contentType);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}