package com.example.gestor_proyectos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//configuración de spring
@Configuration
public class ModelMapperConfig {


  @Bean
  public ModelMapper modelMapper() {

    return new ModelMapper();
  }
}