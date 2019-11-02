package com.example.personalhealthrecord;

public class AddTestResult {

    private String testName, daysDone, normalRange, yourValues;

    public AddTestResult(String testName, String daysDone, String normalRange, String yourValues) {
        this.testName = testName;
        this.daysDone = daysDone;
        this.normalRange = normalRange;
        this.yourValues = yourValues;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDaysDone() {
        return daysDone;
    }

    public void setDaysDone(String daysDone) {
        this.daysDone = daysDone;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getYourValues() {
        return yourValues;
    }

    public void setYourValues(String yourValues) {
        this.yourValues = yourValues;
    }
}
