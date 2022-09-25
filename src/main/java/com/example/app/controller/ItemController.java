package com.example.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5500")
public class ItemController {
	private Map<Integer,String> items;
	
	public ItemController() {
		items = new HashMap<>();
		items.put(1, "バナナ");
		items.put(2, "ぶどう");
		items.put(3, "りんご");
	}
	// 全アイテムのリストを返す
	@GetMapping("/items")
	public Map<Integer, String> list() {
		return items;
	}
	// IDを元に、１つのアイテムを返す
	@GetMapping("/items/{id}")
	public String one(@PathVariable int id) {
		return items.get(id);
	}
	// アイテムを追加する
	@PostMapping("/items")
	public void add(@RequestBody Item item) {
		items.put(item.getId(), item.getName());
	}
	// アイテムを更新する
	@PutMapping("/items/{id}")
	public void update() {
		
	}
	// アイテムを削除する
	@DeleteMapping("/items/{id}")
	public void delete(@PathVariable int id) {
		items.remove(id);
	}
}

@Data
class Item {
	private Integer id;
	private String name;
}
