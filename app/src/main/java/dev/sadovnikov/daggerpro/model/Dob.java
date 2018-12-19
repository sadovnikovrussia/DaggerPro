package dev.sadovnikov.daggerpro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob {
    @SerializedName("dob")
    @Expose
    String date;
    @SerializedName("age")
    @Expose
    String age;

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dob{" +
                "date='" + date + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
