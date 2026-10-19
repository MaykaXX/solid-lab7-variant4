package task2;

public interface TaxStrategy {
    TaxBreakdown calculateTaxes(ImportGoods goods);
    String getCategoryName();
}