package com.optimove.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class CareersPage {
    private final SelenideElement officeDropdownLocation = $x("//span[contains(@class, 'select-dropdown__label') and contains(text(), 'Offices')]");

    private final SelenideElement officeDropdownButton = $x("//div[@class='select select--job-locations']");
    private final SelenideElement officeDropdown = $x("//div[@class='select select--job-locations']//select");

    public CareersPage(String url){
        Selenide.open(url);
    }
    public void filterByOfficeUKR() {
        officeDropdownLocation.scrollIntoView("{block: 'center'}");
        officeDropdownButton.click();
        officeDropdown.selectOptionContainingText("UKR");
    }
    public boolean verifyThereIsOpenPositionAQA(){
        ElementsCollection elements = $$(".job-card__title");
        List<String> textList = elements.stream()
                .map(element -> element.getText())
                .filter(s -> s.contains("QA Automation Engineer"))
                .collect(Collectors.toList());
        if (textList.size() > 0) return true;
        else return false;
        }

}