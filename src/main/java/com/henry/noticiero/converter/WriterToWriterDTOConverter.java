package com.henry.noticiero.converter;

import com.henry.noticiero.model.Writer;
import com.henry.noticiero.model.dto.WriterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WriterToWriterDTOConverter implements Converter<Writer, WriterDTO> {

 private final ModelMapper modelMapper;

 public WriterToWriterDTOConverter( final ModelMapper modelmapper){
     this.modelMapper = modelmapper;
 }

 @Override
    public WriterDTO convert(Writer source){
     return modelMapper.map(source, WriterDTO.class);
 }
}
