package com.bank_ms_transfer.repository;

import com.bank_ms_transfer.entity.CardToAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardToAccountRepository extends JpaRepository<CardToAccountEntity, String> {

}
