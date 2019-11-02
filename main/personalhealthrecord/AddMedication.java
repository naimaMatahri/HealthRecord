package com.example.personalhealthrecord;

public class AddMedication {

    private String medicationName, daysSupply, dose, dateDispensed;

    public AddMedication(String medicationName, String daysSupply, String dose, String dateDispensed) {
        this.medicationName = medicationName;
        this.daysSupply = daysSupply;
        this.dose = dose;
        this.dateDispensed = dateDispensed;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDaysSupply() {
        return daysSupply;
    }

    public void setDaysSupply(String daysSupply) {
        this.daysSupply = daysSupply;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDateDispensed() {
        return dateDispensed;
    }

    public void setDateDispensed(String dateDispensed) {
        this.dateDispensed = dateDispensed;
    }
}


