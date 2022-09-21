package com.devclub.presentaiton.contract;

import com.devclub.presentaiton.dto.FormDTO;

public interface ContainsInputInterface {
    boolean containsInputInForm(WebFormInterface webForm, FormDTO formDTO);
}
