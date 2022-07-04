package com.naturaltel.model;

import com.naturaltel.base.BaseClass;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemPropertiesModel extends BaseClass {
    public final String mainUrl;

    public SystemPropertiesModel(
            @Value("${mainUrl}")
                    String mainUrl) {
        logger.info(defaultLogFormat("SystemPropertiesModel instantiation start."));

        this.mainUrl = mainUrl;

        printAllProperties();
        logger.info(defaultLogFormat("SystemPropertiesModel instantiation over."));
    }

    private void printAllProperties() {
        for (Field field : getClass().getDeclaredFields()) {
            String key = field.getName();
            try {
                Object value = field.get(this);
                if (value != null) {
                    logger.info(defaultLogFormat("{}[{}]"), key, value.toString());
                } else {
                    logger.fatal(defaultLogFormat("{} not got value from system property."), key);
                }
            } catch (IllegalAccessException e) {
                logger.fatal(defaultLogFormat("when getting {}, an exception occurred[{}]."), key, e.getMessage());
            }
        }
    }
}