package com.ustyn.courseproject.service.literature;

import com.ustyn.courseproject.entity.literature.Literature;
import com.ustyn.courseproject.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureServiceImpl implements LiteratureService {

    private final LiteratureRepository literatureRepository;

    @Autowired
    public LiteratureServiceImpl(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }

    @Override
    public Literature save(Literature literature) {
        return literatureRepository.save(literature);
    }

    @Override
    public boolean existsByTitle(String title) {
        return literatureRepository.existsByTitle(title);
    }

    @Override
    public List<Literature> findAll() {
        return literatureRepository.findAll();
    }

    @Override
    public Literature findByTitle(String title) {
        return literatureRepository.findByTitle(title);
    }
}
