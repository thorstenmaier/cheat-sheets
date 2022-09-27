package com.trivadis.spring.user.repository;

import com.trivadis.spring.user.domain.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

}
