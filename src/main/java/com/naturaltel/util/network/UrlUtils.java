package com.naturaltel.util.network;

import com.naturaltel.util.DataTypeUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class UrlUtils {

    private static final Logger logger = LogManager.getLogger(UrlUtils.class);

    private static String parameterMapToParameterString(Map<String, String> paramMap, boolean forGet) {
        int           count           = 1;
        StringBuilder parameterString = new StringBuilder("");
        if (paramMap != null) {
            for (Map.Entry<String, String> parameter : paramMap.entrySet()) {
                if (count == 1) {
                    if (forGet) {
                        parameterString.append("?");
                    }
                } else {
                    parameterString.append("&");
                }
                parameterString.append(parameter.getKey()).append("=").append(parameter.getValue());
                count++;
            }
        }
        return parameterString.toString();
    }

    public static String parameterMapToParameterStringForGet(Map<String, String> paramMap) {
        return parameterMapToParameterString(paramMap, true);
    }

    public static String parameterMapToParameterStringForPost(Map<String, String> paramMap) {
        return parameterMapToParameterString(paramMap, false);
    }

    public static String generateUrl(String mainPath, String subPath, Map<String, String> parameters) {
        logger.debug("Method invoked");
        StringBuilder returnUrl = new StringBuilder("");
        if (!GenericValidator.isBlankOrNull(mainPath)) {
            returnUrl.append("/").append(mainPath);
        }
        if (!GenericValidator.isBlankOrNull(subPath)) {
            returnUrl.append("/").append(subPath);
        }
        returnUrl.append(parameterMapToParameterStringForGet(parameters));
        return returnUrl.toString();
    }

    public static String generateHexUrl(String mainPath, String subPath, Map<String, String> parameters) {
        String url = generateUrl(mainPath, subPath, parameters);
        return DataTypeUtils.parseToHex(url);
    }
}