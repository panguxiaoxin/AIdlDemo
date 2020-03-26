package com.example.myapplication.server;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book implements Parcelable {
    public int bookId;
    public String bookName;
    public String author;

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
        author=in.readString();
    }

    public Book(int id, String name,String author) {
        this.bookId = id;
        this.bookName = name;
        this.author=author;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
        dest.writeString(author);
    }

    @NonNull
    @Override
    public String toString() {
        return "Book(bookid=" + bookId + "  bookName=" + bookName + "  author=" + author + ")";
    }
}
