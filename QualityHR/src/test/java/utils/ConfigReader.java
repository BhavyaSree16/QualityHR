package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getUrl() {
        return prop.getProperty("baseUrl");
    }

    public int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }
    
    public String getAdminUsername() {
        return prop.getProperty("admin.username");
    }

    public String getAdminPassword() {
        return prop.getProperty("admin.password");
    }

    public String getEmployeeFirstName() {
        return prop.getProperty("employee.firstname");
    }

    public String getEmployeeMiddleName() {
        return prop.getProperty("employee.middlename");
    }
    
    public String getEmployeeLastName() {
        return prop.getProperty("employee.lastname");
    }

    public String getInvalidEmployee() {
        return prop.getProperty("invalid.employee");
    }
}