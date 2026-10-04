package com.springboot.redis.repo;


import com.springboot.redis.entity.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
}
