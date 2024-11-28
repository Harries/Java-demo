package com.et;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Numberings;
import com.deepoove.poi.data.Tables;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.BorderStyle;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ContractGenerator {

    public static void main(String[] args) {
        // ģ���ļ�·��
        String templatePath = "D:\\IdeaProjects\\Java-demo\\poi-tl\\src\\main\\resources\\contract-template.docx";
        // ����ļ�·��
        String outputPath = "D:\\IdeaProjects\\Java-demo\\poi-tl\\src\\main\\resources\\generated-contract.docx";

        // ׼������
        Map<String, Object> data = new HashMap<>();
        data.put("contractId", "C-20231001");
        data.put("customerName", "����");
        data.put("signDate", "2023-10-01");
        data.put("amount", new TextRenderData("��100,000"));
        data.put("svg", "https://img.shields.io/badge/jdk-1.6%2B-orange.svg");

        data.put("table0", Tables.of(new String[][] {
                new String[] { "00", "01" },
                new String[] { "10", "11" }
        }).border(BorderStyle.DEFAULT).create());
        data.put("list", Numberings.create("Plug-in grammar",
                "Supports word text, pictures, table...",
                "Not just templates"));

        // ����ģ�岢��Ⱦ����
        try (XWPFTemplate template = XWPFTemplate.compile(templatePath).render(data);
             FileOutputStream out = new FileOutputStream(outputPath)) {
            template.write(out);
            System.out.println("��ͬ���ɳɹ���");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}