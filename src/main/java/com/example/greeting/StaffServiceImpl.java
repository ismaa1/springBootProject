package com.example.greeting;




import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffServiceImpl implements StaffService {

    private final Map<Long, classStaff> staffMap = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public List<classStaff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    @Override
    public classStaff getStaffById(Long id) {
        return staffMap.get(id);
    }

    @Override
    public classStaff createStaff(classStaff staff) {
        staff.setId(currentId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    @Override
    public classStaff updateStaff(Long id, classStaff updatedStaff) {
        if (!staffMap.containsKey(id)) return null;
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    @Override
    public boolean deleteStaff(Long id) {
        return staffMap.remove(id) != null;
    }
}

