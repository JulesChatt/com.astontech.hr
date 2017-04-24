package com.astontech.hr.domain.VO;

/**
 * Created by Julian.Chatterton on 3/27/2017.
 */
public class ElementVO {

    private String newElementType;
    private String newElements;
    private String[] newElementArray;


    //region CONSTRUCTORS
    public ElementVO() {

    }
    //endregion

    //region CUSTOM METHODS
    public void splitNewElementsIntoArray() {
        //regex for splitting on a new line or carriage return is "\\r?\\n"
        this.newElementArray = this.newElements.split("\\r?\\n");

    }
    //endregion

    //region GETTERS AND SETTERS

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }

    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }
    //endregion
}
