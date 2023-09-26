package mate.academy.webintro.dto;

import lombok.Data;

@Data
public class BookSearchParameters {
    private String[] titles;
    private String[] authors;
    private String[] prices;
}
