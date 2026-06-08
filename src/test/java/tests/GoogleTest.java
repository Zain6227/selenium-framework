package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleTest extends BaseTest {

    @Test(groups = {"parallel"})
    public void openGoogle() {

        driver.get("https://www.google.com");

        System.out.println(
                "Thread Id : "
                + Thread.currentThread().threadId());
    }
}