package com.devclub.presentaiton.contract;

import com.devclub.presentaiton.dto.FormDTO;
import com.devclub.presentaiton.valueobject.ResponseItem;

import java.util.List;

public interface SerializerInterface {
    String serializeData(List<ResponseItem> data);
    List<FormDTO> deserializeData(String dataString);
}
