package com.et;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

public class OshiExample {
    public static void main(String[] args) {
        // ���� SystemInfo ����
        SystemInfo systemInfo = new SystemInfo();

        // ��ȡ CPU ��Ϣ
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        System.out.println("CPU �߼�������: " + processor.getLogicalProcessorCount());
        System.out.println("CPU ���������: " + processor.getPhysicalProcessorCount());
        System.out.println("CPU ��Ӧ��: " + processor.getProcessorIdentifier().getVendor());
        System.out.println("CPU ����: " + processor.getProcessorIdentifier().getName());

        // ��ȡ�ڴ���Ϣ
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        System.out.println("���ڴ�: " + formatBytes(memory.getTotal()));
        System.out.println("�����ڴ�: " + formatBytes(memory.getAvailable()));

        // ��ȡ����ϵͳ��Ϣ
        OperatingSystem os = systemInfo.getOperatingSystem();
        System.out.println("����ϵͳ: " + os.toString());
        System.out.println("ϵͳ����ʱ��: " + os.getSystemBootTime());
    }

    // ��ʽ���ֽ���Ϊ�ɶ���ʽ
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}