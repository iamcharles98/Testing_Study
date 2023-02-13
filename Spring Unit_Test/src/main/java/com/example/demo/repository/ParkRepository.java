package com.example.demo.repository;

import com.example.demo.domain.Park;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ParkRepository{
    private final EntityManager em;
    public Park save(Park park) {
        em.persist(park);
        return park;
    }
    public Optional<Park> findParkInfoById(Long id) {
        List<Park> results = em.createQuery("select p from Park p" +
                        " where p.id =:id", Park.class)
                .setParameter("id", id)
                .getResultList();

        return results.stream().findAny();
    }
    public List<Park> findAll() {
        return em.createQuery("select p from Park p", Park.class).getResultList();
    }


}
