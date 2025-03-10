package com.bank_ms_transfer.repository;

import com.bank_ms_transfer.entity.AccountToCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountToCardRepository extends JpaRepository<AccountToCardEntity, String> {
}
