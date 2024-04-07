package configuration;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${deviceHost}.properties")
public interface EmulatorConfig extends Config {

    @Key("device")
    String device();

    @Key("deviceOsVersion")
    String deviceOsVersion();

    @Key("appVersion")
    String appVersion();

    @Key("appUrl")
    String appUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();








}
