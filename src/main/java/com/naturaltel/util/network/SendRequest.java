package com.naturaltel.util.network;

/*
 * SendRequest.java
 *
 * Created on 2009年01月25日, 上午 00:38
 *
 */
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *<p><strong>To send request from servlet</strong>
 *@author Daniel
 *@version 2.0
 *@since  1.0
 */
public class SendRequest {
    public static void sendAlarm(String alarmServerAddr, int alarmServerPort,
	    String alarmPrefix, String alarmClass, String message, int alarm_timeout) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        try {
            socket.setSoTimeout(alarm_timeout);
            byte[] byteData = (alarmPrefix + ":" + alarmClass + ":" + message).getBytes();
            DatagramPacket packet = new DatagramPacket(byteData, byteData.length,
                    new InetSocketAddress(alarmServerAddr, alarmServerPort));
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (socket != null) {
                socket.close();
                socket = null;
            }
        }
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            int readTimeout, String deCode, String headerName, String headerValue) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            System.out.println("URL=[" + url + "]");
            System.out.println("Params=[" + params + "]");
            HostnameVerifier hv = new HostnameVerifier() {

                public boolean verify(String urlHostName, SSLSession session) {
                    System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty(headerName, headerValue);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(params.length()));
            
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream(), deCode));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            System.out.println("Response=[" + hr.toString() + "]");
            System.out.println("Response=[" + connection.getHeaderField("sessionid") + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            tt.printStackTrace();
            throw tt;
        } catch (Exception t) {
            t.printStackTrace();
            throw t;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static void checkResponseCode(String url, String method, String params, int conTimeout, boolean useSSL,
            int readTimeout) throws Exception {
        // create a HTTP connection
        System.out.println("URL=[" + url + "]");
        System.out.println("Params=[" + params + "]");
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
        connection.setRequestMethod(method);
        connection.setInstanceFollowRedirects(true);
        connection.setUseCaches(false);
        connection.setDefaultUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(conTimeout);
        connection.setReadTimeout(readTimeout);
        // send request
        if (method.equals("POST")) {
            DataOutputStream dos = null;
            try {
                dos = new DataOutputStream(connection.getOutputStream());
                dos.writeBytes(params);
                dos.flush();
            } finally {
                if (dos != null) {
                    dos.close();
                }
            }
        }

        System.out.println("get Response Code=[" + connection.getResponseCode() + "]");
        if (connection.getResponseCode() == 305) {
            String locationHeader = connection.getHeaderField("locationHeader");
            System.out.println("locationHeader=[" + locationHeader + "]");
        }
        if (connection != null) {
            connection.disconnect();
        }
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            int readTimeout) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            System.out.println("URL=[" + url + "]");
            System.out.println("Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            System.out.println("Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            tt.printStackTrace();
            throw tt;
        } catch (Exception t) {
            t.printStackTrace();
            throw t;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            Logger log, int readTimeout) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };

                HostnameVerifier trustAllHostnames = new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession session) {
                        return true; // Just allow them all.
                    }
                };
                
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                HttpsURLConnection.setDefaultHostnameVerifier(trustAllHostnames);                
            }
            // create a HTTP connection
            log.info("URL=[" + url + "]");
            log.info("Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            log.info("Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            log.error("SocketTimeoutException ", tt);
            throw tt;
        } catch (Exception t) {
            log.error("", t);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            Log log, int readTimeout) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                	    return null;
                	    }
                	
                	public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                	}
                	
                	public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                	}
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            log.info("URL=[" + url + "]");
            log.info("Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            log.info("Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            log.error("SocketTimeoutException ", tt);
            throw tt;
        } catch (Exception t) {
            log.error("", t);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static HttpResponse sendHTTPRequest(String threadName,
            String url, String method, String params, int conTimeout, boolean useSSL,
            Logger log, int readTimeout) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            log.info(threadName + "URL=[" + url + "]");
            log.info(threadName + "Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            log.info(threadName + "Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            log.error(threadName + "SocketTimeoutException ", tt);
            throw tt;
        } catch (Exception t) {
            log.error(threadName, t);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            int readTimeout, Logger logger) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            logger.info("URL=[" + url + "]");
            logger.info("Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);
            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }
            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            logger.info("Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            tt.printStackTrace();
            throw tt;
        } catch (Exception t) {
            t.printStackTrace();
            throw t;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }

    public static HttpResponse sendHTTPRequest(
            String url, String method, String params, int conTimeout, boolean useSSL,
            int readTimeout, String deCode, String headerName, String headerValue, Logger logger) throws Exception, ConnectException {
        HttpResponse hr = new HttpResponse(url, params, method, -1, null);
        HttpURLConnection connection = null;
        try {
            if (useSSL) {
                // Install the all-trusting trust manager
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs,
                                String authType) {
                        }
                    }
                };
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            // create a HTTP connection
            logger.info("URL=[" + url + "]");
            logger.info("Params=[" + params + "]");
            connection = (HttpURLConnection) new URL(method.equals("POST") ? url : url + "?" + params).openConnection();
            connection.setRequestMethod(method);
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(conTimeout);
            connection.setReadTimeout(readTimeout);

            connection.setRequestProperty("User-Agent", "*");
            connection.setRequestProperty("Content-Length", Integer.toString(params.length()));

            // send request
            if (method.equals("POST")) {
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes(params);
                    dos.flush();
                } finally {
                    if (dos != null) {
                        dos.close();
                    }
                }
            }

            logger.info("Response StatusCode =[" + connection.getResponseCode() + "]");

            // receive response
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                hr.setResponse("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    hr.setResponse(hr.getResponse() + line + "\r\n");
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            hr.setStatus(connection.getResponseCode());
            logger.info("Response=[" + hr.toString() + "]");
        } catch (ConnectException s) {
            throw s;
        } catch (SocketTimeoutException tt) {
            tt.printStackTrace();
            throw tt;
        } catch (Exception t) {
            t.printStackTrace();
            throw t;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return hr;
    }
}