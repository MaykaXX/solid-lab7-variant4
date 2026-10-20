package task3_LSP;

import java.math.BigDecimal;

public class PhysicalInventoryItem extends Item {
    private int stockQuantity;

    public PhysicalInventoryItem(String sku, String title, int stockQuantity, BigDecimal unitPrice) {
        super(sku, title, unitPrice);
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Початкова кількість не може бути від'ємною");
        }
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() { return stockQuantity; }

    public void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Кількість для поповнення має бути більшою за 0");
        }
        this.stockQuantity += amount;
        System.out.println("Поповнено " + amount + " шт. для " + getTitle() + ". Залишок: " + stockQuantity);
    }

    public void returnToSupplier(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Кількість для повернення має бути більшою за 0");
        }
        if (amount > stockQuantity) {
            throw new IllegalStateException("Неможливо повернути більше, ніж є на складі (наявно: " + stockQuantity + ")");
        }
        this.stockQuantity -= amount;
        System.out.println("Повернено постачальнику " + amount + " шт. товару " + getTitle() + ". Залишок: " + stockQuantity);
    }
}