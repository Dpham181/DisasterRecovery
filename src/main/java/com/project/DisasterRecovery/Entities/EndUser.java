package com.project.DisasterRecovery.Entities;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class EndUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer User_Id;
    @Column
    @NonNull
    private String email;
    @Column
    @NonNull
    private String password;


}
