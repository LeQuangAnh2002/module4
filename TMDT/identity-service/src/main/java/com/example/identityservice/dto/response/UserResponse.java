package com.example.identityservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserReponse {
    private String id;
    private String username;

    private String password;
    private String firstName;
    private String LastName;
    private LocalDate dob;
}
