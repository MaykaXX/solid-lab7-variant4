package task2_OCP;

public interface TaxStrategy {
    TaxBreakdown calculateTaxes(ImportGoods goods);
    String getCategoryName();
}