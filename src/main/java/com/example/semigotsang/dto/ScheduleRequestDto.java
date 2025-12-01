package com.example.semigotsang.dto;
import com.example.semigotsang.entity.Schedule;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String color;

    public Schedule toEntity(){
        return Schedule.builder()
                .title(this.title)
                .content(this.content)
                .startDateTime(this.startDateTime)
                .endDateTime(this.endDateTime)
                .color(this.color)
                .build();
    }
}
