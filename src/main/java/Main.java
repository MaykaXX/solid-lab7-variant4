import task1_SRP.*;
import task2_OCP.*;
import task3_LSP.*;
import task4_ISP.LocalFileSyncProvider;
import task4_ISP.ReadOnlyPublicCDNProvider;
import task5_DIP.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------- ТЕСТ ЗАВДАННЯ 1 (SRP) --------");
        HotelBookingOrchestrator bookingOrchestrator = new HotelBookingOrchestrator(
                new BookingValidator(),
                new BookingPricingService(),
                new HtmlVoucherGenerator(),
                new BookingLogRepository("hotel_bookings.log"),
                new SmsNotificationService()
        );

        BookingRequest bookingRequest = new BookingRequest(
                "Марія",
                "+380991234567",
                "Deluxe",
                LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(5),
                true,
                List.of("Breakfast", "Spa")
        );
        bookingOrchestrator.processBooking(bookingRequest);

        System.out.println("\n-------- ТЕСТ ЗАВДАННЯ 2 (OCP) --------");
        TaxCalculator taxCalculator = new TaxCalculator();
        ImportGoods laptop = new ImportGoods("E100", "Ноутбук Dell", new BigDecimal("1200"), new BigDecimal("2.5"));
        ImportGoods apples = new ImportGoods("F200", "Яблука сортові", new BigDecimal("500"), new BigDecimal("100.0"));
        ImportGoods chemicalReagent = new ImportGoods("C300", "Промисловий реагент", new BigDecimal("800"), new BigDecimal("50.0"));

        taxCalculator.calculateTotalTax(laptop, new ElectronicsTaxStrategy());
        taxCalculator.calculateTotalTax(apples, new FoodTaxStrategy());
        // Демонстрація розширення новою стратегією без правок у TaxCalculator:
        taxCalculator.calculateTotalTax(chemicalReagent, new ChemicalTaxStrategy());

        System.out.println("\n-------- ТЕСТ ЗАВДАННЯ 3 (LSP) --------");
        WarehouseManager warehouseManager = new WarehouseManager();
        PhysicalInventoryItem mouse = new PhysicalInventoryItem("HW-01", "Мишка бездротова", 50, new BigDecimal("25.0"));
        DigitalLicenseItem winLicense = new DigitalLicenseItem("SW-01", "Windows 11 Pro", new BigDecimal("150.0"), "XXXX-XXXX-XXXX");

        // Управління фізичним товаром:
        mouse.restock(20);
        warehouseManager.processDefectiveReturn(mouse, 10);


        System.out.println("Test LSP");
        List<Item> cart = List.of(mouse, winLicense);

        for (Item item : cart) {
            // Контракт Item виконується без UnsupportedOperationException
            System.out.println("Товар: " + item.getTitle() + " | Ціна: " + item.getUnitPrice() + " грн");
        }

        // Цифровий товар існує як Item, але не може бути некоректно переданий у складський процес:
        System.out.println("Цифрова ліцензія створена: " + winLicense.getTitle() + " (" + winLicense.getLicenseKeyPattern() + ")");

        System.out.println("=== TASK 4: ISP ===");

        ReadOnlyPublicCDNProvider cdn =
                new ReadOnlyPublicCDNProvider();

        System.out.println("\n--- ReadOnlyPublicCDNProvider ---");

        byte[] downloadedFile = cdn.downloadFile("document.pdf");
        System.out.println("Downloaded bytes: " + downloadedFile.length);

        String link = cdn.generatePublicShareLink("document.pdf");
        System.out.println("Public link: " + link);

        LocalFileSyncProvider localStorage =
                new LocalFileSyncProvider();

        System.out.println("\n--- LocalFileSyncProvider ---");

        localStorage.uploadFile("report.txt", new byte[]{1, 2, 3});
        localStorage.downloadFile("report.txt");
        localStorage.deleteFile("old_report.txt");
        localStorage.compressArchive("backup.zip");


        System.out.println("=== TASK 5: DIP ===");

        MedicalRecordRepository database =
                new OracleHealthDatabase();

        RecordStorage storage =
                new EncryptedLocalFileStorage();

        MedicalEventPublisher eventPublisher =
                new HospitalEventBusPublisher();

        PatientMedicalRecordService service =
                new PatientMedicalRecordService(
                        storage,
                        database,
                        eventPublisher
                );

        MedicalRecord record = new MedicalRecord(
                "MR001",
                "P001",
                "Грип",
                "Рекомендовано відпочинок та лікування"
        );

        service.savePatientRecord(record);
    }
}