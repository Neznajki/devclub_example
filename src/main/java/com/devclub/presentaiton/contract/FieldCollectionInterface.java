package com.devclub.presentaiton.contract;

import java.util.List;

public interface FieldCollectionInterface extends SingleNavInterface {
    List<SingleFieldInterface> getFieldList();
    String getId();
}
