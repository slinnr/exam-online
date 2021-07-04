package com.mindskip.examonline.viewmodel;

import com.mindskip.examonline.utility.ModelMapperSingle;
import lombok.Data;
import org.modelmapper.ModelMapper;


@Data
public class BaseVM {
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


}
