package com.bage.javaconfig.Composing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigA.class) // 将另一个 Config 包含进来
public class ConfigB {

}
