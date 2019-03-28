package au.edu.jcu.cp3406.assignmentageconverter;

public class c_CalculateAge {
    public static float age_cal(int dog_size, int year, int month) {
        float total_months_in_year = 12;
        float months_coverted_into_years = month/total_months_in_year;

        float total_years = year + months_coverted_into_years;


        float age = total_years;
        return age;
    }
}


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
// float dogAge = (float) Float.parseFloat(dogAgeTemp);
//
//    // converting to dog age BigDecimal to enable rounding DOWN
//    BigDecimal dogAge_RoundDownToWholeNumber = new BigDecimal(dogAge);
//
//    // converting to dog age BigDecimal to enable rounding UP
//    BigDecimal dogAge_RoundUpToWholeNumber = new BigDecimal(dogAge);
//
//      rounding DOWN to nearest whole dog age eg 3.46 dog years = 3 years - test ok
//		dogAge_RoundDownToWholeNumber = dogAge_RoundDownToWholeNumber.setScale(0, BigDecimal.ROUND_DOWN);
//
//                            // rounding UP to nearest whole dog age eg 3.46 dog years = 4 years - test ok
//                            dogAge_RoundUpToWholeNumber = dogAge_RoundUpToWholeNumber.setScale(0,BigDecimal.ROUND_UP);
//
//                            // convert rounded DOWN dog age to integer eg 3 dog years test ok
//                            int dogAge_RoundDownToWholeNumber_Int = dogAge_RoundDownToWholeNumber.intValue();
//
//                            // convert to rounded UP dog age to integer eg 4 dog years test ok
//                            int dogAge_RoundUpToWholeNumber_Int = dogAge_RoundUpToWholeNumber.intValue();
//
//                            // calculate the difference between the dog age given less the dog age rounded DOWN
//                            // eg 0.46 dog years = 3.46 dog years - 3 dog years years test ok
//                            float dogAge_remainderDecimal = dogAge-dogAge_RoundDownToWholeNumber_Int;
//
//                            // dog age in human year, ie 0 = 0 through to 16 = 80 eg 3 dog years = 24 years
//                            int smallDogAge[]= {0,15,24,28,32,36,40,44,48,52,56,60,64,68,72,76,80};
//
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
