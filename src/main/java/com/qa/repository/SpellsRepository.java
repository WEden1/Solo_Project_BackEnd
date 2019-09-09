package com.qa.repository;

import com.qa.models.Spells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellsRepository extends JpaRepository<Spells, Long> {


}
