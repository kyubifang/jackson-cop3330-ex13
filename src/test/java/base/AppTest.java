package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_principal_rate_times_years_and_investment() {
        App myApp = new App();
        int prince = 1500;
        double rate = 4.3;
        double percent = (rate / 100);
        int years = 6;
        int times = 4;
        double amount1 = 1 + (percent / times);
        double amount2 = Math.pow(amount1, (years * times));
        double amount3 = prince * amount2;
        double calc = Math.round(amount3 * 100.0) / 100.0;
        String invest = Double.toString(calc);
        if(calc % 1 == 0) {
            invest = String.format("%.0f", calc);
        }
        String expectedOutput = "$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.";
        String actualOutput = myApp.generateOutputString(prince, rate, times, years, invest);

        assertEquals(expectedOutput, actualOutput);
    }
}