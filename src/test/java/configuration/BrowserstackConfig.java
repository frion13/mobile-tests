package configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${deviceHost}.properties")

public interface BrowserstackConfig extends Config {

    @Key("app")
    String applId();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("browserstack_url")
    String browserstackURL();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("test_name")
    String testName();

}
