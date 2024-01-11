package com.project.crewz.local;

import com.project.crewz.common.db.dto.LocalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/local")
public class LocalRestController {
    private final LocalService localService;

    @GetMapping("/list")
    public ResponseEntity<List<LocalDto>> list(@RequestParam("no") int no) {
        List<LocalDto> list = null;

        int min = (no == 1 ? 1 : no == 2 ? 6 : no == 3 ? 11 : no == 4 ? 16 : -1);
        int max = (no == 1 ? 5 : no == 2 ? 10 : no == 3 ? 15 : no == 4 ? 17 : -1);

        list = localService.getAllByNo(min, max);
        if(list.size() == 2) {
            list.add(new LocalDto());
            list.add(new LocalDto());
            list.add(new LocalDto());
        }
        System.out.println("no: " + no + " / size: " + list.size());

        if(list.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
