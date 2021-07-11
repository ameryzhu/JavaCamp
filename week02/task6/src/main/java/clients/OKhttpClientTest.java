package clients;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.util.TextUtils;

import java.io.IOException;
import java.util.Objects;

public class OKhttpClientTest {
    public static void main(String[] args) {
        request("http://localhost:8801");
        request("http://localhost:8801", "opentoken", "crazydroid");
    }

    public static void request(String url) {
        request(url, null, null);
    }

    public static void request(String url, String key, String value) {
        Request request;
        if (!TextUtils.isEmpty(key)) {
            request = new Request.Builder().url(url).addHeader(key, value).build();
        } else {
            request = new Request.Builder().url(url).build();
        }


        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(Objects.requireNonNull(response.body()).string());
            ;
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
