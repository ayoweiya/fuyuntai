package com.naturaltel.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class DataTypeUtils {
    private static final Logger logger = LogManager.getLogger(DataTypeUtils.class);

    public static String parseToHex(String str) {
        String hexString = DatatypeConverter.printHexBinary(str.getBytes(StandardCharsets.UTF_8));
        logger.debug("hexString[{}]", hexString);
        return hexString;
    }

    public static String parseFromHex(String hexStr) {
        byte[] bytes     = DatatypeConverter.parseHexBinary(hexStr);
        String parsedStr = new String(bytes, StandardCharsets.UTF_8);
        logger.debug("parsedStr[{}]", parsedStr);
        return parsedStr;
    }

    public static String parseByteToBase64(byte[] bytes) {
        String base64String = DatatypeConverter.printBase64Binary(bytes);
        logger.debug("base64String[{}]", base64String);
        return base64String;
    }

    public static byte[] parseBase64ToByteArray(String base64String) {
        return DatatypeConverter.parseBase64Binary(base64String);
    }
}