package de.derkomischeagilist;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeService {

    public static Integer currentTimeInEuropeBerlin() {
        Pattern pattern = Pattern.compile("\"unixtime\":.*?(\\d+)", Pattern.MULTILINE);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(new URI("http://worldtimeapi.org/api/timezone/Europe/Berlin"))
                            .build(),
                    HttpResponse.BodyHandlers.ofString()
            );

            Matcher matcher = pattern.matcher(response.body());

            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return -1;
    }
}
