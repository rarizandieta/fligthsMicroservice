package com.fligth.app.services;

import java.util.List;
import java.util.Optional;

import com.fligth.app.entities.Fligth;

public interface FligthService {

    List<Fligth> findAll();

    Optional<Fligth> findById(Long id);

}
