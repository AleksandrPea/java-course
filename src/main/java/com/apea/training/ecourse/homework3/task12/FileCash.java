package com.apea.training.ecourse.homework3.task12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.Optional;

public class FileCash {

    private File file;

    private SoftReference<byte[]> data = new SoftReference<>(null);

    private FileCash(File file) {
        this.file = file;
    }

    public static FileCash create(String path) {
        File file = new File(path);
        return new FileCash(file);
    }

    public static byte[] readFile(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Optional<String> content = reader.lines().reduce(String::concat);
        return content.get().getBytes();
    }

    public byte[] getData() {
        if (data.get() == null) {
            byte[] data = null;
            try {
                Thread.sleep(250);  // for training purporses
                data = readFile(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = new SoftReference<>(data);
        }
        return this.data.get();
    }
}
