package com.naturaltel.util.network;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetworkUtil {

    private static Logger logger = LogManager.getLogger(NetworkUtil.class);

    public static String http(String urlStr) {
        logger.info("http(" + urlStr + ")");
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.connect();
            return readInputStream(conn.getInputStream());
        } catch (Exception ex) {
            logger.error("error occured: ", ex);
        }
        return null;
    }

    public static String http(String urlStr, String resCharset) {
        logger.info("http(" + urlStr + ", " + resCharset + ")");
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.connect();
            return readInputStream(conn.getInputStream(), resCharset);
        } catch (Exception ex) {
            logger.error("error occured: ", ex);
        }
        return null;
    }

    public static String https(String urlStr) {
        logger.info("https(" + urlStr + ")");
        try {
            URL url = new URL(urlStr);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn.connect();
            return readInputStream(conn.getInputStream());
        } catch (Exception ex) {
            logger.error("error occured: ", ex);
        }
        return null;
    }

    public static String readInputStream(InputStream is) {
        StringBuilder text = new StringBuilder();
        if (is != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                for (String line = null; (line = br.readLine()) != null;) {
                    text.append(line).append("\n");
                }
                br.close();
            } catch (Exception ex) {
                logger.error("error occured: ", ex);
            }
        }
        return text.toString();
    }

    public static String readInputStream(InputStream is, String resCharset) {
        StringBuilder text = new StringBuilder();
        if (is != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is, resCharset));
                for (String line = null; (line = br.readLine()) != null;) {
                    text.append(line).append("\n");
                }
                br.close();
            } catch (Exception ex) {
                logger.error("error occured: ", ex);
            }
        }
        return text.toString();
    }
}