package task2_OCP;

import java.math.BigDecimal;

public class FoodTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.10"))
                .add(goods.getWeightKg().multiply(new BigDecimal("0.50")));
        BigDecimal exciseTax = BigDecimal.ZERO;
        return new TaxBreakdown(importDuty, exciseTax, TaxStrategy.REDUCED_VAT);
    }

    @Override
    public String getCategoryName() { return "FOOD"; }
}