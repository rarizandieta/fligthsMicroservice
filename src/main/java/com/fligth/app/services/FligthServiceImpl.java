package com.fligth.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fligth.app.entities.Fligth;
import com.fligth.app.repositores.FligthRepository;

@Service
public class FligthServiceImpl implements FligthService {

    @Autowired
    private FligthRepository fligthRepository;

    @Override
    public List<Fligth> findAll() {
        List<Fligth> fligths = fligthRepository.findAll();
        System.out.println("fligths------------------------: " + fligths.size());
        return fligths;
    }

    @Override
    public Optional<Fligth> findById(Long id) {
        return fligthRepository.findById(id);
    }

}
