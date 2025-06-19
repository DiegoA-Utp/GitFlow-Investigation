package com.gitflow.gitflowpc1.dao;

import com.gitflow.gitflowpc1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client,Long> {
}
