package org.Task1;

import java.net.HttpURLConnection;
import java.net.URL;

// Завдання 1
public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String imageUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new Exception("No image found for HTTP status code " + code);
        }
        return imageUrl;
    }
}

