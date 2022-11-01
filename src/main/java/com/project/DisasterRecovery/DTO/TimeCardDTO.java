package com.project.DisasterRecovery.DTO;

import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.Entities.TimeCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class TimeCardDTO implements Serializable {
    private TimeCard timeCard;
    private List<Job>  Jobs = new ArrayList<Job>();
    private List<Machine> Machines = new ArrayList<Machine>();

}
