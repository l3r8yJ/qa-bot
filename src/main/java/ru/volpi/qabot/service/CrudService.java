package ru.volpi.qabot.service;

import java.io.Serializable;
import java.util.List;

public interface CrudService<K extends Serializable, X extends Serializable> {

    K save(K dto);

    K update(X id, K dto);

    X deleteById(X id);

    K findById(X id);

    List<K> findAll();
}
