package task2;

import java.math.BigDecimal;

public class ImportGoods {
    private final String goodsCode;
    private final String name;
    private final BigDecimal declaredValue;
    private final BigDecimal weightKg;

    public ImportGoods(String goodsCode, String name, BigDecimal declaredValue, BigDecimal weightKg) {
        this.goodsCode = goodsCode;
        this.name = name;
        this.declaredValue = declaredValue;
        this.weightKg = weightKg;
    }

    public String getGoodsCode() { return goodsCode; }
    public String getName() { return name; }
    public BigDecimal getDeclaredValue() { return declaredValue; }
    public BigDecimal getWeightKg() { return weightKg; }
}