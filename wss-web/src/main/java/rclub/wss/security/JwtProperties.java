package rclub.wss.security;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class JwtProperties {
    public static final String SECRET;
    public static final int EXPIRATION_TIME;
    public static final String TOKEN_PREFIX;
    public static final String HEADER_STRING;

    static {
        Config config = ConfigFactory.load("jwt.conf");
        SECRET = config.getString("secret");
        EXPIRATION_TIME = config.getInt("expiration");
        TOKEN_PREFIX = config.getString("prefix");
        HEADER_STRING = config.getString("header");
    }
}
