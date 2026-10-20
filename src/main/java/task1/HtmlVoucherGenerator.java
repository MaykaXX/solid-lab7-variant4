package task1;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class HtmlVoucherGenerator {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String generateHtml(BookingRequest request, BigDecimal grandTotal) {
        long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
        String extraServicesStr = (request.getExtraServices() != null && !request.getExtraServices().isEmpty())
                ? String.join(", ", request.getExtraServices())
                : "Немає";

        return String.format("<html><body>" +
                        "<h2>Ваучер Бронювання №%s</h2>" +
                        "<p><b>Гість:</b> %s</p>" +
                        "<p><b>Тип номера:</b> %s</p>" +
                        "<p><b>Заїзд:</b> %s | <b>Виїзд:</b> %s (%d ночей)</p>" +
                        "<p><b>Додаткові послуги:</b> %s</p>" +
                        "<h3>Загальна вартість: %.2f грн</h3>" +
                        "</body></html>",
                UUID.randomUUID().toString().substring(0, 8),
                request.getGuestName(),
                request.getRoomType(),
                request.getCheckInDate().format(formatter),
                request.getCheckOutDate().format(formatter),
                nights,
                extraServicesStr,
                grandTotal
        );
    }
}