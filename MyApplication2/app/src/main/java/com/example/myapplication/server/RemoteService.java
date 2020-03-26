package com.example.myapplication.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RemoteService extends Service {

    //图书列表
    private List<Book> mBookList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("abc","servece=====start");
        mBookList=new ArrayList<>();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IBookManager.Stub() {
            @Override
            public List<Book> getBookList() throws RemoteException {
                Log.e("abc","getBookList=book="+mBookList.toString());
                return mBookList;
            }

            @Override
            public void addBook(Book book) throws RemoteException {
                Log.e("abc","add=book="+book.toString());
               mBookList.add(book);
            }

            @Override
            public void test(String name) throws RemoteException {
                Log.e("abc","name="+name);
            }

            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }
        };
    }



}
