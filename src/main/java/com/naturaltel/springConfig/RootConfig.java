package com.naturaltel.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({DataConfig.class, SecurityConfig.class})
@ComponentScan({"com.naturaltel.dao", "com.naturaltel.service", "com.naturaltel.model"})
public class RootConfig {
}