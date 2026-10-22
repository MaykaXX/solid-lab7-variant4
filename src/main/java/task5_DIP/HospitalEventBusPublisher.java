package task5_DIP;

public class HospitalEventBusPublisher implements MedicalEventPublisher {

    @Override
    public void publishMedicalEvent(String eventType, String recordId) {
        System.out.println(
                "[Hospital EventBus] Опубліковано подію "
                        + eventType + " для запису " + recordId + "."
        );
    }
}
