package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderObject {
    @DataProvider(parallel = true)
    public Object[][] Data() {
        return new Object[][] {
                {"chrome", "FName1", "LName1","User1","Pass1","admin@gmail.com","082555"}
        };
    }
    @DataProvider(parallel = true)
    public Object[] Data2(){
        return new Object[][]{
                {"chrome", "FName2", "LName2","User2","Pass2","admin@gmail.com","083444"}
        };
    }
}
