package com.springbootacademy.batch7.pos.util.mappers;


import com.springbootacademy.batch7.pos.dto.request.ItemSaveReaquestDTO;
import com.springbootacademy.batch7.pos.dto.respoase.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface   ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList (List<Item> itemList);

    ItemGetResponseDTO entityToDto (Item item);
    Item dtoToEntity (ItemSaveReaquestDTO itemGetResponseDTO);

    List <ItemGetResponseDTO>ListDTOToPage(Page<Item> items);
}
