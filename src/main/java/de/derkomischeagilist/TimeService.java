package de.derkomischeagilist;

import io.vertx.core.cli.InvalidValueException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeService {

    private String tz;

    public TimeService() {
        this.tz = "Europe/Berlin";
    }

    public Long currentTime() {
        return currentTime(this.tz);
    }

    public static Long currentTime(String tz) {
        Pattern pattern = Pattern.compile("(\\d+)", Pattern.MULTILINE);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(new URI("https://europe-west3-fantastic-guacamole.cloudfunctions.net/csd-time-service"))
                            .build(),
                    HttpResponse.BodyHandlers.ofString()
            );
            if (response.statusCode() != 200) {
                throw new Exception("Wrong status: " + response.statusCode());
            }

            Matcher matcher = pattern.matcher(response.body());

            if (matcher.find()) {
                return Long.parseLong(matcher.group(1));
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return -1L;
    }
}
