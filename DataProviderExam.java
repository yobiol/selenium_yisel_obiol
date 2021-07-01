package Básico.Examen;

import org.testng.annotations.DataProvider;

public class DataProviderExam {
    @DataProvider (name = "email")
    public Object[][] datosEmail(){
        return new Object[][]{
                {"examenSelenium@gmail.com"},
                {"qaselenium@gmail.com"},
                {"seleniumTesting@gmail.com"},
        };
    }
}
