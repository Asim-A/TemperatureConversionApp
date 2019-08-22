package no.asimabazi.TemperatureConverter.TemperatureConversion;

public class FTOC implements TemperatureConversion{
    @Override
    public String convert(Double temp) {
        Double res = (temp - 32 ) * TemperatureUtilities.FTOC_RATIO;
        return TemperatureUtilities.round(res, TemperatureUtilities.SIGNIFICANT_DIGIT);
    }
}
