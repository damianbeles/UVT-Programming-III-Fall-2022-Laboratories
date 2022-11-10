package streams;

import java.util.List;
import java.util.Map;

public class Product {
    int amount;
    double currentPrice;
    Map<String, List<Double>> previousPrices;
    String name;

    public Product(int amount, double currentPrice, Map<String, List<Double>> previousPrices, String name)
            throws ProductException {
        if (amount < 0) {
            throw new ProductException(ProductException.INVALID_AMOUNT);
        }
        if (currentPrice < 0) {
            throw new ProductException(ProductException.INVALID_PRICE);
        }
        if (!previousPrices.containsKey("recommendedPrices")) {
            throw new ProductException(ProductException.MISSING_RECOMMENDED_PRICES);
        }
        if (!previousPrices.containsKey("actualPrices")) {
            throw new ProductException(ProductException.MISSING_ACTUAL_PRICES);
        }
        if (previousPrices.get("recommendedPrices").size() != previousPrices.get("actualPrices").size()) {
            throw new ProductException(ProductException.PRICES_LENGTH_MISMATCH);
        }
        boolean previousPricesArePositive = previousPrices.values().stream().flatMap(priceList -> priceList.stream())
                .allMatch(price -> price >= 0);
        if (!previousPricesArePositive) {
            throw new ProductException(ProductException.INVALID_PRICE);
        }

        this.amount = amount;
        this.currentPrice = currentPrice;
        this.previousPrices = previousPrices;
        this.name = name;
    }

    public int getPreviousPricesLength() {
        return this.previousPrices.get("actualPrices").size();
    }

    public boolean isProductBelowAveragePrice() {
        double averagePriceOverTime = this.previousPrices.get("actualPrices").stream().mapToDouble(price -> price)
                .average().getAsDouble();
        return this.currentPrice < averagePriceOverTime;
    }

    @Override
    public String toString() {
        return "Product [amount=" + amount + ", currentPrice=" + currentPrice + ", previousPrices=" + previousPrices
                + ", name=" + name + "]";
    }
}