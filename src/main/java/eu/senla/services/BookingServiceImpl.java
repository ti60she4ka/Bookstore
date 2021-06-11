package eu.senla.services;

import eu.senla.api.repositories.BookingRepository;
import eu.senla.api.services.BookingService;
import eu.senla.dto.BookingDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Booking;
import eu.senla.model.enums.sort.BookingSortType;
import eu.senla.model.enums.status.BookingStatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingDto create(Booking entity) {
        entity.getBooks().forEach(book -> book.getBookings().add(entity));
        Booking booking = bookingRepository.save(entity);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    public void update(Booking entity) throws EntityNotFoundException {
        Long id = entity.getId();
        bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("booking", id));
        bookingRepository.save(entity);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("booking", id));
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDto get(Long id) throws EntityNotFoundException {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("booking", id));
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    public List<BookingDto> getAll() {
        return modelMapper.map(bookingRepository.findAll(), new TypeToken<List<BookingDto>>(){}.getType());
    }

    @Override
    public List<BookingDto> getSortedBookings(BookingSortType sortType) {
        return sortOrders(sortType, bookingRepository.findAll());
    }

    @Override
    public List<BookingDto> getSortedCompletedBookings(BookingSortType sortType) {
        return sortOrders(sortType, bookingRepository.getBookingsByStatusEquals(BookingStatus.COMPLETED));
    }

    private List<BookingDto> sortOrders(BookingSortType sortType, List<Booking> bookings){
        List<Booking> sortedBookings = null;

        switch (sortType) {
            case BY_EXECUTION_DATE: {
                sortedBookings = bookings.stream()
                        .sorted(Comparator.comparing(Booking::getExecutionDate))
                        .collect(Collectors.toList());
            }
            case BY_PRICE: {
                sortedBookings = bookings.stream()
                        .sorted(Comparator.comparing(Booking::getPrice))
                        .collect(Collectors.toList());
            }
            case BY_STATUS:{
                sortedBookings = bookings.stream()
                        .sorted(Comparator.comparing(Booking::getStatus))
                        .collect(Collectors.toList());
            }
            case BY_DELIVERY_DATE: {
                sortedBookings = bookings.stream()
                        .sorted(Comparator.comparing(Booking::getDeliveryDate))
                        .collect(Collectors.toList());
            }
        }

        return modelMapper.map(sortedBookings, new TypeToken<List<BookingDto>>(){}.getType());
    }

    @Override
    public Double getEarnedMoneyForTimePeriod(LocalDate date) {
        Double earnedMoney = (double) 0;
        List<Booking> completedBookings = bookingRepository.getBookingsByStatusEquals(BookingStatus.COMPLETED);
        List<Booking> bookings = completedBookings.stream()
                .filter(order -> order.getExecutionDate().isBefore(date))
                .collect(Collectors.toList());
        for (Booking booking : bookings){
            earnedMoney += booking.getPrice();
        }
        return earnedMoney;
    }

    @Override
    public Integer GetCountOfCompletedBookingsForTimePeriod(LocalDate date) {
        List<Booking> completedBookings = bookingRepository.getBookingsByStatusEquals(BookingStatus.COMPLETED);
        List<Booking> bookings = completedBookings.stream()
                .filter(order -> order.getExecutionDate().isBefore(date))
                .collect(Collectors.toList());
        return bookings.size();
    }

    @Override
    public List<BookingDto> getNewBookings() {
        List<Booking> bookings = bookingRepository.getBookingsByStatusEquals(BookingStatus.NEW);
        return modelMapper.map(bookings, new TypeToken<List<BookingDto>>(){}.getType());
    }
}
