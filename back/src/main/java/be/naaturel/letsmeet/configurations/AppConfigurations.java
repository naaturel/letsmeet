package be.naaturel.letsmeet.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfigurations {

    @Value("${sec.cors.authorizedHots}")
    public String[] authorizedHosts;

    @Value("${sec.cors.authorizedMethods}")
    public String[] authorizedMethods;

    @Value("${sec.cors.authorizedHeader}")
    public String[] authorizedHeaders;

}