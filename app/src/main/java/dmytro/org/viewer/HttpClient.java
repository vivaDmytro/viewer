package dmytro.org.viewer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public JSONObject authorize(String login, String password) throws IOException, JSONException {
//        String sha1Password = SHA1.toSha1(password);
//        URL url = new URL("http://auth.myauth-system/");
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        try {
//            urlConnection.setDoOutput(true);
//            urlConnection.setChunkedStreamingMode(0);
//
//            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
//            writeStream(out);
//
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//            readStream(in);
//        } finally {
//            urlConnection.disconnect();
//        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("httpStatus", 200);
        jsonObject.put("accessToken", "1233rrtg4353");
        jsonObject.put("refreshToken", "89898jkjk67672362");
        return jsonObject;
    }

    private void readStream(InputStream in) {

    }

    private void writeStream(OutputStream out) {

    }
}
