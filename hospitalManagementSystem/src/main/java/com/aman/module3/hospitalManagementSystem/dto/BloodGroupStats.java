package com.aman.module3.hospitalManagementSystem.dto;

import com.aman.module3.hospitalManagementSystem.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
