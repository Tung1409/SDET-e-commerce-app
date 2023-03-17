package test_data.models;

public class ShippingDataObject {
    private String phone;
    private String shippingAdd1;
    private String shippingAdd2;
    private String city;
    private String zipCode;
    private String country;

    public ShippingDataObject(String phone, String shippingAdd1, String shippingAdd2, String city, String zipCode, String country) {
        this.phone = phone;
        this.shippingAdd1 = shippingAdd1;
        this.shippingAdd2 = shippingAdd2;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public String getShippingAdd1() {
        return shippingAdd1;
    }

    public String getShippingAdd2() {
        return shippingAdd2;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }
}
