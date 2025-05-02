package com.example.greeting;

import java.util.List;

public interface StaffService {
    List<classStaff> getAllStaff();
    classStaff getStaffById(Long id);
    classStaff createStaff(classStaff staff);
    classStaff updateStaff(Long id, classStaff updatedStaff);
    boolean deleteStaff(Long id);
}
