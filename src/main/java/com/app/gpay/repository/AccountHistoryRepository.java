package com.app.gpay.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gpay.model.AccountHistory;
@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistory,Integer>{
public List<AccountHistory> findTop10ByFromPhoneNumberOrToPhoneNumberOrderByTransactionTimeDesc(Long id,Long sid);
}
