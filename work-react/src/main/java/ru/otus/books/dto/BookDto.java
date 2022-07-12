package ru.otus.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.books.entity.Book;

@Data
@AllArgsConstructor
public class BookDto {

    private long id;
    private String name;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName());
    }

    public static Book toDomainObject(BookDto dto) {
        return Book.builder().id(dto.getId()).name(dto.getName()).build();
    }
}
