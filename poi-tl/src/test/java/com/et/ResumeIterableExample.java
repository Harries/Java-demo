package com.et;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Numberings;
import com.deepoove.poi.data.Pictures;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;

@DisplayName("Foreach resume example")
public class ResumeIterableExample {

    ResumeDataV2 datas = new ResumeDataV2();

    @BeforeEach
    public void init() {
        datas.setPortrait(Pictures.ofLocal("src/test/resources/sayi.png").size(100, 100).create());
        datas.setName("ئһ");
        datas.setJob("BUG����ʦ");
        datas.setPhone("18080809090");
        datas.setSex("��");
        datas.setProvince("����");
        datas.setBirthday("2000.08.19");
        datas.setEmail("adasai90@gmail.com");
        datas.setAddress("�㽭ʡ�������������ŵ�1��");
        datas.setEnglish("CET6 620");
        datas.setUniversity("����˹̹����ѧ");
        datas.setProfession("��������");
        datas.setEducation("ѧʿ");
        datas.setRank("�༶���� 1/36");
        datas.setHobbies("���֡�������ƹ�������Ρ�����\nhttps://github.com/Sayi");

        // ����ջ����
        TextRenderData textRenderData = new TextRenderData("SpringBoot��SprigCloud��Mybatis");
        Style style = Style.builder().buildFontSize(10).buildColor("7F7F7F").buildFontFamily("΢���ź�").build();
        textRenderData.setStyle(style);
        datas.setStack(Numberings.of(textRenderData, textRenderData, textRenderData).create());

        /*
         * {{?experiences}} {{company}} {{department}} {{time}} {{position}}
         * {{*responsibility}} {{/experiences}}
         */
        List<ExperienceData> experiences = new ArrayList<ExperienceData>();
        ExperienceData data0 = new ExperienceData();
        data0.setCompany("���΢��");
        data0.setDepartment("Office ��ҵ��");
        data0.setTime("2001.07-2020.06");
        data0.setPosition("BUG����ʦ");
        textRenderData = new TextRenderData("��������BUG��Ȼ���޸�BUG��ͬʱ��Чʵʩ��Ƹ��Ϊ");
        textRenderData.setStyle(style);
        data0.setResponsibility(Numberings.of(textRenderData, textRenderData).create());
        ExperienceData data1 = new ExperienceData();
        data1.setCompany("����ְҵ");
        data1.setDepartment("OpenSource ��Ŀ��");
        data1.setTime("2015.07-2020.06");
        data1.setPosition("�з�����ʦ");
        textRenderData = new TextRenderData("��Դ��Ŀ�ĵ�����ά������");
        textRenderData.setStyle(style);
        TextRenderData textRenderData1 = new TextRenderData("�������ɡ�Swagger�ĵ��ȹ��ߵ���");
        textRenderData1.setStyle(style);
        data1.setResponsibility(Numberings.of(textRenderData, textRenderData1, textRenderData).create());
        experiences.add(data0);
        experiences.add(data1);
        experiences.add(data0);
        experiences.add(data1);
        datas.setExperiences(experiences);
    }

    @Test
    public void testResumeExample() throws Exception {
        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/resume.docx").render(datas);

        FileOutputStream out = new FileOutputStream("target/out_example_resume_iterable.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

}