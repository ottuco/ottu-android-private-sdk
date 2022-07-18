
# OttuCheckout

The OttuCheckout is iOS SDK makes it quick and easy to build an excellent payment experience in your iOS app. We provide powerful and customizable UI screens and elements that can be used out-of-the-box to collect your user's payment details. We also expose the low-level APIs that power those UIs so that you can build fully custom experiences.

## Features

**Simplified security**: We make it simple for you to collect sensitive data such as credit card numbers and remain PCI compliant. This means the sensitive data is sent directly to Stripe instead of passing through your server.

**SCA-ready**: The SDK automatically performs native 3D Secure authentication if needed to comply with Strong Customer Authentication regulation in Europe.

**Native UI**: We provide native screens and elements to collect payment details.

<p float="left">
<img src="https://github.com/sdkpayment/OttuCheckoutAndroidV1/blob/ayush_v1/PayoutScreen.jpg" alt="PaymentUI" align="center"  width="200" height="400"/>
<!-- <img src="https://github.com/Maninder1991/screens/blob/main/WithCardPayment.png" alt="PaymentUI" align="center"  width="200" height="400"/> -->

**Localized**: We support the following localizations: English, Arabic.

#### Privacy

The OttuCheckout SDK collects data to help us improve our products and prevent fraud. This data is never used for advertising and is not rented, sold, or given to advertisers.

## Requirements

The OttuCheckout requires IDE to develop android app. Sdk is compatible with minimum sdk 22 and above.

## Getting started

To initialize the SDK you need to create session token. 
You can create session token with our public API [Click here](https://app.apiary.io/iossdk2/editor) to see more detail about our public API.
    
Installation
==========================

#### Installation with dependecy

Put below dependency into your gradle

```java
allprojects {
  repositories {
	...
	maven { url 'https://jitpack.io' }
  }
}
    
dependencies {
       implementation 'com.github.sdkpayment:OttuCheckoutAndroidV1:1.0.5'
}
```

Below is the sample code of how you can use Ottu Payment SDK.

```java
	
  OttuPaymentSdk ottuPaymentSdk = new OttuPaymentSdk(MainActivity.this);
                        ottuPaymentSdk.setApiId("Api_Id");
                        ottuPaymentSdk.setMerchantId("Merchant_Id");
                        ottuPaymentSdk.setSessionId("Session_id"); // Retrive from public API
                        ottuPaymentSdk.setAmount("100.00"); // String Value
                        ottuPaymentSdk.setLocal("en"); // en or ar
                        ottuPaymentSdk.build();
	
```

Get payment result in onActivityResult menthod in Activity.
	
```java
	  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK ){
            if (requestCode == OttuPaymentResult ){
                SocketRespo paymentResult = (SocketRespo) data.getSerializableExtra("paymentResult");
                textView.setText(paymentResult.status);
	        textView.setText(paymentResult.message);
	        textView.setText(paymentResult.order_no);
	        textView.setText(paymentResult.operation);
            }

        }
    }
	
```

## Licenses

- [OttuCheckout License](LICENSE)
