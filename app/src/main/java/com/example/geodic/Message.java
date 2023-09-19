package com.example.geodic;
import java.util.Date;

public class Message {
    private String Nik;
    private String Text;
    private long timing;

    public  Message(){}
    public Message(String Nik, String Text){
        this.Nik=Nik;
        this.Text=Text;
        this.timing=new Date().getTime();
    }

    public String getNik() {
        return Nik;
    }

    public void setNik(String nik) {
        Nik = nik;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public long getTiming() {
        return timing;
    }

    public void setTiming(long timing) {
        this.timing = timing;
    }
}