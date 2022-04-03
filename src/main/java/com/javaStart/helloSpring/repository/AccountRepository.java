package com.javaStart.helloSpring.repository;

import com.javaStart.helloSpring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
