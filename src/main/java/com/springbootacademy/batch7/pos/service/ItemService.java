package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveReaquestDTO;
import com.springbootacademy.batch7.pos.dto.request.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch7.pos.dto.respoase.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveReaquestDTO itemSaveReaquestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusMapstruct(String itemName);

    List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
