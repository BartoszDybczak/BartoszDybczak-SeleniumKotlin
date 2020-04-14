package com.automationpractice.myproject.base;

public class TestUtilities extends TestBase {

    protected void sleep(long miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}