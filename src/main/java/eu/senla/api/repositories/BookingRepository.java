package eu.senla.api.repositories;

import eu.senla.model.entities.Booking;
import eu.senla.model.enums.status.BookingStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> getBookingsByStatusEquals(BookingStatus status);
    List<Booking> findAll();
}
