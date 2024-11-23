package com.ustyn.courseproject.service.library;

import com.ustyn.courseproject.document.library.Library;
import com.ustyn.courseproject.repository.LibraryRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library findById(ObjectId id) {
        return libraryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(ObjectId id) {
        libraryRepository.deleteById(id);
    }
}
