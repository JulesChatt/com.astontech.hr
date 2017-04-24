package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/24/2017.
 */
public interface ElementService {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);


    //custom repo methods
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);
}
