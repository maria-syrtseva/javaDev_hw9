package Task3;

import Task2.HttpStatusImageDownloader;
import java.util.Scanner;

class HttpImageStatusCli {
    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть код статусу, щоб отримати котика:");

        try {
            String input = scanner.nextLine();
            int code = Integer.parseInt(input);

            try {
                downloader.downloadStatusImage(code);
            } catch (Exception e) {
                System.out.println("Невдача! За таким кодом немає статусу " + code);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
