package task1_SRP;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class SmsNotificationService {
    public void sendBookingConfirmation(BookingRequest request, BigDecimal grandTotal) {
        try {
            //ДО: long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
            //ПІсля
            long nights = request.getNights();

            String message = String.format("Шановний(а) %s, ваше бронювання %s на %d ночей зафіксовано. Сума: %.2f грн.",
                    request.getGuestName(), request.getRoomType(), nights, grandTotal);
            System.out.println("Надсилання меседжу на номер " + request.getGuestPhone() + " через http://viber-gateway.local/send");
            System.out.println("Текст: " + message);
        } catch (Exception ex) {
            System.out.println("Помилка відправки меседжу гостю: " + ex.getMessage());
        }
    }
}