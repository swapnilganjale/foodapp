package com.app.foodordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.app.foodordering.model.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

}
