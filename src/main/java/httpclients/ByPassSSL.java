package httpclients;


import java.io.IOException;
import java.net.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class ByPassSSL {
    public static void main(String[] args) throws IOException {
        String SAMPLE_URL = "https://httpbin.org/status/200";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = (CloseableHttpResponse) client.execute(new HttpGet(SAMPLE_URL));
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
    }
}
