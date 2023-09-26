package mate.academy.webintro.repository.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.model.Book;
import mate.academy.webintro.repository.SpecificationProvider;
import mate.academy.webintro.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProvider;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProvider.stream().filter(p -> p.getKey().equals(key))
                .findFirst().orElseThrow(() ->
                        new RuntimeException("Can't find correct specification provider for key "
                                + key));
    }
}
