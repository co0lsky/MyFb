package com.just4sky.myfb.vos;

public interface EasyObservable<T> {

    void addListener(OnChangeListener<T> listener);
    void removeListener(OnChangeListener<T> listener);

}
