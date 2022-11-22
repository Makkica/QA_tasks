package utils;

import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class used to handle reading data
 * from .properties files. This is set up
 * to handle the main common.properties file
 * as well as any other files we need.
 */
public class PropertiesUtils extends LoggerUtils {

  /**
   * Default file containing most of our required parameters
   */
  private static final String sPropertiesPath = "common.properties";

  private static final Properties properties = loadPropertiesFile();

  /**
   * Using the getResourceAsStream(), we load the contents of the
   * given .properties file and save it as a InputStream.
   * The now loaded data is serialized into the correct format
   * using load() from the Properties class.
   */
  public static Properties loadPropertiesFile(String sFilePath) {
    InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(sFilePath);
    Properties properties = new Properties();
    try {
      properties.load(inputStream);
    }
    catch (IOException e) {
      Assert.fail("Cannot load " + sFilePath + " file! Message: " + e.getMessage());
    }
    return properties;
  }

  /**
   * Passing a key in form of a String,
   * we query the properties variable containing
   * all the key-value pairs, and returns the result
   * if the key lookup is valid.
   */
  private static String getProperty(String sProperty) {
    log.trace("getProperty(" + sProperty + ")");
    String sResult = properties.getProperty(sProperty);
    Assert.assertNotNull(sResult, "Cannot find property '" + sProperty + "' in " + sPropertiesPath + " file!");
    return sResult;
  }

  /**
   * Returns an appropriate base URL dependent
   * on the value of the 'environment' property
   * located in common.properties file.
   * Possible values are: local, test and prod.
   */
  public static String getBaseUrl() {
    String sEnvironment = getEnvironment().toLowerCase();
    String sBaseUrl = null;
    switch (sEnvironment) {
      case "local": {
        sBaseUrl = getLocalBaseUrl();
        break;
      }
      case "test": {
        sBaseUrl = getTestBaseUrl();
        break;
      }
      case "prod": {
        sBaseUrl = getProdBaseUrl();
        break;
      }
      default: {
        Assert.fail("Cannot get BaseUrl! Environment '" + sEnvironment + "' is not recognized!");
      }
    }
    return sBaseUrl;
  }

  /**
   * Wrapper pointing to the default file (common.properties)
   */
  private static Properties loadPropertiesFile() {
    return loadPropertiesFile(sPropertiesPath);
  }

  /**
   * Various GET methods for each property
   * we store in our properties file(s)
   */
  private static String getEnvironment() {
    return getProperty("environment");
  }

  private static String getLocalBaseUrl() {
    return getProperty("localBaseUrl");
  }

  private static String getTestBaseUrl() {
    return getProperty("testBaseUrl");
  }

  private static String getProdBaseUrl() {
    return getProperty("prodBaseUrl");
  }

  public static String getBrowser() {
    return getProperty("browser");
  }

  public static boolean getRemote() {
    return Boolean.parseBoolean(getProperty("remote"));
  }

  public static boolean getHeadless() {
    return Boolean.parseBoolean(getProperty("headless"));
  }

  public static String getHubUrl() {
    return getProperty("hubUrl");
  }

  public static String getDriversFolder() {
    return getProperty("driversFolder");
  }

}