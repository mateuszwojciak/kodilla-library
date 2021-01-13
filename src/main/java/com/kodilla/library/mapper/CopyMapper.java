package com.kodilla.library.mapper;

import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.CopyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {
    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getStatus(),
                copyDto.getTitle());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getStatus(),
                copy.getTitle());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(t -> new CopyDto(t.getId(), t.getStatus(), t.getTitle()))
                .collect(Collectors.toList());
    }
}
