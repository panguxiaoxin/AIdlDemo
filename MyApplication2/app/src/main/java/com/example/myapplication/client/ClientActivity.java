package com.example.myapplication.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.server.Book;
import com.example.myapplication.server.IBookManager;

import java.util.List;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Button add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook(v);
            }
        });
        final Button get=findViewById(R.id.get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBookList(v);
            }
        });

        final Button start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(v);
            }
        });
    }

    IBookManager bookManager;
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookManager=IBookManager.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 绑定服务
     *
     * @param view
     */
    public void bindService(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.myapplication.server.RemoteService");
        intent.setPackage("com.example.myapplication");
        startService(intent);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }
    /**
     * 添加图书
     *
     * @param view
     */
    public void addBook(View view) {
        try {
            Book book=new Book(1, "Android","tom");
            bookManager.addBook(book);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取图书列表
     *
     * @param view
     */
    public void getBookList(View view) {
        try {
            List<Book> books = bookManager.getBookList();
            Log.e("znh", "books:" + books.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}


