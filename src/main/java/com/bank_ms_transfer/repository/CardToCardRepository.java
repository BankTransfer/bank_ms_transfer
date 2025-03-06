package com.bank_ms_transfer.repository;

import com.bank_ms_transfer.entity.CardToCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardToCardRepository extends JpaRepository<CardToCardEntity, String> {

}