package com.example.pc.anew;

import java.util.ArrayList;

/**
 * Created by kanak on 26-10-2017.
 */

public class UserInformation
{

    public String name;
    public String phone;
    public String address;
    public ArrayList<UserAppliance> appliances=new ArrayList<>();
    public UserInformation(String name, String phone, String address)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;

    }

    public UserInformation() {
    }

    public void setUa(UserAppliance ua) {
        appliances.add(ua);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAppliances(ArrayList<UserAppliance> appliances) {
        this.appliances = appliances;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<UserAppliance> getAppliances() {
        return appliances;
    }
}
