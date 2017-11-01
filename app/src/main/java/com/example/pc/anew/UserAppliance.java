package com.example.pc.anew;

/**
 * Created by kanak on 26-10-2017.
 */

public class UserAppliance
{
    private int uid,status=0;
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

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getAddappliance()
    {
        return addappliance;
    }
}
