package no.asimabazi.TemperatureConverter.TemperatureConversion;

public class CTOF implements TemperatureConversion{
    @Override
    public String convert(Double temp) {
        Double res = ((temp * TemperatureUtilities.CTOF_RATIO) + 32);
        return TemperatureUtilities.round(res, TemperatureUtilities.SIGNIFICANT_DIGIT);
    }
}
