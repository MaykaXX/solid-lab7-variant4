package task2_OCP;

import java.math.BigDecimal;

public record TaxBreakdown(BigDecimal importDuty, BigDecimal exciseTax, BigDecimal vatRate) {}