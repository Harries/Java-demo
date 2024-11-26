package com.et;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

public class OshiExample {
    public static void main(String[] args) {
        // Create a SystemInfo object
        SystemInfo systemInfo = new SystemInfo();

        // Get CPU information
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        System.out.println("CPU Logical Processor Count: " + processor.getLogicalProcessorCount());
        System.out.println("CPU Physical Processor Count: " + processor.getPhysicalProcessorCount());
        System.out.println("CPU Vendor: " + processor.getProcessorIdentifier().getVendor());
        System.out.println("CPU Name: " + processor.getProcessorIdentifier().getName());

        // Get memory information
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        System.out.println("Total Memory: " + formatBytes(memory.getTotal()));
        System.out.println("Available Memory: " + formatBytes(memory.getAvailable()));

        // Get operating system information
        OperatingSystem os = systemInfo.getOperatingSystem();
        System.out.println("Operating System: " + os.toString());
        System.out.println("System Boot Time: " + os.getSystemBootTime());
    }

    // Format bytes into a readable format
    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}