package com.kodilla.library.controller;

import com.kodilla.library.domain.CopyDto;
import com.kodilla.library.mapper.CopyMapper;
import com.kodilla.library.service.DbServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/copy")
public class CopyController {
    @Autowired
    private DbServiceCopy dbServiceCopy;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<CopyDto> getCopies() {
        return copyMapper.mapToCopyDtoList(dbServiceCopy.getAllCopies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDto getCopy(@RequestParam Long copyId) throws BookNotFoundException {
        return copyMapper.mapToCopyDto(dbServiceCopy.getCopy(copyId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(@RequestParam Long copyId) {
        dbServiceCopy.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public CopyDto updateCopy(@RequestBody CopyDto copyDto) {
        return copyMapper.mapToCopyDto(dbServiceCopy.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        dbServiceCopy.saveCopy2(copyMapper.mapToCopy(copyDto));
    }
}