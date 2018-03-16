package org.nedezkiiyasen.uha.web.config;

import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfig.class, CoreConfig.class})
public class RootConfig {
}
