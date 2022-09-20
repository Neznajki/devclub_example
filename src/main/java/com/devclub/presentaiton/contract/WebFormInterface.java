package com.devclub.presentaiton.contract;

import java.util.List;

public interface WebFormInterface extends SingleNavInterface {
    List<SingleInputInterface> getFieldList();
    String getId();
}
