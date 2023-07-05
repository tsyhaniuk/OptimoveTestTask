package com.optimove;

import com.optimove.pages.CareersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OptimoveCareersTest extends BaseTest {

    private final static String BASE_URL = "https://www.optimove.com";
    private final static String ENDPOINT = "/careers";

    @Test
    public void testAQAEngineerPositionIsAvailable() {
        CareersPage careersPage = new CareersPage(BASE_URL + ENDPOINT);
        careersPage.filterByOfficeUKR();
        Assert.assertTrue(careersPage.verifyThereIsOpenPositionAQA());
    }
}
