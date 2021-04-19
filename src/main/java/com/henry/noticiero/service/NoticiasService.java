package com.henry.noticiero.service;


import com.henry.noticiero.model.Noticias;
import com.henry.noticiero.model.PaginationResponse;
import com.henry.noticiero.model.Writer;
import com.henry.noticiero.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@Service
public class NoticiasService {

    @Autowired
    private NoticiasRepository noticiasRepository;
    private WriterService writerService;

    public NoticiasService(NoticiasRepository noticiasRepository, WriterService writerService){
        this.noticiasRepository = noticiasRepository;
        this.writerService = writerService;
    }

    public Noticias addNoticia(Noticias noticia){
        return noticiasRepository.save(noticia);
    }

    public Noticias getNoticia(Integer id){

        return noticiasRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Noticias> getAllNoticias(){
        return noticiasRepository.findAll();
    }

    public PaginationResponse<Noticias> getAll(Integer page, Integer size){
        if(!Objects.isNull(page) && !Objects.isNull(size)){

            Pageable pageable = PageRequest.of(page, size);
            Page<Noticias> noticiasPage = noticiasRepository.findAll(pageable);

            return new PaginationResponse<>(noticiasPage.getContent(), noticiasPage.getTotalPages(), noticiasPage.getTotalElements());
        }
        List<Noticias> noticiasList = noticiasRepository.findAll();
        return new PaginationResponse<>(noticiasList, 1, (long) noticiasList.size());
    }

    public void addWriter(Integer noticiasID, Integer writerID){
        Noticias noticias = getNoticia(noticiasID);
        Writer writer = writerService.getWriter(writerID);
        noticias.setEscritorDueño(writer);
        noticiasRepository.save(noticias);
    }

    public void deleteWrite(Integer id){
        noticiasRepository.deleteById(id);
    }
}
