package com.fligth.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fligth.app.entities.Fligth;
import com.fligth.app.repositores.FligthRepository;

@ExtendWith(MockitoExtension.class)
class FligthServiceImplTest {

    @Mock
    private FligthRepository fligthRepository;

    @InjectMocks
    private FligthServiceImpl fligthService;

    @Test
    void findAll_returnsRepositoryList() {
        Fligth fligth = new Fligth();
        fligth.setId(1L);
        when(fligthRepository.findAll()).thenReturn(List.of(fligth));

        List<Fligth> result = fligthService.findAll();

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(fligthRepository).findAll();
    }

    @Test
    void findById_returnsOptionalFromRepository() {
        Fligth fligth = new Fligth();
        fligth.setId(5L);
        when(fligthRepository.findById(5L)).thenReturn(Optional.of(fligth));

        Optional<Fligth> result = fligthService.findById(5L);

        assertTrue(result.isPresent());
        assertEquals(5L, result.get().getId());
        verify(fligthRepository).findById(5L);
    }
}
