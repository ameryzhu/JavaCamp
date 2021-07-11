import io.netty.handler.codec.http.HttpHeaders;

import java.util.List;
import java.util.Map;

public class GatewayAuthChecker {

    public static boolean checkHeaders(HttpHeaders headers) {
        String value = headers.get("openToken");
        System.out.println("value:"+value);
        return "crazydroid".equals(value);
    }
}
