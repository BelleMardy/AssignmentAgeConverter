package au.edu.jcu.cp3406.assignmentageconverter;

import android.support.v4.app.INotificationSideChannel;
import android.widget.TextView;

class AgeCalculator {

    private int[] human_ages;

    String age_cal(int dog_size, int year, int month) {

        if (dog_size == 0) {

            return 0 + " years";

        } else {

            set_dog_ages(dog_size);

            if (year == 18) {
                return Integer.toString(this.human_ages[18]) + " years";
            }

            return CalculatingHumanAge(year, month);
        }
    }

    private String CalculatingHumanAge(int year, int month) {
        float human_age_diff = human_ages[year + 1] - human_ages[year];
        float month_as_decimal = human_age_diff / 12;
        float dog_age_month = month_as_decimal * month;
        float year_add_month = human_ages[year] + dog_age_month;

        int human_year = (int) year_add_month;

        float decimal_human_month = year_add_month - human_year;

        float human_month = decimal_human_month * 12;

        return checking_years_months(human_year, human_month);

    }

    private String checking_years_months(int human_year, float human_month) {

        if (Math.round(human_month) == 0)  {
            return Integer.toString(human_year) + " years";

        } else if (human_year == 0) {
            return Integer.toString(Math.round(human_month)) + " months";

        } else if (human_year == 1) {
            return Integer.toString(human_year) + " year, " + Integer.toString(Math.round(human_month)) + " months";

        } else if (Math.round(human_month) == 1) {
            return Integer.toString(human_year) + " years, " + Integer.toString(Math.round(human_month)) + " month";

        } else {
            return Integer.toString(human_year) + " years, " + Integer.toString(Math.round(human_month)) + " months";

        }
    }

    private void set_dog_ages(int dog_size) {
        if (dog_size == 1) {
            this.human_ages = new int[]{0, 7, 13, 20, 26, 35, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84, 88};
        } else if (dog_size == 2) {
            this.human_ages = new int[]{0, 7, 14, 21, 27, 34, 42, 47, 51, 56, 60, 65, 69, 74, 78, 83, 87, 92, 96};
        } else if (dog_size == 3) {
            this.human_ages = new int[]{0, 8, 16, 24, 31, 38, 45, 50, 55, 61, 66, 72, 77, 82, 88, 93, 99, 104, 115};
        } else {
            this.human_ages = new int[]{0, 9, 18, 26, 34, 41, 49, 56, 64, 71, 78, 86, 93, 101, 108, 115, 123, 131, 139};
        }
    }
}
