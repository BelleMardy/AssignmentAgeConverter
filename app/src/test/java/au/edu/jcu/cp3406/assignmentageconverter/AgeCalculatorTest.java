package au.edu.jcu.cp3406.assignmentageconverter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeCalculatorTest {

    @Test
    public void age_cal() {

        int dog_size = 1;
        int year = 2;
        int month = 5;

        
        float expected = 0;
        int output = 15.918;

        AgeCalculator age_calculator = new AgeCalculator();
        output = age_calculator.age_cal(dog_size, year, month);


        assertEquals();



        

}
}