package org.Task1;

// Завдяки цьому класу, можна отримати картинку за посиланням (Завдання 1)
public class HttpStatusCheckerGetInBrowser {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            int code = 420; // Виклик
            String imageUrl = checker.getStatusImage(code);
            System.out.println("Успіх! Ваш котик тут: " + imageUrl);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
