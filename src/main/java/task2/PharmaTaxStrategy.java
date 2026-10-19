package task2;

import java.math.BigDecimal;

public class PharmaTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = BigDecimal.ZERO;
        BigDecimal exciseTax = BigDecimal.ZERO;
        BigDecimal vatRate = new BigDecimal("0.07");
        return new TaxBreakdown(importDuty, exciseTax, vatRate);
    }

    @Override
    public String getCategoryName() { return "PHARMACEUTICALS"; }
}