package task3;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Item {
    private final String sku;
    private final String title;
    private final BigDecimal unitPrice;

    public Item(String sku, String title, BigDecimal unitPrice) {
        this.sku = Objects.requireNonNull(sku, "SKU не може бути null");
        this.title = Objects.requireNonNull(title, "Назва не може бути null");
        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Ціна повинна бути невід'ємною");
        }
        this.unitPrice = unitPrice;
    }

    public String getSku() { return sku; }
    public String getTitle() { return title; }
    public BigDecimal getUnitPrice() { return unitPrice; }
}