package task5;

import java.util.Objects;

public class PatientMedicalRecordService {

    private final RecordStorage fileStorage;
    private final MedicalRecordRepository database;
    private final MedicalEventPublisher eventPublisher;

    public PatientMedicalRecordService(
            RecordStorage fileStorage,
            MedicalRecordRepository database,
            MedicalEventPublisher eventPublisher) {

        this.fileStorage = Objects.requireNonNull(fileStorage);
        this.database = Objects.requireNonNull(database);
        this.eventPublisher = Objects.requireNonNull(eventPublisher);
    }

    public void savePatientRecord(MedicalRecord record) {
        Objects.requireNonNull(record, "Медичний запис не може бути null.");

        if (record.getPatientId() == null
                || record.getPatientId().isBlank()) {
            throw new IllegalArgumentException(
                    "Некоректний ідентифікатор пацієнта."
            );
        }

        database.insertRecord(record);

        fileStorage.saveEncryptedRecord(
                record.getRecordId(),
                record.getDiagnosis()
        );

        eventPublisher.publishMedicalEvent(
                "PATIENT_DIAGNOSIS_UPDATED",
                record.getRecordId()
        );
    }
}
