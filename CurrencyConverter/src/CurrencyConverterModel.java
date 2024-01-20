import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverterModel {

	private HashMap<String, Double> exchangeRates;
	private static final String API_KEY = "20b51ea9686b8b66b20f357b";
	private static final String API_URL = "https://v6.exchangerate-api.com/v6/20b51ea9686b8b66b20f357b/latest/USD";

	public CurrencyConverterModel() {
		exchangeRates = new HashMap<>();
		fetchExchangeRates();
		// Initialize exchange rates or fetch from API
		//printKeys(exchangeRates);

	}

	private void fetchExchangeRates() {
		try {
			// Create a URL object for the API request with the provided API key
			URL url = new URL(API_URL + "?apikey=" + API_KEY);

			// Open a connection to the URL using HttpURLConnection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set up a BufferedReader to read the response from the API
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// StringBuilder to accumulate the JSON response
			StringBuilder response = new StringBuilder();
			String line;

			// Read each line of the response and append it to the StringBuilder
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			// Close the BufferedReader
			reader.close();

			// System.out.println("JSON Response: " + response.toString()); // Testing
			// purposes

			// Parse the JSON response using the org.json library
			JSONObject jsonObject = new JSONObject(response.toString());

			// Check if the key "conversion_rates" exists
			if (jsonObject.has("conversion_rates")) {
				// Get the object under the key "conversion_rates"
				JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");

				// Populate exchangeRates map
				for (String currency : conversionRates.keySet()) {
					exchangeRates.put(currency, conversionRates.getDouble(currency));
				}
			} else {
				System.out.println("Error: 'conversion_rates' key not found in JSON response");
				// Handle the absence of the expected key
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle exception, log error, or provide user feedback
		}
	}

	// Method to convert an amount from one currency to another based on the fetched
	// exchange rates
	public double convert(double amount, String fromCurrency, String toCurrency) {
		// Get the exchange rate for the "fromCurrency"
		double fromRate = exchangeRates.get(fromCurrency);

		// Get the exchange rate for the "toCurrency"
		double toRate = exchangeRates.get(toCurrency);

		// Calculate and return the converted amount
		return amount * (toRate / fromRate);
	}

	// Method for testing purposes
	public Map<String, Double> getExchangeRates() {
		return exchangeRates;
	}

	private static void printKeys(HashMap<String, Double> map) {
		// Get the key set
		Set<String> keySet = map.keySet();

		// Print each key
		System.out.println("Keys:");
		for (String key : keySet) {
			System.out.println(key);
		}
	}
}
