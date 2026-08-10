package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    private String excelPath =
            System.getProperty("user.dir") + "/testData/Userdata.xlsx";


    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {

        XLUtility xl = new XLUtility(excelPath);

        int rownum = xl.getRowCount("UserData");
        int colcount = xl.getCellCount("UserData", 1);

        String[][] apiData = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {

            for (int j = 0; j < colcount; j++) {

                apiData[i - 1][j] =
                        xl.getCellData("UserData", i, j);
            }
        }

        return apiData;
    }


    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {

        XLUtility xl = new XLUtility(excelPath);

        int rownum = xl.getRowCount("UserData");

        String[] apiData = new String[rownum];

        for (int i = 1; i <= rownum; i++) {

            apiData[i - 1] =
                    xl.getCellData("UserData", i, 1);
        }

        return apiData;
    }
}