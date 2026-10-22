package task1_SRP;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BookingLogRepository {
    private final String filePath;

    public BookingLogRepository(String filePath) {
        this.filePath = filePath;
    }

    public void save(BookingRequest request, BigDecimal grandTotal) {
        //До перевірки
        //long nights = ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate());
        //Після
        //ПІсля
        long nights = request.getNights();

        String nowStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dbEntry = String.format("%s|%s|%s|%dNights|%.2f%n",
                nowStr, request.getGuestName(), request.getRoomType(), nights, grandTotal);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(dbEntry);
        } catch (IOException e) {
            System.err.println("Помилка логування бронювання: " + e.getMessage());
        }
    }
}