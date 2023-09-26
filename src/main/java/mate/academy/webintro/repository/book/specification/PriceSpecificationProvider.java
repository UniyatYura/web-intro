package mate.academy.webintro.repository.book.specification;

import java.util.Arrays;
import mate.academy.webintro.model.Book;
import mate.academy.webintro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PriceSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "price";
    }

    public Specification<Book> getSpecification(String[] prices) {
        return (root, query, criteriaBuilder) -> root.get("price")
                .in(Arrays.stream(prices).toArray());
    }
}
