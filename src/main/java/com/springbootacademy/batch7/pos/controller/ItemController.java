package com.springbootacademy.batch7.pos.controller;



import com.springbootacademy.batch7.pos.dto.request.ItemSaveReaquestDTO;
import com.springbootacademy.batch7.pos.dto.request.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch7.pos.dto.respoase.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.validation.constraints.Max

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;



  /*  @PostMapping
            (

   path = {"/save "}
            )
    public String saveItem(@RequestBody ItemSaveReaquestDTO itemSaveReaquestDTO) {

        String msg = itemService.saveItem(itemSaveReaquestDTO);
        return "saved";
    }
*/


    @PostMapping
            (

   path = {"/save "}
            )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveReaquestDTO itemSaveReaquestDTO) {

        String msg = itemService.saveItem(itemSaveReaquestDTO);
       // ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
              //  new StandardResponse(201 , "Success", msg), HttpStatus.CREATED

       // return response;

       // ResponseEntity responseEntity = null;
       // return responseEntity;

        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(201 , "Success", msg), HttpStatus.CREATED
        );
    }









    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )

    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name")String itemName){

        List <ItemGetResponseDTO> itemGetResponseDTOS =  itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDTOS;
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )

    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name")String itemName){

        List <ItemGetResponseDTO> itemGetResponseDTOS =  itemService.getItemByNameAndStatusMapstruct(itemName);
        return itemGetResponseDTOS;
    }


    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus" , "page" , "size"}
    )

    public ResponseEntity<StandardResponse> getItemsByActiveStatus (
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") /*@Max(50)*/ int size


    ){

       // List <ItemGetResponseDTO> itemDTOS =  itemService.getItemsByActiveStatus(activeStatus);

        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemsByActiveStatusWithPaginated(activeStatus,page,size);

        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(201 , "Success", paginatedResponseItemDTO ), HttpStatus.CREATED
        );
    }

}
