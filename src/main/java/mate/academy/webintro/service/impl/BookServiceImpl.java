package mate.academy.webintro.service.impl;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.BookDto;
import mate.academy.webintro.dto.CreateBookRequestDto;
import mate.academy.webintro.exception.EntityNotFoundException;
import mate.academy.webintro.mapper.BookMapper;
import mate.academy.webintro.model.Book;
import mate.academy.webintro.repository.BookRepository;
import mate.academy.webintro.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        book.setIsbn("978-966-" + new Random().nextInt(1000));
        Book saveBook = bookRepository.save(book);
        return bookMapper.toDto(saveBook);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id = " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllByName(String name) {
        return bookRepository.findAllByName(name).stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
