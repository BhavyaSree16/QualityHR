package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;

public class EndToEndTest extends BaseTest {

    @Test
    public void completeEmployeeFlow() {

        // Step 1: Login
        LoginPage lp = new LoginPage(driver, config.getTimeout());
        lp.login(config.getAdminUsername(), config.getAdminPassword());

        Assert.assertTrue(lp.isDashboardVisible(), "Login failed");

        // Step 2: Navigate to PIM
        DashboardPage dp = new DashboardPage(driver, config.getTimeout());
        dp.goToPIM();

        EmployeePage ep = new EmployeePage(driver, config.getTimeout());

        // Step 3: Add Employee
        String firstName = config.getEmployeeFirstName() + System.currentTimeMillis();
        String middleName = config.getEmployeeMiddleName();
        String lastName = config.getEmployeeLastName();

        ep.clickAddEmployee();
        ep.addEmployee(firstName, middleName, lastName);

        // Step 4: Wait for Personal Details
        ep.waitForPersonalDetails();

        // Step 5: Capture Employee ID
        String empId = ep.getEmployeeId();

        // Step 6: Verify using ID
        ep.goToEmployeeList();
        ep.searchById(empId);

        Assert.assertTrue(ep.isEmployeePresentInTable(firstName),
                "Employee not found using ID");

        // Step 7: Search by Name
        ep.searchByName(firstName);

        Assert.assertTrue(ep.isEmployeePresentInTable(firstName),
                "Employee not found in name search");

        // Step 8: Open record
        ep.clickFirstRow();
        ep.waitForPersonalDetails();

        String actualName = ep.getFirstNameFromDetails();

        Assert.assertTrue(actualName.contains(firstName),
                "Name mismatch in details page");

        // Step 9: Logout
        lp.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Logout failed");
    }
}