package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import com.project.demo.sushiCo.entity.BasicEntity;

public abstract class BaseMapper<K extends BasicEntity<?>, T> {

	public abstract K toEntity(T dto);

	public abstract T toDto(K entity);

	public abstract K toUpdate(T dto, K entity);
    public abstract List<K> toEntity(List<T> dtoList) ;
    public abstract List<T> toDto(List<K> entityList) ;
}
