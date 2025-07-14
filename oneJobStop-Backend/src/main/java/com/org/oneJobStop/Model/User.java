package com.org.oneJobStop.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity  //showing its a table
@Data   // for getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder  // it used to create a object without remembering the order .useBilder() like this
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false)
    private String name;
    @Column( unique = true, nullable = false)
    private String email;
    @Column( nullable = false)
    private String password;

    private String role;

    private boolean isVerified;

    private String phoneNo;

    private String otp;

    private LocalDateTime loginTime;
}
