package me.szkristof.szakibuszapi.repositories;

import me.szkristof.szakibuszapi.models.TicketTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used to access the ticket_transactions table in the database.
 */
@Repository
public interface TicketTransactionRepository extends JpaRepository<TicketTransactions, Long> { }
