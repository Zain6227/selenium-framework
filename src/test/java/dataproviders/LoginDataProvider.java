package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {
                {"student", "Password123"},
                {"invalid", "Password123"},
                {"student", "invalid"},
                {"invalid", "invalid"}
        };
    }
}
