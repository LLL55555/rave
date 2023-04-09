package com.cola.zhongdian.utils;

import cn.hutool.core.io.IoUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

public class FreemarkerUtils {

    /**
     * 生成Word
     * @param templateDir   模板所在的目录
     * @param templateName  模板文件名称
     * @param filename      生成的文件（含路径）
     * @param dataModel     模板参数数据
     */
    public static void generateWord(File templateDir, String templateName, String filename, Object dataModel) {
        BufferedWriter writer = null;
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        try {
            configuration.setDirectoryForTemplateLoading(templateDir);
            Template template = configuration.getTemplate(templateName);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            template.process(dataModel, writer);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } finally {
            IoUtil.close(writer);
        }
    }

}