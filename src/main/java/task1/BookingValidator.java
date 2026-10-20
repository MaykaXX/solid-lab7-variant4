package task1;

import java.time.LocalDate;

public class BookingValidator {
    public void validate(BookingRequest request) {
        if (request.getGuestName() == null || request.getGuestName().isBlank() ||
                request.getGuestPhone() == null || request.getGuestPhone().isBlank()) {
            throw new IllegalArgumentException("Вкажіть ім'я гостя та контактний номер телефону.");
        }

        if (request.getCheckInDate() == null || request.getCheckOutDate() == null) {
            throw new IllegalArgumentException("Дати бронювання не можуть бути порожніми.");
        }

        if (request.getCheckInDate().isBefore(LocalDate.now()) || !request.getCheckOutDate().isAfter(request.getCheckInDate())) {
            throw new IllegalStateException("Некоректний період проживання.");
        }
    }
}