package com.et;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

public class OshiExample {
    public static void main(String[] args) {
        // 创建 SystemInfo 对象
        SystemInfo systemInfo = new SystemInfo();

        // 获取 CPU 信息
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        System.out.println("CPU 逻辑核心数: " + processor.getLogicalProcessorCount());
        System.out.println("CPU 物理核心数: " + processor.getPhysicalProcessorCount());
        System.out.println("CPU 供应商: " + processor.getProcessorIdentifier().getVendor());
        System.out.println("CPU 名称: " + processor.getProcessorIdentifier().getName());

        // 获取内存信息
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        System.out.println("总内存: " + formatBytes(memory.getTotal()));
        System.out.println("可用内存: " + formatBytes(memory.getAvailable()));

        // 获取操作系统信息
        OperatingSystem os = systemInfo.getOperatingSystem();
        System.out.println("操作系统: " + os.toString());
        System.out.println("系统启动时间: " + os.getSystemBootTime());
    }

    // 格式化字节数为可读格式
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}