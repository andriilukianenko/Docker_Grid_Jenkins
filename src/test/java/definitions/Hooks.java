package definitions;

import driverManager.DriverManager;

import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearnDownTest() {
        DriverManager.closeDriver();
    }
}