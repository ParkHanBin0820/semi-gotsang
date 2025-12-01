package com.example.semigotsang.controller;

import com.example.semigotsang.dto.ScheduleRequestDto;
import com.example.semigotsang.entity.Schedule;
import com.example.semigotsang.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Schedule createSchedule = scheduleService.createSchedule(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createSchedule);
    }

    @GetMapping("schedules")
    public ResponseEntity<List<Schedule>> getAllSchedules(){
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok().build();
    }
}