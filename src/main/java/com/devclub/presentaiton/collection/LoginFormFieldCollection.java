package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.FieldCollectionInterface;
import com.devclub.presentaiton.contract.SingleFieldInterface;
import com.devclub.presentaiton.field.EmailField;

import java.util.ArrayList;
import java.util.List;

public class LoginFormFieldCollection implements FieldCollectionInterface {
    private final List<SingleFieldInterface> list = new ArrayList<>();

    public LoginFormFieldCollection() {
        list.add(new EmailField());
    }

    @Override
    public List<SingleFieldInterface> getFieldList() {
        return list;
    }

    @Override
    public String getId() {
        return "LoginForm";
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
