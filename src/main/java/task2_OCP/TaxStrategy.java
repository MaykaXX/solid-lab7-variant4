package task2_OCP;

import java.math.BigDecimal;

public interface TaxStrategy {
    //ПІсля
    BigDecimal STANDARD_VAT = new BigDecimal("0.20");
    BigDecimal REDUCED_VAT = new BigDecimal("0.07");
    //-----

    TaxBreakdown calculateTaxes(ImportGoods goods);
    String getCategoryName();
}