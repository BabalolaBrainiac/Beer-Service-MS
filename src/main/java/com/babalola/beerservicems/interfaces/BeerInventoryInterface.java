package com.babalola.beerservicems.interfaces;

import java.util.UUID;

public interface BeerInventoryInterface {
    Integer getOnHandInventory(UUID beerId);
}
