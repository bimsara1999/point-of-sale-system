package com.springbootacademy.batch7.pos.dto.request.paginated;


import com.springbootacademy.batch7.pos.dto.respoase.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {

    List<ItemGetResponseDTO> list;
    private long dataCount;
}
