package task2_OCP;

import java.math.BigDecimal;

public class PharmaTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = BigDecimal.ZERO;
        BigDecimal exciseTax = BigDecimal.ZERO;
        return new TaxBreakdown(importDuty, exciseTax, TaxStrategy.REDUCED_VAT);
    }

    @Override
    public String getCategoryName() { return "PHARMACEUTICALS"; }
}