package org.example.Tasks.Fabric;

public class Formatter {
    private String style;
    private static final String CURRENCY = "currency";
    private static final String PERCENT = "percent";
    private static Formatter currencyFormatter;
    private static Formatter percentInstance;

    private Formatter(String style) {
        this.style = style;
    }

    public static Formatter getCurrencyInstance() {
        if (currencyFormatter == null)
            currencyFormatter = new Formatter(CURRENCY);
        return currencyFormatter;
    }

    public static Formatter getPercentInstance() {
        if (percentInstance == null)
            percentInstance = new Formatter(PERCENT);
        return percentInstance;
    }

    public String format(double value) {
        return switch (style) {
            case CURRENCY -> String.format("$%.2f", value); // Форматируем как валюту
            case PERCENT -> String.format("%.0f%%", value * 100); // Форматируем как проценты
            default -> throw new IllegalStateException("Неизвестный стиль форматирования: " + style);
        };
    }
}
