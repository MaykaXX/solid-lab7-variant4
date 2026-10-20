package task5_DIP;

public class OracleHealthDatabase implements MedicalRecordRepository {

    @Override
    public void insertRecord(MedicalRecord record) {
        System.out.println(
                "[Oracle Health DB] Запис " + record.getRecordId()
                        + " для пацієнта " + record.getPatientId()
                        + " збережено в таблицю PATIENT_RECORDS."
        );
    }
}
