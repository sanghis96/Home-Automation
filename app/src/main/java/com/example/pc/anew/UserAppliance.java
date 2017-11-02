package com.example.pc.anew;

/**
 * Created by kanak on 26-10-2017.
 */

public class UserAppliance
{
    private int uid;
    private String status="off";
    private String addappliance;

    public UserAppliance()
    {

    }


    public UserAppliance(int uid,String addappliance)
    {
        this.uid = uid;
        this.addappliance = addappliance;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getAddappliance()
    {
        return addappliance;
    }
}
