package task2;

import java.math.BigDecimal;

public class FoodTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.10"))
                .add(goods.getWeightKg().multiply(new BigDecimal("0.50")));
        BigDecimal exciseTax = BigDecimal.ZERO;
        BigDecimal vatRate = new BigDecimal("0.07");
        return new TaxBreakdown(importDuty, exciseTax, vatRate);
    }

    @Override
    public String getCategoryName() { return "FOOD"; }
}