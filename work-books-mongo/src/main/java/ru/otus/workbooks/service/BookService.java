package ru.otus.workbooks.service;

public interface BookService {
    void printAllInfo();

    void printBook(String name);

    void createBook(String name, long genre, long author);

    void updateBook(String name, long genre, long author);

    void deleteBook(String name);
}
