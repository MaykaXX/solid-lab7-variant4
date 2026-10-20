package task4;

public class LocalFileSyncProvider
        implements FileUploader, FileDownloader,
        FileDeleter, ArchiveCompressor {

    @Override
    public void uploadFile(String name, byte[] data) {
        System.out.println("Uploaded " + name + " to local disk.");
    }

    @Override
    public byte[] downloadFile(String name) {
        System.out.println("Downloading " + name + " from local disk.");
        return new byte[0];
    }

    @Override
    public void deleteFile(String name) {
        System.out.println("Deleted " + name + " from local disk.");
    }

    @Override
    public void compressArchive(String folderPath) {
        System.out.println("Archived " + folderPath + ".");
    }
}
