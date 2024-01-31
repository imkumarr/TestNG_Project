package com.excelData;

import java.util.ArrayList;

import com.Excel.Xls_Reader;

public class TestUtil {
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFormatExcel() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try {
            reader = new Xls_Reader("./src/main/java/com/Excel/Excel_Data.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowCnt = 2; rowCnt <= reader.getRowCount("Sheet1"); rowCnt++) {

            String fistName = reader.getCellData("Sheet1", "fistName", rowCnt);
            String middleName = reader.getCellData("Sheet1", "middleName", rowCnt);
            String lastName = reader.getCellData("Sheet1", "lastName", rowCnt);
            String EmpId = reader.getCellData("Sheet1", "EmpId", rowCnt);
            String Otherid = reader.getCellData("Sheet1", "Otherid", rowCnt);
            String DLic = reader.getCellData("Sheet1", "DLic", rowCnt);
            String ph = reader.getCellData("Sheet1", "ph", rowCnt);
            String MStu = reader.getCellData("Sheet1", "MStu", rowCnt);
            String National = reader.getCellData("Sheet1", "National", rowCnt);

            // Check if any of the required fields are empty
            if (fistName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || EmpId.isEmpty()
                    || ph.isEmpty() || Otherid.isEmpty() || DLic.isEmpty() || MStu.isEmpty() || National.isEmpty()) {
                // Log a message or handle the empty values appropriately
                System.out.println("Skipping row with empty values.");
            } else {
                // Add the data to the list
                Object ob[] = { fistName, middleName, lastName, EmpId, ph, Otherid, DLic, MStu, National };
                myData.add(ob);
            }
        }
        return myData;
    }

    public static void printTestData(ArrayList<Object[]> testData) {
        for (Object[] data : testData) {
            System.out.println("Data: " + java.util.Arrays.toString(data));
        }
    }
        
    public static void main(String[] args) {
        // Call the data retrieval method and print the data
        ArrayList<Object[]> testData = getDataFormatExcel();
        printTestData(testData);
    }
}
