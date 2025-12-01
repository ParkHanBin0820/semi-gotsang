package com.example.semigotsang.service;
import com.example.semigotsang.dto.ScheduleRequestDto;
import com.example.semigotsang.entity.Schedule;
import com.example.semigotsang.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//DTO란 데이터베이스와 엔티티가 직접 교환하면 id, create값들이 노출될 수 있어 안 좋다.
// 보여줘도 되는 데이터들만 골라서 담아 보낼 수 있다.
// DTO = 통신에만 필요한 데이터를 담음
// Entity = DB에 담을 데이터만 담음

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule createSchedule(ScheduleRequestDto requestDto) {
        // 1. Dto를 Entity로 변환
        Schedule schedule = requestDto.toEntity();

        // 2. Repository를 사용하여 DB에 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return savedSchedule;
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public void deleteSchedule(Long id){
        scheduleRepository.deleteById(id);
    }
}