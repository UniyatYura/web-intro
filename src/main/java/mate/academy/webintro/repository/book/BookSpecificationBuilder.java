package mate.academy.webintro.repository.book;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.BookSearchParameters;
import mate.academy.webintro.model.Book;
import mate.academy.webintro.repository.SpecificationBuilder;
import mate.academy.webintro.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {

    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = Specification.where(null);
        if (bookSearchParameters.getAuthors() != null
                && bookSearchParameters.getAuthors().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider("author")
                    .getSpecification(bookSearchParameters.getAuthors()));
        }
        if (bookSearchParameters.getTitles() != null
                && bookSearchParameters.getTitles().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider("title")
                    .getSpecification(bookSearchParameters.getTitles()));
        }
        if (bookSearchParameters.getPrices() != null
                && bookSearchParameters.getPrices().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider("price")
                    .getSpecification(bookSearchParameters.getPrices()));
        }
        return specification;
    }
}
