package shcedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shcedule.RequestDto.ScheduleSaveRequestDto;
import shcedule.ResponseDto.ScheduleResponseDto;
import shcedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> scheduleSave(@RequestBody ScheduleSaveRequestDto saveRequestDto) {
        ScheduleResponseDto responseDto = scheduleService.scheduleSave(saveRequestDto.getUserId(), saveRequestDto.getTitle(), saveRequestDto.getContents());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        ScheduleResponseDto responseDto = scheduleService.findScheduleById(id);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public List<ScheduleResponseDto> findAll() {

        return scheduleService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> scheduleDelete(@PathVariable Long id) {
        scheduleService.scheduleDelete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
