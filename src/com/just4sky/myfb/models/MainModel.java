package com.just4sky.myfb.models;

import com.just4sky.myfb.vos.SimpleObservable;

public class MainModel extends SimpleObservable<MainModel>{
    private String name;
    private String button;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers(this);
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
        notifyObservers(this);
    }
}
