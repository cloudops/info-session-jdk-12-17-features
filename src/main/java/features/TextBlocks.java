package features;

import java.util.logging.Logger;

public class TextBlocks {

   private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void main(String[] args) {
      htmlExample();
      sqlExample();
   }

   private static void sqlExample() {
      String query1 = "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
                      "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
                      "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";

      String query2 = """
               SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
               WHERE "CITY" = 'INDIANAPOLIS'
               ORDER BY "EMP_ID", "LAST_NAME";
               """;

      LOGGER.info("");
      LOGGER.info(() -> "Equals? " + query1.equals(query2));
      LOGGER.info(query1);
      LOGGER.info(query2);
   }

   private static void htmlExample() {
      String html1 = "<html>\n" +
                     "  <body>\n" +
                     "    <p>Hello, World</p>\n" +
                     "  </body>\n" +
                     "</html>\n";

      String html2 = """
              <html>
                <body>
                  <p>Hello, World</p>   
                </body>
              </html>
              """;
      LOGGER.info("");
      LOGGER.info(() -> "Equals? " + html1.equals(html2));
      LOGGER.info(() -> html1);
      LOGGER.info(() -> html2);
   }
}
