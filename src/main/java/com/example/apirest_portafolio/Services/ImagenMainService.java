package com.example.apirest_portafolio.Services;

import com.example.apirest_portafolio.DTO.DTOimg;
import com.example.apirest_portafolio.Entitys.ImagenMain;
import com.example.apirest_portafolio.Repositorys.ImagenMainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenMainService {

    @Autowired
    private ImagenMainRepository imgMainRepository;

    public ImagenMain addImagen(ImagenMain imagenMain){

        return imgMainRepository.save(imagenMain);
    }

    public List<DTOimg> listImg(){

        List<DTOimg> dtOimgList = new ArrayList<>();

        for(ImagenMain img : imgMainRepository.findAll()){
            DTOimg dtOimg = new DTOimg();
            try{

                dtOimg.setId(img.getId());
                dtOimg.setImg(img.getImg());
                Integer id = img.getProject().getId();
                dtOimg.setIdProject(img.getProject().getId());
            }catch (Exception e){
                dtOimg.setIdProject(null);
            }
            dtOimgList.add(dtOimg);

        }
        return dtOimgList;
    }


}
