package com.dxctraining.ui;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import com.dxctraining.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ItemUi {
    @Autowired
    private IItemService service;


    @PostConstruct
    public void runUi(){
        try {
            Item item1 = new Item(1,"bingo");
            Item item2 = new Item(2,"biscuits");
            service.save(item1);
            service.save(item2);

            int id1 = item1.getId();
            Item fetched = service.findItemById(id1);
            System.out.println("fetcehd item =" + fetched.getName() + " " + fetched.getId());
            boolean isEquals = item1.equals(item2);
    		
    		System.out.println("is equal=" + isEquals);
   
        }catch (ItemNotFoundException e){
            e.printStackTrace();
        }

        catch (InvaidArgumentException e){
            e.printStackTrace();
        }
    }



}
