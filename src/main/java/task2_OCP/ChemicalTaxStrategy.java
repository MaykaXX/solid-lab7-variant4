package task2_OCP;

import java.math.BigDecimal;

// Новий тип: Хімічна продукція (мито 8%, акциз 5%, ПДВ 20%)
public class ChemicalTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.08"));
        BigDecimal exciseTax = goods.getDeclaredValue().multiply(new BigDecimal("0.05"));
        BigDecimal vatRate = new BigDecimal("0.20");
        return new TaxBreakdown(importDuty, exciseTax, vatRate);
    }

    @Override
    public String getCategoryName() { return "CHEMICALS"; }
}