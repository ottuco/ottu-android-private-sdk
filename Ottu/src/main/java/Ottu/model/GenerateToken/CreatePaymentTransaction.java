package Ottu.model.GenerateToken;

import java.io.Serializable;
import java.util.List;

public class CreatePaymentTransaction implements Serializable {
    public String type;

    public List<String> pg_codes;

    public String amount;

    public String currency_code;

    public String disclosure_url;

    public String redirect_url;

    public String customer_id;
    public String customer_phone;

    public String expiration_time;

    public CreatePaymentTransaction(String type, List<String> pg_codes, String amount, String currency_code, String disclosure_url, String redirect_url, String customer_id,String customer_phone, String expiration_time) {
        this.type = type;
        this.pg_codes = pg_codes;
        this.amount = amount;
        this.currency_code = currency_code;
        this.disclosure_url = disclosure_url;
        this.redirect_url = redirect_url;
        this.customer_id = customer_id;
        this.customer_phone = customer_phone;
        this.expiration_time = expiration_time;
    }
    public CreatePaymentTransaction(String type,  String amount, String currency_code, String disclosure_url, String redirect_url, String customer_id,String customer_phone, String expiration_time) {
        this.type = type;
        this.amount = amount;
        this.currency_code = currency_code;
        this.disclosure_url = disclosure_url;
        this.redirect_url = redirect_url;
        this.customer_id = customer_id;
        this.customer_phone = customer_phone;
        this.expiration_time = expiration_time;

    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setPg_codes(List<String> pg_codes){
        this.pg_codes = pg_codes;
    }
    public List<String> getPg_codes(){
        return this.pg_codes;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }
    public String getAmount(){
        return this.amount;
    }
    public void setCurrency_code(String currency_code){
        this.currency_code = currency_code;
    }
    public String getCurrency_code(){
        return this.currency_code;
    }
    public void setDisclosure_url(String disclosure_url){
        this.disclosure_url = disclosure_url;
    }
    public String getDisclosure_url(){
        return this.disclosure_url;
    }
    public void setRedirect_url(String redirect_url){
        this.redirect_url = redirect_url;
    }
    public String getRedirect_url(){
        return this.redirect_url;
    }
    public void setCustomer_id(String customer_id){
        this.customer_id = customer_id;
    }
    public String getCustomer_id(){
        return this.customer_id;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setExpiration_time(String expiration_time){
        this.expiration_time = expiration_time;
    }
    public String getExpiration_time(){
        return this.expiration_time;
    }
}