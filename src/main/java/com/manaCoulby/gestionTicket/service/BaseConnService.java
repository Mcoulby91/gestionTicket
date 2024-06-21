package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.BaseConnaissance;
import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Repository.BaseConnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseConnService {
    @Autowired
    public BaseConnRepository BaseConnRepository;
    @Autowired
    private BaseConnRepository baseConnRepository;

    public BaseConnaissance creerBaseConnaissance(BaseConnaissance baseConnaissance) {
        return BaseConnRepository.save(baseConnaissance);
    }

    public List<BaseConnaissance> getAllBaseConnaissance() {
        return BaseConnRepository.findAll();
    }

    public BaseConnaissance findBaseConnaissanceById(int id) {
        return this.BaseConnRepository.findByIdBaseConn(id);
    }

    public BaseConnaissance updateBaseConn(int id, BaseConnaissance baseConnaissance) {
        baseConnaissance.setIdBaseConn(id);
        return this.BaseConnRepository.save(baseConnaissance);

    }

    public void deleteBaseConn(int id) {
        baseConnRepository.deleteById(id);
    }

}
