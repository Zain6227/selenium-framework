package dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "invalid-login-data")
    public Object[][] invalidLoginData() {
        return new Object[][] {
            { "incorrectUser", "Password123" },
            { "student", "incorrectPassword" }
        };
    }
}