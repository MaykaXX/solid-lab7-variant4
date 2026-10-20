package task5;

public class EncryptedLocalFileStorage implements RecordStorage {

    @Override
    public void saveEncryptedRecord(String recordId, String data) {
        System.out.println(
                "[Encrypted File Storage] Картку " + recordId
                        + " зашифровано та збережено у локальне сховище."
        );
    }
}