package com.naturaltel.base;

import com.naturaltel.constant.LogFormat;
import com.naturaltel.model.SystemPropertiesModel;
import com.naturaltel.util.network.UrlUtils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BaseController extends BaseClass {
    protected static final String contentTypeJson = "application/json; charset=utf-8";
    protected static final String contentTypeXml  = "application/xml; charset=utf-8";
    protected static final String contentTypeHtml = "text/html; charset=utf-8";

    protected final Logger logger = LogManager.getLogger(getClass());
    protected final SystemPropertiesModel properties;
    private final String redirectPrefix = "redirect:";

    public BaseController(SystemPropertiesModel properties) {
        this.properties = properties;
    }

    protected String getSessionPage() {
        return (String) getSession().getAttribute("SessionPage");
    }

    protected void setSessionPage(String pageId) {
        getSession().setAttribute("SessionPage", pageId);
    }
    
    protected String redirectToLink(String redirectUrl, Map<String, String> parameters) {
        return redirectPrefix + redirectUrl + UrlUtils.parameterMapToParameterStringForGet(parameters);
    }

    protected String redirectToLink(String redirectUrl) {
        return redirectToLink(redirectUrl, null);
    }

    @SuppressWarnings("unused")
    private String redirectTo(String redirectMainPath, String redirectSubPath, Map<String, String> parameters) {
        return redirectPrefix + UrlUtils.generateUrl(redirectMainPath, redirectSubPath, parameters);
    }

    protected int getIntegerParameter(String parameterName) {
        String parameter       = getRequest().getParameter(parameterName);
        int    parsedParameter = 0;
        try {
            if (!GenericValidator.isBlankOrNull(parameter)) {
                parsedParameter = Integer.parseInt(parameter);
            } else {
                logger.trace(defaultLogFormat("parameterName[{}] is blank or null."), parameterName);
            }
        } catch (NumberFormatException e) {
            logger.trace(defaultLogFormat("parameterName[{}], parameter[{}] is not a number."), parameterName, parameter);
        }
        return parsedParameter;
    }

    protected String getStringParameter(String parameterName) {
        String parameter = StringEscapeUtils.escapeHtml4(getRequest().getParameter(parameterName));
        if (GenericValidator.isBlankOrNull(parameter)) {
            parameter = "";
            logger.trace(defaultLogFormat("parameterName[{}] is blank or null."), parameterName);
        }
        return parameter;
    }

    protected List<String> getStringParameterValues(String parameterName) {
        List<String> valueList       = new ArrayList<>();
        String[]     parameterValues = getRequest().getParameterValues(parameterName);
        if (parameterValues != null) {
            for (String value : parameterValues) {
                // 這裡可以加入處理參數的程式
                // value = value....
                value = StringEscapeUtils.escapeHtml4(value);
                valueList.add(value);
            }
        } else {
            logger.trace(defaultLogFormat("parameterName[{}] is null."), parameterName);
        }
        return valueList;
    }

    @Override
    protected String defaultLogFormat(String logFormat) {
    	return String.format(LogFormat.DEFAULT_CONTROLLER_LOG_FORMAT.getValue(), getSessionId(), logFormat);
    }
    
    @Override
    protected String defaultMethodInvokeLogFormat() {
        return defaultLogFormat(String.format("method invoked, parameters:[%s]", createParameterLog()));
    }

    @Override
    protected String defaultMethodExceptionLogFormat(Exception e) {
        return defaultLogFormat(String.format("exception occurred[%s]", e.getMessage()));
    }

    @Override
    protected String defaultMethodExceptionLogFormat(Exception e, String logFormat) {
        return defaultLogFormat(String.format("exception occurred[%s]. %s", e.getMessage(), logFormat));
    }

    private String createParameterLog() {
        Enumeration<String> parameterNames = getRequest().getParameterNames();
        StringBuilder       stringBuilder  = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            int      count         = 0;
            String   parameterName = parameterNames.nextElement();
            String[] parameters    = getRequest().getParameterValues(parameterName);
            stringBuilder.append(parameterName).append("=");
            for (String parameter : parameters) {
                if (count != 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(parameter);
                count++;
            }
            stringBuilder.append(",");
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        } else {
            return stringBuilder.append("No parameters").toString();
        }
    }

    protected String getRemoteIP() {
        HttpServletRequest request = getRequest();
        String             ip      = request.getHeader(" x-forwarded-for ");

        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}