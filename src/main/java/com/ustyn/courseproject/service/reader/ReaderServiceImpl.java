package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.reader.Reader;
import com.ustyn.courseproject.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {


    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public boolean existsByName(String name) {
        return readerRepository.existsByName(name);
    }

    @Override
    public Collection<Reader> findAll() {
        return readerRepository.findAll();
    }
}
