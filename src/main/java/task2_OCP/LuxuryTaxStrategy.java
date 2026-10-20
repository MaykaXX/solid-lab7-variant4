package task2_OCP;

import java.math.BigDecimal;

public class LuxuryTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.25"));
        BigDecimal exciseTax = goods.getDeclaredValue().multiply(new BigDecimal("0.15"));
        BigDecimal vatRate = new BigDecimal("0.20");
        return new TaxBreakdown(importDuty, exciseTax, vatRate);
    }

    @Override
    public String getCategoryName() { return "LUXURY_GOODS"; }
}