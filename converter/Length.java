package converter;

/**
 * enum of Length unit for Converter App
 * @author theetouchkasemarnontana
 * 
 */
public enum Length {
	Centimeter(0.1), Meter(1.0), Kilometer(1000.0), Mile(1609.344), Foot(0.30480), WA(2.0), Lightyear(9.460730777119564E+15);

	private double amount;

	private Length(double amount) {
		this.amount = amount;
	}

	/**
	 * convert a quanity one Length unit to Meter Length unit
	 * @param amount of lenght in the unit
	 * @param fromUnit the unit
	 * @return amount of length in Meter
	 */
	public double convert(double amount, Length fromUnit) {
		return amount*fromUnit.amount;
	}
	
	/**
	 * convert a quanity one Length unit to another Length unit
	 * @param amount of lenght in the unit
	 * @param fromUnit the unit
	 * @return amount of length in another Length unit
	 */
	public double convertTo(double amount, Length toUnit) {
		return amount/toUnit.amount;
	}
}