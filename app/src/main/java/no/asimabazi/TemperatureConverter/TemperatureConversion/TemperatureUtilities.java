package no.asimabazi.TemperatureConverter.TemperatureConversion;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureUtilities {
    public static final double CTOF_RATIO = 9/5d;
    public static final double FTOC_RATIO = 5/9d;
    public static final int SIGNIFICANT_DIGIT = 1;

    public static String round(double val, int sigdig){
        if(sigdig < 0) throw new IllegalStateException();

        BigDecimal bd = new BigDecimal((Double.toString(val)));
        bd = bd.setScale(sigdig, RoundingMode.HALF_UP);

        return bd.toString();
    }

}
