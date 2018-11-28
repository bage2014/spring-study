package com.bage.annotation.filtersscanning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(basePackages = "com.bage.annotation.filtersscanning",
                includeFilters = @Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
                excludeFilters = @Filter(Repository.class))
public class AppConfig {

}
