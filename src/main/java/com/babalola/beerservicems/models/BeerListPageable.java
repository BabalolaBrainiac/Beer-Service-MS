package com.babalola.beerservicems.models;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;



public class BeerListPageable extends PageImpl<BeerDTO> {

    public BeerListPageable(List<BeerDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerListPageable(List<BeerDTO> content) {
        super(content);
    }
}
