package com.cola.zhongdian.test;

import cn.hutool.core.io.IoUtil;
import com.cola.zhongdian.utils.FreemarkerUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class WordTest {

    /**
     * 1、从文件服务器下载模板文件
     * 2、根据业务类型获取需要填充模板的数据
     * 3、模板+数据  再经过处理生成新的文件
     * 4、将生成后的文件上传到文件服务器，并返回一个文件ID
     * 5、业务可以保存这个文件ID或者文件的路径
     */
    @Test
    void testGenerateWordV1() throws Exception {
        Path tempPath = Paths.get("tmp", "contract2");
        File path = tempPath.toFile();
        if (!path.exists()) {
            path.mkdirs();
        }
        File tempFile = Files.createTempFile(tempPath, "qiantiao", ".docx").toFile();
        System.out.println(tempFile.getParent());
        System.out.println(tempFile.getName());
        FileOutputStream fos = new FileOutputStream(tempFile);


        File templateFile = ResourceUtils.getFile("classpath:templates/借条.ftl");
        FileInputStream fis = new FileInputStream(templateFile);

        IoUtil.copy(fis, fos);

        String filename = "借条" + "_" + System.currentTimeMillis() + ".docx";
        filename = "tmp/contract" + File.separator + filename;

        FreemarkerUtils.generateWord(new File(tempFile.getParent()), tempFile.getName(), filename, getDataMap());
    }

 	/**
     * 获取数据
     */
    Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("borrowerName", "李白2");
        dataMap.put("borrowerIdCard", "421302199001012426");
        dataMap.put("lenderName", "杜甫");
        dataMap.put("amount", 100);
        dataMap.put("amountInWords", "壹佰");
        dataMap.put("startDate", "2022年8月15日");
        dataMap.put("endDate", "2022年11月11日");
        dataMap.put("borrowingMonths", 3);
        dataMap.put("interestRate", "1.23");
        dataMap.put("guarantorName", "白居易");
        dataMap.put("guarantorIdCard", "421302199203152412");
        return dataMap;
    }

    @Test
    void testGenerateWord2() throws Exception {
        File templateDir = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "templates");
        String templateName = "借条.ftl";
        String destFilename = "借条" + System.currentTimeMillis() + ".docx";
        Map<String, Object> data = getDataMap();
        FreemarkerUtils.generateWord(templateDir, templateName, destFilename, data);
    }

}