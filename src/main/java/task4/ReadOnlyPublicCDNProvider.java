package task4;

public class ReadOnlyPublicCDNProvider
        implements FileDownloader, PublicLinkGenerator {

    @Override
    public byte[] downloadFile(String name) {
        System.out.println("Downloading " + name + " from public CDN.");
        return new byte[0];
    }

    @Override
    public String generatePublicShareLink(String name) {
        return "https://example.com/share/" + name;
    }
}
