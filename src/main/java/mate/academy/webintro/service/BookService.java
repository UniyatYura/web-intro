package mate.academy.webintro.service;

import java.util.List;
import mate.academy.webintro.dto.BookDto;
import mate.academy.webintro.dto.BookSearchParameters;
import mate.academy.webintro.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    List<BookDto> getAllByName(String name);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters bookSearchParameters);

    BookDto update(Long id, CreateBookRequestDto createBookRequestDto);
}
