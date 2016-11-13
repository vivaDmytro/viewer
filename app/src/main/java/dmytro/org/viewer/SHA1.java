package dmytro.org.viewer;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class SHA1 {

    public static String toSha1(String text) {
        return Hashing.sha1().hashString(text, Charset.defaultCharset()).toString();
    }
}
