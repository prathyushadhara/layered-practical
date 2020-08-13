package com.dxctraining.service;

import com.dxctraining.dao.*;
import com.dxctraining.entities.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private IItemDao dao;

    @Override
    public Item findItemById(int id) {
       Item item= dao.findItemById(id);
        return item;
    }


    public Item update(Item item) {
        validate(item);
        item=dao.update(item);
        return item;
    }

    @Override
    public Item save(Item item) {
        validate(item);
        item=dao.save(item);
        return item;
    }

    @Override
    public void remove(int id) {
       dao.remove(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }
}
