package pinelabs.rapidpay.merchant.testapp.DataModal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingData {
    @SerializedName("address1")
    @Expose
    public String address1;
    @SerializedName("address2")
    @Expose
    public String address2;
    @SerializedName("address3")
    @Expose
    public String address3;
    @SerializedName("pincode")
    @Expose
    public String pincode;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
}
