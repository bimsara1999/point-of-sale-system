package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveReaquestDTO;
import com.springbootacademy.batch7.pos.dto.request.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch7.pos.dto.respoase.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Customer;
import com.springbootacademy.batch7.pos.entity.Item;
import com.springbootacademy.batch7.pos.exception.NotFoundException;
import com.springbootacademy.batch7.pos.repo.CustomerRepo;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.mappers.ItemMapper;
import com.sun.jdi.request.DuplicateRequestException;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo ;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemSaveReaquestDTO itemSaveReaquestDTO) {
        

        //Item item = modelMapper.map(itemSaveReaquestDTO, Item.class);

        Item item = itemMapper.dtoToEntity(itemSaveReaquestDTO);
        if(!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + "SAVED SUCCESSFULLY";
        }else {
            throw new DuplicateRequestException("Alredy Added");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        boolean b =true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);

        if (items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items , new TypeToken <List<ItemGetResponseDTO>>(){}.getType());

             return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Not active Found");
        }



    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusMapstruct(String itemName) {

        boolean b =true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);

        if (items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Not active Found");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus) {


        List<Item> items = itemRepo.findAllByActiveStateEqual(activeStatus);

        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("Not active Found");
        }

    }

    @Override
    public PaginatedResponseItemDTO getItemsByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {

        Page<Item> items = itemRepo.findAllByActiveStateEqual(activeStatus, PageRequest.of(page, size));
       // int count = itemRepo.countAllByActiveStateEqual(activeStatus);
        if (items.getSize()<1) {
            throw new NotFoundException("Not data Found");
        }

        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.ListDTOToPage(items),itemRepo.countAllByActiveStateEqual(activeStatus)
        );




        return paginatedResponseItemDTO;

                /*count



        //List<ItemGetResponseDTO> list;
        //private long dataCount;
        return paginatedResponseItemDTO;*/
    }
}

