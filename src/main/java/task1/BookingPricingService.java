package task1;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class BookingPricingService {

    public BigDecimal calculateTotal(BookingRequest request) {
        long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());

        BigDecimal basePricePerNight = switch (request.getRoomType().toUpperCase()) {
            case "STANDARD" -> new BigDecimal("1200");
            case "DELUXE" -> new BigDecimal("2500");
            case "SUITE" -> new BigDecimal("4500");
            default -> throw new IllegalArgumentException("Невідома категорія номера: " + request.getRoomType());
        };

        int checkInMonth = request.getCheckInDate().getMonthValue();
        if (checkInMonth >= 6 && checkInMonth <= 8) {
            basePricePerNight = basePricePerNight.multiply(new BigDecimal("1.3"));
        }

        BigDecimal roomTotal = basePricePerNight.multiply(BigDecimal.valueOf(nights));
        BigDecimal extrasTotal = BigDecimal.ZERO;

        if (request.getExtraServices() != null) {
            for (String service : request.getExtraServices()) {
                if ("Breakfast".equalsIgnoreCase(service)) {
                    extrasTotal = extrasTotal.add(new BigDecimal("300").multiply(BigDecimal.valueOf(nights)));
                } else if ("Spa".equalsIgnoreCase(service)) {
                    extrasTotal = extrasTotal.add(new BigDecimal("800"));
                } else if ("Transfer".equalsIgnoreCase(service)) {
                    extrasTotal = extrasTotal.add(new BigDecimal("500"));
                }
            }
        }

        BigDecimal grandTotal = roomTotal.add(extrasTotal);
        if (request.isLoyaltyMember()) {
            grandTotal = grandTotal.multiply(new BigDecimal("0.90"));
        }

        return grandTotal;
    }
}