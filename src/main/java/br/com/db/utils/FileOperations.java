package br.com.db.utils;

import java.io.*;
import java.util.Properties;

public class FileOperations {

    private static final String DIR_PATH = System.getProperty("user.dir")
            + File.separator +
            "src"
            + File.separator +
            "main"
            + File.separator+
            "resources"
            + File.separator;

    public static Properties getProperties(String fileName) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            File file = new File(fileName);
            inputStream = new FileInputStream(DIR_PATH + file);
            prop.load(inputStream);
            return prop;
        } catch (Exception e){
            LoggerFactory.log_INFO("Passando exception " + e.getMessage());
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return prop;
    }

    public static void setProperties(String nameProp,String propKey,String propValue) throws IOException {
        Properties prop = getProperties(nameProp);
        try {
            OutputStream outputStream = new FileOutputStream(DIR_PATH + nameProp);
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}