package org.ATM;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = {"org.ATM", "org.ATM.Service", "org.ATM.Repository"})
public class AppConfig {
}
