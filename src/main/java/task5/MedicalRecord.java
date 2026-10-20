package task5;

public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String diagnosis;
    private String doctorNotes;

    public MedicalRecord(
            String recordId,
            String patientId,
            String diagnosis,
            String doctorNotes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.doctorNotes = doctorNotes;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }
}
