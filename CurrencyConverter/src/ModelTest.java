
public class ModelTest {

	public static void main(String[] args) {
		// Create an instance of CurrencyConverterModel
		CurrencyConverterModel model = new CurrencyConverterModel();

		// Print the exchange rates (for testing purposes)
		System.out.println("Exchange Rates:");
		model.getExchangeRates().forEach((currency, rate) -> System.out.println(currency + ": " + rate));

		// Test currency conversion
		double amountToConvert = 100.0;
		String fromCurrency = "CAD";
		String toCurrency = "AED";

		double convertedAmount = model.convert(amountToConvert, fromCurrency, toCurrency);

		// Print the result of the currency conversion
		System.out.println("\nCurrency Conversion Test:");
		System.out.println(amountToConvert + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
	}
}
