package org.example.bank.dao;

import org.example.bank.model.Beneficiare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenificiareDao extends JpaRepository<Beneficiare, Integer> {
}
