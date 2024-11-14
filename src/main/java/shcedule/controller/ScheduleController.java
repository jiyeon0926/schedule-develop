package shcedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shcedule.RequestDto.ScheduleSaveRequestDto;
import shcedule.RequestDto.ScheduleUpdateRequestDto;
import shcedule.ResponseDto.ScheduleResponseDto;
import shcedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> scheduleSave(@Validated @RequestBody ScheduleSaveRequestDto saveRequestDto) {
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

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> scheduleUpdate(@PathVariable Long id,
                                                              @Validated @RequestBody ScheduleUpdateRequestDto updateRequestDto) {
        ScheduleResponseDto responseDto = scheduleService.scheduleUpdate(id, updateRequestDto.getTitle(), updateRequestDto.getContents());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
