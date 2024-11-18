package com.ustyn.courseproject.service;

import com.ustyn.courseproject.entity.user.Key;

public interface KeyService {
    Key save(Key key);
    void delete(Key key);
}
