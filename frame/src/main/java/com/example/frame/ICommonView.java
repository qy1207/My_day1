package com.example.frame;

public interface ICommonView<V> {
    void onSuccess(V...a );
    void onFailed(String str);
}
