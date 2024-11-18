package com.ustyn.courseproject.service;

import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyServiceImpl implements KeyService {

    KeyRepository keyRepository;

    @Autowired
    public KeyServiceImpl(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    @Override
    public Key save(Key key) {
        if (!key.getPassword().contains("{noop}")) {
            key.setPassword("{noop}" + key.getPassword());
        }
        return keyRepository.save(key);

    }

    @Override
    public void delete(Key key) {
        keyRepository.delete(key);
    }
}
