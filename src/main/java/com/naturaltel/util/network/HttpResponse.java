/*
 *  HttpResponse
 *  
 *  Created on 2009/2/25 上午 11:01:44
 */

package com.naturaltel.util.network;

/**
 *<p><strong> </strong>
 * @author Daniel
 * @version
 * @since
 */
/**

 * For information about HTTP response.

 * @author cerberus

 */

public class HttpResponse {
    private String url = null;

    private String params = null;

    private String method = null;

    private int status = 0;

    private String resp = null;

    public HttpResponse(String url, String params, String method, int status, String resp) {
        setUrl(url);
        setParameterString(params);
        setMethod(method);
        setStatus(status);
        setResponse(resp);
    }

    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getParameterString() {
        return params;
    }

    public void setParameterString(String params) {
        this.params = params;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getResponse() {
        return resp;
    }
    
    public void setResponse(String resp) {
        this.resp = resp;
    }
    
    @Override
    public String toString() {
        return getResponse();
    }
}