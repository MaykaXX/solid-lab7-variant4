package task2_OCP;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public BigDecimal calculateTotalTax(ImportGoods goods, TaxStrategy strategy) {
        TaxBreakdown breakdown = strategy.calculateTaxes(goods);

        BigDecimal taxableAmount = goods.getDeclaredValue()
                .add(breakdown.importDuty())
                .add(breakdown.exciseTax());
        BigDecimal vatAmount = taxableAmount.multiply(breakdown.vatRate());
        BigDecimal totalTax = breakdown.importDuty()
                .add(breakdown.exciseTax())
                .add(vatAmount)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("[TAX] Товар '" + goods.getName() + "' (" + strategy.getCategoryName() +
                "): Мито=$" + breakdown.importDuty() +
                ", Акциз=$" + breakdown.exciseTax() +
                ", ПДВ=$" + vatAmount.setScale(2, RoundingMode.HALF_UP) +
                " | Всього до сплати: $" + totalTax);

        return totalTax;
    }
}