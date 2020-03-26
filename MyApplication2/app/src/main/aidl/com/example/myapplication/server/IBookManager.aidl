// IBookManager.aidl
package com.example.myapplication.server;

// Declare any non-default types here with import statements
import com.example.myapplication.server.Book;

interface IBookManager {
 /**
     * 获取图书列表
     */
    List<Book> getBookList();

    /**
     * 添加图书
     */
    void addBook(in Book book);
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     void test(String name);
         /**
          * Demonstrates some basic types that you can use as parameters
          * and return values in AIDL.
          */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
