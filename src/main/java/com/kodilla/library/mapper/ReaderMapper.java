package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getSurname());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getDateOfCardInsertion());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDto(t.getId(), t.getName(), t.getSurname(), t.getDateOfCardInsertion()))
                .collect(Collectors.toList());
    }

}
