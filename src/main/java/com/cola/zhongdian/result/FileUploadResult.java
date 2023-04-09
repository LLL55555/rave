package com.cola.zhongdian.result;

public class FileUploadResult {
    private final String fileName;
    private final String filePath;

    public FileUploadResult(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

}