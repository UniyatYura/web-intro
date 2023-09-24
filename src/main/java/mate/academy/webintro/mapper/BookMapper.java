package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.BookDto;
import mate.academy.webintro.dto.CreateBookRequestDto;
import mate.academy.webintro.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);
}
