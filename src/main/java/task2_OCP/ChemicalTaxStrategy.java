package task2_OCP;

import java.math.BigDecimal;

// Новий тип: Хімічна продукція (мито 8%, акциз 5%, ПДВ 20%)
public class ChemicalTaxStrategy implements TaxStrategy {
    @Override
    public TaxBreakdown calculateTaxes(ImportGoods goods) {
        BigDecimal importDuty = goods.getDeclaredValue().multiply(new BigDecimal("0.08"));
        BigDecimal exciseTax = goods.getDeclaredValue().multiply(new BigDecimal("0.05"));
        return new TaxBreakdown(importDuty, exciseTax, TaxStrategy.STANDARD_VAT);
    }

    @Override
    public String getCategoryName() { return "CHEMICALS"; }
}