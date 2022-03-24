package com.juint.mockit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juint.mockit.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
