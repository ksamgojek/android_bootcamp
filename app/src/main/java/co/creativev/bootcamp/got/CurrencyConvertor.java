package co.creativev.bootcamp.got;

/**
 * Created by korneliussamuel on 2/29/16.
 */
public class CurrencyConvertor {
    private int convertedValue;
    public static int IDR_TO_INR_CONVERSION_RATE = 200;

    public int convertCurrency(int amount, String currency) {
        if(currency == "INR"){
            convertedValue = amount * IDR_TO_INR_CONVERSION_RATE;
        }
        else if(currency == "IDR"){
            convertedValue = amount / IDR_TO_INR_CONVERSION_RATE;
        }
        return convertedValue;

    }
    public String tes(){
        return "tes";
    }

}
