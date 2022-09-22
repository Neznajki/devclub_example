package com.devclub.presentaiton.contract;

import com.devclub.presentaiton.dto.FormDTO;

public interface ContainsInputInterface {
    boolean containsInputInForm(WebFormListInterface webForm, FormDTO formDTO);
}
