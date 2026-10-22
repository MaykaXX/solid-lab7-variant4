package task1_SRP;

import java.math.BigDecimal;

public class HotelBookingOrchestrator {
    private final BookingValidator validator;
    private final BookingPricingService pricingService;
    private final HtmlVoucherGenerator voucherGenerator;
    private final BookingLogRepository repository;
    private final SmsNotificationService notificationService;

    public HotelBookingOrchestrator(BookingValidator validator,
                                    BookingPricingService pricingService,
                                    HtmlVoucherGenerator voucherGenerator,
                                    BookingLogRepository repository,
                                    SmsNotificationService notificationService) {
        this.validator = validator;
        this.pricingService = pricingService;
        this.voucherGenerator = voucherGenerator;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processBooking(BookingRequest request) {
        validator.validate(request);
        BigDecimal grandTotal = pricingService.calculateTotal(request);
        String voucherHtml = voucherGenerator.generateHtml(request, grandTotal);
        repository.save(request, grandTotal);
        notificationService.sendBookingConfirmation(request, grandTotal);
        System.out.println("Ваучер успішно згенеровано (довжина HTML: " + voucherHtml.length() + " символів).");
    }
}