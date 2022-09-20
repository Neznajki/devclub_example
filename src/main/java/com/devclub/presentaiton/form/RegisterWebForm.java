package com.devclub.presentaiton.form;

import com.devclub.presentaiton.collection.NavContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.contract.WebFormInterface;
import com.devclub.presentaiton.input.*;

import java.util.ArrayList;
import java.util.List;

public class RegisterWebForm  implements WebFormInterface {
    public static final String FORM_ID = "registerForm";
    private final List<SingleInputInterface> list = new ArrayList<>();

    public RegisterWebForm() {
        list.add(new FirstNameInput());
        list.add(new LastNameInput());
        list.add(new EmailInput());
        list.add(new PasswordInput());
        list.add(new PasswordRepeatInput());
    }

    @Override
    public List<SingleInputInterface> getFieldList() {
        return list;
    }

    @Override
    public String getId() {
        return FORM_ID;
    }

    @Override
    public String getLabel() {
        return "Register Form";
    }

    @Override
    public String getLink() {
        return this.getId();
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new NavContentReplaceCollection(this);
    }
}
