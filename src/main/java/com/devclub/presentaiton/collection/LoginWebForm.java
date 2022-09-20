package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.WebFormInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.input.EmailInput;
import com.devclub.presentaiton.input.PasswordInput;

import java.util.ArrayList;
import java.util.List;

public class LoginWebForm implements WebFormInterface {
    private final List<SingleInputInterface> list = new ArrayList<>();

    public LoginWebForm() {
        list.add(new EmailInput());
        list.add(new PasswordInput());
    }

    @Override
    public List<SingleInputInterface> getFieldList() {
        return list;
    }

    @Override
    public String getId() {
        return "loginForm";
    }

    @Override
    public String getLabel() {
        return "Login Form";
    }

    @Override
    public String getLink() {
        return "login";
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new NavContentReplaceCollection(this);
    }
}
