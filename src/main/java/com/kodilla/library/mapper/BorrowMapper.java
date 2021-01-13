package com.kodilla.library.mapper;

import com.kodilla.library.domain.Borrow;
import com.kodilla.library.domain.BorrowDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowMapper {
    public Borrow mapToBorrow(final BorrowDto borrowDto) {
        return new Borrow(
                borrowDto.getId(),
                borrowDto.getId_copy(),
                borrowDto.getId_reader(),
                borrowDto.getReturned());
    }

    public BorrowDto mapToBorrowDto(final Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getId_copy(),
                borrow.getId_reader(),
                borrow.getReturned());
    }

    public List<BorrowDto> mapToBorrowDtoList(final List<Borrow> borrowList) {
        return borrowList.stream()
                .map(t -> new BorrowDto(t.getId(), t.getId_copy(), t.getId_reader(), t.getReturned()))
                .collect(Collectors.toList());
    }

}