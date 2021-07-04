package clients;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class HttpClientTest {
    public static void main(String[] args) {
        httpClientTest();
    }

    public static void httpUrlConnectionTest() {
        try {
            URL url = new URL("http://localhost:8801");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            Object content = urlConnection.getResponseMessage();
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void httpClientTest() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8801");
        try {
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                if(line!=null){
                    builder.append(line);
                }
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}