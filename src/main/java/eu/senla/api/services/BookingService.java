package eu.senla.api.services;

import eu.senla.dto.BookDto;
import eu.senla.dto.BookingDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Booking;
import eu.senla.model.enums.sort.BookingSortType;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    BookingDto create(Booking booking);

    void update(Booking booking) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    BookingDto get(Long id) throws EntityNotFoundException;

    List<BookingDto> getAll();

    List<BookingDto> getSortedBookings(BookingSortType sortType);

    List<BookingDto> getSortedCompletedBookings(BookingSortType sortType);

    Double getEarnedMoneyForTimePeriod(LocalDate date);

    Integer GetCountOfCompletedBookingsForTimePeriod(LocalDate date);

    List<BookingDto> getNewBookings();
}
