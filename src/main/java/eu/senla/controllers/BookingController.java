package eu.senla.controllers;

import eu.senla.api.services.BookingService;
import eu.senla.controllers.response.ResponseBody;
import eu.senla.dto.BookingDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Booking;
import eu.senla.model.enums.sort.BookingSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("order1s")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("create")
    public ResponseEntity<BookingDto> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.create(booking), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateBooking(Booking booking) throws EntityNotFoundException {
        bookingService.update(booking);
        return ResponseBody.successOperation();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws EntityNotFoundException {
        bookingService.delete(id);
        return ResponseBody.successOperation();
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(bookingService.get(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BookingDto>> getOrders(){
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("sort")
    public ResponseEntity<List<BookingDto>> getSortedBookings(@RequestParam("key") BookingSortType sortType){
        return new ResponseEntity<>(bookingService.getSortedBookings(sortType), HttpStatus.OK);
    }

    @GetMapping("money")
    public ResponseEntity<Double> getEarnedMoneyForTimePeriod(@RequestParam LocalDate date){
        return new ResponseEntity<>(bookingService.getEarnedMoneyForTimePeriod(date), HttpStatus.OK);
    }

    @GetMapping("completed/number")
    public ResponseEntity<Integer> getCountOfCompletedBookingsForTimePeriod(@RequestParam LocalDate date){
        return new ResponseEntity<>(bookingService.GetCountOfCompletedBookingsForTimePeriod(date), HttpStatus.OK);
    }

    @GetMapping("new")
    public ResponseEntity<List<BookingDto>> getNewBookings(){
        return new ResponseEntity<>(bookingService.getNewBookings(), HttpStatus.OK);
    }
}
