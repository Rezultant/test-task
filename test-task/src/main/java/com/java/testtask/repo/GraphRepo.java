package com.java.testtask.repo;

import com.java.testtask.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepo extends JpaRepository<Graph,Long> {

}
