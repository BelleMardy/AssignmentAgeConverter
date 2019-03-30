package au.edu.jcu.cp3406.assignmentageconverter;

public class MonthConverter {


    public static float month_to_year_cal (int month) {

        float dog_year_and_month_to_year = month / 12;

        return dog_year_and_month_to_year;
    }


    public static float year_to_ymonth_cal (float remainder_months_human_age) {

        float human_month_to_dec = remainder_months_human_age * 12;

        return human_month_to_dec;
    }
}