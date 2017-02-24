package com.apea.training.ecourse.homework3.task12;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class FileCashTest {

    private FileCash fileCash = FileCash.create("file.txt");

    @Test(expected = NullPointerException.class)
    public void exceptionCreateTest() {
        FileCash.create(null);
    }

    @Test
    public void readFileTest() {
        try {
            Assert.assertEquals(new String(FileCash.readFile(new File("file.txt"))), "Hello!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataTest() {
        long startLoading = System.currentTimeMillis();
        byte[] data = fileCash.getData();
        long endLoading = System.currentTimeMillis();
        long startGetCash = System.currentTimeMillis();
        byte[] cash = fileCash.getData();
        long endGetCash = System.currentTimeMillis();
        Assert.assertTrue(endLoading - startLoading > endGetCash - startGetCash);
        Assert.assertTrue(data == cash);
    }
}
