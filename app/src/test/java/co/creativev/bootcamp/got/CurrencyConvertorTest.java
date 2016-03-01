package co.creativev.bootcamp.got;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConvertorTest {

    @Test
    public void testConvertCurrency1(){
        CurrencyConvertor convertor = new CurrencyConvertor();
        int convertedAmount = convertor.convertCurrency(1, "INR");

        assertEquals(200, convertedAmount);
//        assertEquals(20, convertedAmount);
    }

    @Test
    public void testConvertCurrency2(){
        CurrencyConvertor convertor = new CurrencyConvertor();
        int convertedAmount = convertor.convertCurrency(200, "IDR");

        assertEquals(1, convertedAmount);
//        assertEquals(10, convertedAmount);
    }



}
