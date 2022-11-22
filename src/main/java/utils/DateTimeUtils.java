package utils;

public class DateTimeUtils extends LoggerUtils {

  /**
   * Wait method that uses Thread.sleep()
   * @param iSeconds {int} - Seconds
   */
  public static void wait (int iSeconds) {
    try {
      Thread.sleep(1000L * iSeconds);
    } catch (InterruptedException e) {
      log.warn("InterruptedException in Thread.sleep(). Message: " + e.getMessage());
    }
  }

}
