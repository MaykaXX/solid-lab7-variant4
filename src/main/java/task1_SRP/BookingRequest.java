package task1_SRP;

import java.time.LocalDate;
import java.util.List;

public class BookingRequest {
    private String guestName;
    private String guestPhone;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isLoyaltyMember;
    private List<String> extraServices;

    public BookingRequest(String guestName, String guestPhone, String roomType,
                          LocalDate checkInDate, LocalDate checkOutDate,
                          boolean isLoyaltyMember, List<String> extraServices) {
        this.guestName = guestName;
        this.guestPhone = guestPhone;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isLoyaltyMember = isLoyaltyMember;
        this.extraServices = extraServices;
    }

    public String getGuestName() { return guestName; }
    public String getGuestPhone() { return guestPhone; }
    public String getRoomType() { return roomType; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public boolean isLoyaltyMember() { return isLoyaltyMember; }
    public List<String> getExtraServices() { return extraServices; }
}