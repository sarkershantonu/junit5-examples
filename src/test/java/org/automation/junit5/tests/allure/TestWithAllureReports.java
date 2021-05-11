package org.automation.junit5.tests.allure;

import io.qameta.allure.*;
import org.automation.junit5.core.CalculatorTestBase;
import org.automation.junit5.core.ScreenShotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by shantonu on 3/29/2021
 */
@Epic("We Need to Develop A calculator")
@Feature("Adding two values")
@Story("An User should be able to perform calculator operations ")
@Owner("shantonu")
@Issues({@Issue("WW-22"),@Issue("WW-21"),@Issue("WW-23")})
@Links({ @Link(name = "RQ-1", url="https://www.programiz.com/c-programming/examples/add-numbers",type = "Trello"),
        @Link(name = "RQ-2", url="https://www.programiz.com/c-programming/examples/product-numbers",type = "Trello")})
@Severity(SeverityLevel.NORMAL)
@TmsLinks({@TmsLink("tc-257"), @TmsLink("tc-258"), @TmsLink("tc-256")})
public class TestWithAllureReports extends CalculatorTestBase {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Adding two int ")
    @Lead("shantonu.sarker")
    @Story("An User should be able to add two numbers")
    @Issue("WW-21")
    @Epic("Adding functionality of Adding two int ")
    @TmsLink("tc-256")
    public void testAdd(){
        assertEquals(30,myCal.add(25,5));
    }

    @Test
    @Epics({@Epic("Adding functionality of Adding two int "),@Epic("A screenshot should be taken when we are adding")})
    @Feature("A  Screenshot present when adding two integers")
    @Owner("shantonu")
    public void testAddWIthScreenshot() throws IOException, AWTException {
        assertEquals(30,myCal.add(25,5));
        ScreenShotUtil.capturePNG();
    }
    @Test
    @Description("Adding two Strings ")
    @Story("An User should be able to add two strings")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddStrings(){
        assertEquals("shantonusarker",myCal.add("shantonu","sarker"));
    }

    @Test
    @Muted
    public void mutedTestExample(){
        Assertions.fail(" A muted test which wont be shown in report");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Adding all items from an int Array")
    @Story("An User should be able to add all items in an array of integers")
    public void testAddIntArray(){
        int[] data = {5,10,25,6,4};
        assertEquals(50,myCal.add(data));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding all items from an Integer Array")
    @Story("An User should be able to add all items in an array of integers")
    @Issue("WW-25")
    @Link(name = "requirements", url="https://www.programiz.com/c-programming/examples/add-numbers",type = "Trello")
    public void testAddIntegerArray(){
        Integer[] data = new Integer[]{5,10,25,6,4};
        assertEquals(50,myCal.add(data));
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Adding two integer & double values")
    @Stories({@Story("An User should be able to add Multi data type numbers (integer & double)"),
            @Story("An User should be able to add integer"),
    @Story("An User should be able to add  double numbers")})
    @Features({@Feature("Addition of two Integer"),
            @Feature("Addition of two Floating point number"),
            @Feature("Adding Integer & Floating point number")})
    @Issues({@Issue("WW-22"),@Issue("WW-23")})
    @TmsLinks({@TmsLink("tc-300"), @TmsLink("tc-301")})
    public void testAddMixType(){
        Double[] data_double = new Double[]{15.0,25.1,4.9};
        Integer[] data_int = new Integer[]{15,5,10};
        assertEquals(45.0,myCal.add(data_double));
        assertEquals(30,myCal.add(data_int));
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Adding two decimal values")
    @Flaky
    @Story("An User should be able to add two Decimal Numbers")
    public void testAddDecimal(){
        double a = 2.4, b =5.2;
        assertEquals(7.6, myCal.add(a,b), "double adding ");
    }

    @Test
    @Flaky
    public void flakyTestExample(){
        Assertions.fail("Flaky Test");
    }

}
