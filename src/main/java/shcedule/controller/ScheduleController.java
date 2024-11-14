package shcedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shcedule.RequestDto.ScheduleSaveRequestDto;
import shcedule.ResponseDto.ScheduleResponseDto;
import shcedule.service.ScheduleService;

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
}
