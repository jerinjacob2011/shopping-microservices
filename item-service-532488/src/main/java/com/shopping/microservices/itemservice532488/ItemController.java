package com.shopping.microservices.itemservice532488;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("service2/itemName/{itemName}")
	public Item getItemByName(@PathVariable String itemName) {
		return itemRepository.findByItemName(itemName);
	}
	
	@GetMapping("service2/items")
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}
}
