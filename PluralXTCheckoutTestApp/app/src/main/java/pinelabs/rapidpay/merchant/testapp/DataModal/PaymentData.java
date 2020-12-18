package pinelabs.rapidpay.merchant.testapp.DataModal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentData {
    @SerializedName("amount")
    @Expose
    public long amountInPaisa;
    @SerializedName("currency_code")
    @Expose
    public String currencyCode;
    @SerializedName("preferred_gateway")
    @Expose
    public String PerferredGateway_value;
    @SerializedName("order_desc")
    @Expose
    public String OrderDesc;
}
