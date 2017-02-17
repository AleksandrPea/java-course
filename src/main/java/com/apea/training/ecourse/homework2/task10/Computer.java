package com.apea.training.ecourse.homework2.task10;

public class Computer {

    private Info info;

    private Computer(Info info) {
        this.info = info;
    }

    public String getOS() {
        return info.OS;
    }

    public String getProcessor() {
        return info.processor;
    }

    public String getROM() {
        return info.ROM;
    }

    public static Computer createComputer(String OS, String processor, String ROM) {
        if (OS == null || processor == null || ROM == null) {
            throw new IllegalArgumentException("Wrong argument");
        }
        return new Computer(new Info(OS, processor, ROM));
    }

    private static class Info {
        String OS;
        String processor;
        String ROM;

        Info(String OS, String processor, String ROM) {
            this.OS = OS;
            this.processor = processor;
            this.ROM = ROM;
        }
    }


}
