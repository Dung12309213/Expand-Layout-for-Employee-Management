package com.duung.utils;

public class HealthCare {
    public static BMIStatus calculate_bmi(double height, double weight) {

        double BMI = weight / Math.pow(height, 2);
        String des = "";
        if (BMI < 18.5) {
            des = "Too Skinny";
        } else if (BMI < 23) {
            des = "Fit";
        } else {
            des = "Fat";
        }
        BMIStatus bmiStatus=new BMIStatus(BMI,des);
        return bmiStatus;
    }

}
