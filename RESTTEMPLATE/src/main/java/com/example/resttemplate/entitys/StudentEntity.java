package com.example.resttemplate.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
String email;
String fullname;
Double marks;
Boolean gender;
String country;
}
