package au.edu.jcu.cp3406.assignmentageconverter;

import org.junit.Test;

import static org.junit.Assert.*;


// Test string output of age calculator
public class AgeCalculatorTest {

    @Test

    public void test_age_cal() {

        int dog_size = 1;
        int year = 2;
        int month = 5;

        String output;

        MainAgeCalculator age_calculator = new MainAgeCalculator();
        output = age_calculator.age_cal(dog_size, year, month);
        System.out.println(output);

        assertEquals("15 years\n11 months", output);
    }
}