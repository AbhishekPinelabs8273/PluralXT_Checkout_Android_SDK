package pinelabs.rapidpay.merchant.testapp.DataModal;


import static pinelabs.rapidpay.merchant.testapp.Contants.EDGE_MERCHANT_ACCESS_CODE;
import static pinelabs.rapidpay.merchant.testapp.Contants.EDGE_MERCHANT_ID;
import static pinelabs.rapidpay.merchant.testapp.Contants.EDGE_PAYMENT_MODE_CARD;

public class CreateRequestForRapidPay {
    AcceptPaymentData acceptPaymentData;
    private AcceptPaymentData setAcceptPaymentData(String txnId)
    {
        acceptPaymentData =new AcceptPaymentData();
        acceptPaymentData.customerData=new CustomerData();
        acceptPaymentData.customerData.emailId="anand@gmail.com";
        acceptPaymentData.customerData.customerId="123";
        acceptPaymentData.customerData.mobileNo="7317553431";
        acceptPaymentData.merchantData=new MerchantData();
        acceptPaymentData.paymentData=new PaymentData();
        acceptPaymentData.billingData=new BillingData();
        acceptPaymentData.billingData.firstName="Anand";
        acceptPaymentData.billingData.lastName="Kumar";
        acceptPaymentData.billingData.address1="Anand";
        acceptPaymentData.billingData.address2="Anand";
        acceptPaymentData.billingData.address3="Anand";
        acceptPaymentData.billingData.city="Anand";
        acceptPaymentData.billingData.state="Anand";
        acceptPaymentData.billingData.country="Anand";

        acceptPaymentData.shippingData=new ShippingData();
        acceptPaymentData.shippingData.firstName="Anand";
        acceptPaymentData.shippingData.lastName="Kumar";
        acceptPaymentData.shippingData.address1="temp";
        acceptPaymentData.shippingData.address2="temp";
        acceptPaymentData.shippingData.address3="temp";
        acceptPaymentData.shippingData.city="temp";
        acceptPaymentData.shippingData.state="temp";
        acceptPaymentData.shippingData.country="temp";
        //Merchant details
        acceptPaymentData.merchantData.merchantId= EDGE_MERCHANT_ID;
        acceptPaymentData.merchantData.merchantAccessCode= EDGE_MERCHANT_ACCESS_CODE;
        acceptPaymentData.merchantData.uniqueMerchantTxnId=txnId;
        acceptPaymentData.merchantData.merchantReturnUrl="https://test.pinepg.in/mobileapp/index";

        //payment details
        acceptPaymentData.paymentData.amountInPaisa=100;
        acceptPaymentData.paymentData.currencyCode="INR";
        acceptPaymentData.paymentData.OrderDesc="TEST_ORDER";
        acceptPaymentData.paymentData.PerferredGateway_value="PayU";
        //txn data
        return acceptPaymentData;
    }
    public AcceptPaymentData getAcceptPaymentData(String txnId) {
        return setAcceptPaymentData(txnId);
    }
}
