package au.edu.jcu.cp3406.assignmentageconverter;

import java.math.BigDecimal;

public class c_CalculateAge {


    public static float age_cal(int dog_size, int year, int month) {
        float total_months_in_year = 12;
        float months_coverted_into_years = month/total_months_in_year;
        float dogAge = year + months_coverted_into_years;
        float small_dogSize = dog_size;
        float dogAge_small_1 = 7;
        float dogAge_small_2 = 13;
        float dogAge_small_3 = 20;
        float dogAge_small_4 = 26;
        float dogAge_small_5 = 35;
        float dogAge_small_6 = 40;
        float dogAge_small_7 = 44;
        float dogAge_small_8 = 48;
        float dogAge_small_9 = 52;
        float dogAge_small_10 = 56;
        float dogAge_small_11 = 60;
        float dogAge_small_12 = 64;
        float dogAge_small_13 = 68;
        float dogAge_small_14 = 72;
        float dogAge_small_15 = 76;
        float dogAge_small_16 = 80;
        float dogAge_small_17 = 84;
        float dogAge_small_18 = 88;

        float medium_dogSize = dog_size;
        float dogAge_medium_1 = 7;
        float dogAge_medium_2 = 14;
        float dogAge_medium_3 = 21;
        float dogAge_medium_4 = 27;
        float dogAge_medium_5 = 36;
        float dogAge_medium_6 = 42;
        float dogAge_medium_7 = 47;
        float dogAge_medium_8 = 51;
        float dogAge_medium_9 = 56;
        float dogAge_medium_10 = 60;
        float dogAge_medium_11 = 65;
        float dogAge_medium_12 = 69;
        float dogAge_medium_13 = 74;
        float dogAge_medium_14 = 78;
        float dogAge_medium_15 = 83;
        float dogAge_medium_16 = 87;
        float dogAge_medium_17 = 92;
        float dogAge_medium_18 = 96;

        float large_dogSize = dog_size;
        float dogAge_large_1 = 8;
        float dogAge_large_2 = 16;
        float dogAge_large_3 = 24;
        float dogAge_large_4 = 31;
        float dogAge_large_5 = 38;
        float dogAge_large_6 = 45;
        float dogAge_large_7 = 50;
        float dogAge_large_8 = 55;
        float dogAge_large_9 = 61;
        float dogAge_large_10 = 66;
        float dogAge_large_11 = 72;
        float dogAge_large_12 = 77;
        float dogAge_large_13 = 82;
        float dogAge_large_14 = 88;
        float dogAge_large_15 = 93;
        float dogAge_large_16 = 99;
        float dogAge_large_17 = 104;
        float dogAge_large_18 = 115;

        float xlarge_dogSize = dog_size;
        float dogAge_xlarge_1 = 9;
        float dogAge_xlarge_2 = 18;
        float dogAge_xlarge_3 = 26;
        float dogAge_xlarge_4 = 34;
        float dogAge_xlarge_5 = 41;
        float dogAge_xlarge_6 = 49;
        float dogAge_xlarge_7 = 56;
        float dogAge_xlarge_8 = 64;
        float dogAge_xlarge_9 = 71;
        float dogAge_xlarge_10 = 78;
        float dogAge_xlarge_11 = 86;
        float dogAge_xlarge_12 = 93;
        float dogAge_xlarge_13 = 101;
        float dogAge_xlarge_14 = 108;
        float dogAge_xlarge_15 = 115;
        float dogAge_xlarge_16 = 123;
        float dogAge_xlarge_17 = 131;
        float dogAge_xlarge_18 = 139;






        // converting to dog age BigDecimal to enable rounding DOWN
        BigDecimal dogAge_RoundDownToWholeNumber = new BigDecimal(dogAge);

        // converting to dog age BigDecimal to enable rounding DOWN - 3 years 5 months
        BigDecimal age = dogAge_RoundDownToWholeNumber;

        // converting to dog age BigDecimal to enable rounding UP
        BigDecimal dogAge_RoundUpToWholeNumber = new BigDecimal(dogAge);

        //rounding DOWN to nearest whole dog age eg 3.42 dog years = 3 years - test ok
        dogAge_RoundDownToWholeNumber = dogAge_RoundDownToWholeNumber.setScale(0, BigDecimal.ROUND_DOWN);

        // rounding UP to nearest whole dog age eg 3.46 dog years = 4 years - test ok
        dogAge_RoundUpToWholeNumber = dogAge_RoundUpToWholeNumber.setScale(0,BigDecimal.ROUND_UP);


        //convert rounded DOWN dog age to integer eg 3 dog years test ok
        int dogAge_RoundDownToWholeNumber_Int = dogAge_RoundDownToWholeNumber.intValue();

        // convert to rounded UP dog age to integer eg 4 dog years test ok
        int dogAge_RoundUpToWholeNumber_Int = dogAge_RoundUpToWholeNumber.intValue();

        /**calculate the difference between the dog age given less the dog age rounded DOWN
         eg 0.46 dog years = 3.46 dog years - 3 dog years years test ok*/
        float dogAge_remainderDecimal = dogAge-dogAge_RoundDownToWholeNumber_Int;

        // dog age in human year, ie 0 = 0 through to 18 = 20 eg 3 dog years = 24 years
        int [] small_dog = {0,7,13,20,26,35,40,44,48,52,56,60,64,68,72,76,80,84,88};

        /** the difference between rounded UP dog age converted to human less rounded DOWN dog age converted to human years
        4 human years = 4 dog years (28 human years) - 3 dog years (24 human years) test ok*/


        return dogAge_remainderDecimal;
    }
}

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
