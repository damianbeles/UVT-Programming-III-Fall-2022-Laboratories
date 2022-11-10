package streams;

public class ProductException extends Exception {
    public ProductException(String e) {
        super(e);
    }

    public static String INVALID_AMOUNT = "The amount of a product must be positive.";
    public static String INVALID_PRICE = "The price must be positive";
    public static String MISSING_RECOMMENDED_PRICES = "The recommended prices are missing.";
    public static String MISSING_ACTUAL_PRICES = "The actual prices are missing.";
    public static String PRICES_LENGTH_MISMATCH = "The recommended prices and actual prices lengths are not the same";
}