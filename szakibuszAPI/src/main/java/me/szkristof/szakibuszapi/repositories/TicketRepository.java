package me.szkristof.szakibuszapi.repositories;

import me.szkristof.szakibuszapi.models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used to access the ticket table in the database.
 */
@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> { }
