import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterView extends JFrame {

	private CurrencyConverterController controller;

	// GUI components
	private JTextField amountField;
	private JComboBox<String> fromCurrencyComboBox;
	private JComboBox<String> toCurrencyComboBox;
	private JButton convertButton;
	private JLabel resultLabel;

	// Constructor
	public CurrencyConverterView(CurrencyConverterController controller) {
		this.controller = controller;

		// Set up JFrame properties
		setTitle("Currency Converter");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize and layout GUI components
		initComponents();
		layoutComponents();

		// Make the frame visible
		setVisible(true);
	}

	// Initialize GUI components
	private void initComponents() {
		amountField = new JTextField(10);
		fromCurrencyComboBox = new JComboBox<>(new String[] {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"}
); // Add
																													// more
																													// currencies
																													// as
																													// needed
		toCurrencyComboBox = new JComboBox<>(new String[] {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"}
); // Add more currencies
																									// as needed

		convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				convertCurrency();
			}
		});

		resultLabel = new JLabel("Converted amount:");
	}

	// Layout GUI components
	private void layoutComponents() {
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel(new GridLayout(3, 2));
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		topPanel.add(new JLabel("Amount:"));
		topPanel.add(amountField);

		topPanel.add(new JLabel("From Currency:"));
		topPanel.add(fromCurrencyComboBox);

		topPanel.add(new JLabel("To Currency:"));
		topPanel.add(toCurrencyComboBox);

		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(convertButton);

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(resultLabel);

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	// Perform currency conversion when the "Convert" button is clicked
	private void convertCurrency() {
		try {
			double amount = Double.parseDouble(amountField.getText());
			String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
			String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

			// Call the controller to perform the currency conversion
			double convertedAmount = controller.convertCurrency(amount, fromCurrency, toCurrency);

			// Update the result label with the converted amount
			resultLabel.setText("<html><font color='green'>Converted amount:</font> " + convertedAmount + " "
					+ toCurrency + "</html>");
		} catch (NumberFormatException ex) {
			resultLabel.setText("<html><font color='red'>Error: Enter a valid number.</font></html>");
		}
	}

	// Main method to launch the GUI
	public static void main(String[] args) {
		// Run the GUI on the event dispatch thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Pass an instance of your updated CurrencyConverterModel to the controller
				new CurrencyConverterView(new CurrencyConverterController(new CurrencyConverterModel()));
			}
		});
	}
}
