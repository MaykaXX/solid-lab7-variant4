package task2_OCP;

import java.math.BigDecimal;

public class LuxuryTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.25"));
        BigDecimal exciseTax = goods.getDeclaredValue().multiply(new BigDecimal("0.15"));
        return new TaxBreakdown(importDuty, exciseTax, TaxStrategy.STANDARD_VAT);
    }

    @Override
    public String getCategoryName() { return "LUXURY_GOODS"; }
}