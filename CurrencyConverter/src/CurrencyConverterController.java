import java.util.Map;

public class CurrencyConverterController {

	private CurrencyConverterModel model;
	private CurrencyConverterView view;

	// Constructor that takes a model and initializes the view
	public CurrencyConverterController(CurrencyConverterModel model) {
		this.model = model;
		this.view = new CurrencyConverterView(this); // Pass the controller to the view
	}

	// Method to handle currency conversion based on user input
	public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
		// Delegate the conversion to the model
		return model.convert(amount, fromCurrency, toCurrency);
	}

	// For testing purposes, get exchange rates from the model
	public Map<String, Double> getExchangeRates() {
		return model.getExchangeRates();
	}

	// Entry point to run the application
	public static void main(String[] args) {
		// Create a controller to start the application
		new CurrencyConverterController(new CurrencyConverterModel());
	}
}
