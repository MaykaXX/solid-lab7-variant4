package task2;

import java.math.BigDecimal;

public record TaxBreakdown(BigDecimal importDuty, BigDecimal exciseTax, BigDecimal vatRate) {}