package Task2;

import org.Task1.HttpStatusChecker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        try {
            String imageUrl = checker.getStatusImage(code);
            URL url = new URL(imageUrl);
            InputStream inputStream = url.openStream();
            File outputFile = new File(code + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
            System.out.println("Картинка успішно завантажена: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            throw new Exception("Невдача! " + code, e);
        }
    }
}