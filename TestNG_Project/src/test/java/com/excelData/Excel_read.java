package com.excelData;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import com.Excel.Xls_Reader;

public class Excel_read {

    @DataProvider(name = "excelData")
    public static Iterator<Object[]> provideExcelData() {
        ArrayList<Object[]> testData = getDataFromExcel();
        return testData.iterator();
    }

    public static ArrayList<Object[]> getDataFromExcel() {
        Xls_Reader reader = new Xls_Reader("./src/main/java/com/Excel/Excel_Data.xlsx");
        ArrayList<Object[]> myData = new ArrayList<Object[]>();

        int rowCount = reader.getRowCount("Sheet1");

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
           // System.out.println("=====");
            String fistName = reader.getCellData("Sheet1", "First Name", rowNum);
           // System.out.println(fistName);

            String middleName = reader.getCellData("Sheet1", "Middle Name", rowNum);
            //System.out.println(middleName);

            String lastName = reader.getCellData("Sheet1", "Last Name", rowNum);
            //System.out.println(lastName);

            String EmpId = reader.getCellData("Sheet1", "Employee Id", rowNum);
            //System.out.println(EmpId);

            String ph = reader.getCellData("Sheet1", "Photograph", rowNum);

            String Otherid = reader.getCellData("Sheet1", "Other Id", rowNum);
            //System.out.println(Otherid);

            String DLic = reader.getCellData("Sheet1", "Driver's Lic", rowNum);
            //System.out.println(DLic);

            String LExp = reader.getCellData("Sheet1", "License Exp", rowNum);
            //System.out.println(LExp);

            String Gender = reader.getCellData("Sheet1", "Gender", rowNum);
            //System.out.println(Gender);

            String MStu = reader.getCellData("Sheet1", "Marital Stu", rowNum);
            //System.out.println(MStu);

            String National = reader.getCellData("Sheet1", "Nationality", rowNum);
            //System.out.println(National);

            String DofB = reader.getCellData("Sheet1", "Date of Birth", rowNum);
            //System.out.println(DofB);

            Object ob[] = { fistName, middleName, lastName, EmpId, ph, Otherid, DLic, MStu, National };
            myData.add(ob);
           
        }
        return myData;
    }
}
