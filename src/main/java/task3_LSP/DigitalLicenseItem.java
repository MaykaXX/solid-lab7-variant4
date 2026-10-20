package task3_LSP;

import java.math.BigDecimal;
import java.util.Objects;

public class DigitalLicenseItem extends Item {
    private final String licenseKeyPattern;

    public DigitalLicenseItem(String sku, String title, BigDecimal unitPrice, String licenseKeyPattern) {
        super(sku, title, unitPrice);
        this.licenseKeyPattern = Objects.requireNonNull(licenseKeyPattern, "Шаблон ліцензійного ключа обов'язковий");
    }

    public String getLicenseKeyPattern() {
        return licenseKeyPattern;
    }
}