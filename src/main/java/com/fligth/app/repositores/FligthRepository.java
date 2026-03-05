package com.fligth.app.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fligth.app.entities.Fligth;

public interface FligthRepository extends JpaRepository<Fligth, Long> {

}
