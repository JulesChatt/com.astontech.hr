package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/24/2017.
 */
public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementTypeName);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    //custom repo methods

    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    List<ElementType>findAllByElementTypeNameIgnoreCase(String elementTypeName);

}
