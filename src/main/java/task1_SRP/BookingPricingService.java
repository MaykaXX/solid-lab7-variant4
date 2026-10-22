package task1_SRP;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class BookingPricingService {

    //---ДОДАНО після перевірки
    private static final Map<String, BigDecimal> DAILY_SERVICES = Map.of(
            "BREAKFAST", new BigDecimal("300")
    );

    private static final Map<String, BigDecimal> ONE_TIME_SERVICES = Map.of(
            "SPA", new BigDecimal("800"),
            "TRANSFER", new BigDecimal("500")
    );
    //------------

    public BigDecimal calculateTotal(BookingRequest request) {
        //До перевірки
        //long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());

        //ПІсля
        long nights = request.getNights();

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

        //ДО
//        if (request.getExtraServices() != null) {
//            for (String service : request.getExtraServices()) {
//                if ("Breakfast".equalsIgnoreCase(service)) {
//                    extrasTotal = extrasTotal.add(new BigDecimal("300").multiply(BigDecimal.valueOf(nights)));
//                } else if ("Spa".equalsIgnoreCase(service)) {
//                    extrasTotal = extrasTotal.add(new BigDecimal("800"));
//                } else if ("Transfer".equalsIgnoreCase(service)) {
//                    extrasTotal = extrasTotal.add(new BigDecimal("500"));
//                }
//            }
//        }

        //ПІСЛЯ
        if (request.getExtraServices() != null) {
            for (String rawService : request.getExtraServices()) {
                String serviceKey = rawService.toUpperCase();
                if (DAILY_SERVICES.containsKey(serviceKey)) {
                    extrasTotal = extrasTotal.add(DAILY_SERVICES.get(serviceKey).multiply(BigDecimal.valueOf(nights)));
                } else if (ONE_TIME_SERVICES.containsKey(serviceKey)) {
                    extrasTotal = extrasTotal.add(ONE_TIME_SERVICES.get(serviceKey));
                }
            }
        }
        // ---------------
        
        BigDecimal grandTotal = roomTotal.add(extrasTotal);
        if (request.isLoyaltyMember()) {
            grandTotal = grandTotal.multiply(new BigDecimal("0.90"));
        }

        return grandTotal;
    }
}