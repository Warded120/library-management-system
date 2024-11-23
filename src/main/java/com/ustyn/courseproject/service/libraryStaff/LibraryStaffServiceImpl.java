package com.ustyn.courseproject.service.libraryStaff;

import com.ustyn.courseproject.document.library.LibraryStaff;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryStaffServiceImpl implements LibraryStaffService {
    @Override
    public LibraryStaff save(LibraryStaff libraryStaff) {
        return null;
    }

    @Override
    public List<LibraryStaff> findAll() {
        return List.of();
    }

    @Override
    public LibraryStaff findById(ObjectId id) {
        return null;
    }

    @Override
    public void deleteById(ObjectId id) {

    }
}
