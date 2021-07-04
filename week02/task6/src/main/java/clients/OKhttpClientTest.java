package clients;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class OKhttpClientTest {
    public static void main(String[] args) {
        request("http://localhost:8801");
    }

    public static void request(String url){
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client =new OkHttpClient();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(Objects.requireNonNull(response.body()).string());;
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
