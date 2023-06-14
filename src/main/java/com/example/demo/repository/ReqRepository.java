package com.example.demo.repository;

import com.example.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReqRepository extends JpaRepository<Request, Long> {
      List<Request> findAllByHandledEquals(boolean handled);
}
