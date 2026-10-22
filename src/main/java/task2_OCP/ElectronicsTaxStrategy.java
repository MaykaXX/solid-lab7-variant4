package task2_OCP;

import java.math.BigDecimal;

public class ElectronicsTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.05"));
        BigDecimal exciseTax = BigDecimal.ZERO;
        //ДО: BigDecimal vatRate = new BigDecimal("0.20");
        //ПІСЛЯ
        return new TaxBreakdown(importDuty, exciseTax, TaxStrategy.STANDARD_VAT);
    }

    @Override
    public String getCategoryName() { return "ELECTRONICS"; }
}