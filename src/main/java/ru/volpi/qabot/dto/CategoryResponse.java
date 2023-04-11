package ru.volpi.qabot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -3035758029249383458L;

    private Long id;
    private String name;
    private Set<QuestionResponse> questions;
}
