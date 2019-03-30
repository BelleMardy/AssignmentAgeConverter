package au.edu.jcu.cp3406.assignmentageconverter;

import java.math.BigDecimal;

public class c_CalculateAge {


    public static String age_cal(int dog_size, int year, int month) {
        float new_month = convert_to_year.month_to_year_cal(month);
        float dogAge = year + new_month;


        float lower_year = 0;
        float upper_year = 0;
        if (dog_size == 0) {
            String nil_result = "FU";
            return nil_result;

        } else if(dog_size == 1){
            float [] small_dog = {0,7,13,20,26,35,40,44,48,52,56,60,64,68,72,76,80,84,88};
            if (year == 18){
                return Float.toString(small_dog[18]);
            }
            lower_year = small_dog[year];
            upper_year = small_dog[year + 1];

        } else if(dog_size == 2){

            float [] medium_dog = {0,7,14,21,27,34	,42	,47	,51	,56	,60	,65	,69	,74	,78	,83	,87	,92	,96};
            if (year == 18){
                return Float.toString(medium_dog[18]);
            }
            lower_year = medium_dog[year];
            upper_year = medium_dog[year + 1];

        } else if(dog_size == 3){
            float [] large_dog = {0,8,16,24,31,38,45,50,55,61,66,72,77,82,88,93,99,104,115};
            if (year == 18){
                return Float.toString(large_dog[18]);
            }
            lower_year = large_dog [year];
            upper_year = large_dog[year + 1];

        } else if(dog_size == 4) {
            float[] xlarge = {0, 9, 18, 26, 34, 41, 49, 56, 64, 71, 78, 86, 93, 101, 108, 115, 123, 131, 139};
            if (year == 18) {
                return Float.toString(xlarge[18]);
            }
            lower_year = xlarge[year];
            upper_year = xlarge[year + 1];
        }

        float human_age_diff = upper_year - lower_year;

        float human_age_months = human_age_diff * new_month;

        float total_human_years = lower_year + human_age_months;

        int total_human_year_whole_year = (int) total_human_years;

        float remainder_months_human_age = total_human_years - total_human_year_whole_year;

        int human_months = (int) convert_to_year.year_to_ymonth_cal(remainder_months_human_age);

        String string_result = Integer.toString(total_human_year_whole_year);
        string_result = string_result + "years " + Integer.toString(human_months) + " months";
        return string_result ;
    }}



//while (small_dogSize != 0) {
//        if (small_dogSize == 1) {
//        if
//        }
//        }

// float dogAge = (float) Float.parseFloat(dogAgeTemp);


//                            // the difference between rounded UP dog age converted to human less rounded DOWN dog age converted to human years
//                            // 4 human years = 4 dog years (28 human years) - 3 dog years (24 human years) test ok
//                            float dogAge_HumanDiff = smallDogAge[dogAge_RoundUpToWholeNumber_Int]-smallDogAge[dogAge_RoundDownToWholeNumber_Int];
//
//
//                            // the remainder of dog years (months) converted to human years
//                            // eg 1.84 human years = 4 human years * 0.46 dog years
//                            float dogAge_RemainderConvertedToHumanYears = dogAge_HumanDiff * dogAge_remainderDecimal;
//
//                            // converting the remainder of human year BigDecimal to enable rounding DOWN to whole human years eg 1.84 human years
//                            BigDecimal dogAge_RemainderConvertedToHumanYears_bd = new BigDecimal(dogAge_RemainderConvertedToHumanYears);
//
//                            // rounding DOWN to nearest whole human age eg 1 human year
//                            dogAge_RemainderConvertedToHumanYears_bd = dogAge_RemainderConvertedToHumanYears_bd.setScale(0, BigDecimal.ROUND_DOWN);
//
//                            // convert rounded DOWN human age to integer eg 1 human year
//                            int dogAge_RemainderConvertedToHumanYears_bd_Int = dogAge_RemainderConvertedToHumanYears_bd.intValue();
//
//                            // the remainder of human years ie after whole human years removed the part year
//                            // eg 29 years = 28 human years + 1 human year
//                            int total_human_years = smallDogAge[dogAge_RoundDownToWholeNumber_Int] + dogAge_RemainderConvertedToHumanYears_bd_Int;
//
//                            //	calculate the human months based on the converted remainder of dog years to human years ie 0.84 human years
//                            //  10 months = (1.84 human years - 1 human year) * 12 months
//                            int human_months = (int) ((dogAge_RemainderConvertedToHumanYears - dogAge_RemainderConvertedToHumanYears_bd_Int) * 12);
//
//
//
//                            System.out.print("92. The human age for " + dogName + " is " + total_human_years + " years and "
//                            + human_months + " months");


// working code
// ---------------------------------------------------------------
// package au.edu.jcu.cp3406.assignmentageconverter;
//
//public class c_CalculateAge {
//    public static int age_cal(int dog_size, int year, int month) {
//
//
//
//        int age = dog_size + year + month;
//        return age;
//    }
// }
//
// ---------------------------------------------------------------
//
