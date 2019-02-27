//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.26 at 05:36:24 PM EST 
//


package com.example.response;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceFile" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/>
 *         &lt;element name="StartLine" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EndLine" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StartColumn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EndColumn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Explanation" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="primary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType", propOrder = {
        "sourceFile",
        "startLine",
        "endLine",
        "startColumn",
        "endColumn",
        "explanation"
})
public class LocationType {

    @XmlElement(name = "SourceFile", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sourceFile;
    @XmlElement(name = "StartLine")
    protected Integer startLine;
    @XmlElement(name = "EndLine")
    protected Integer endLine;
    @XmlElement(name = "StartColumn")
    protected Integer startColumn;
    @XmlElement(name = "EndColumn")
    protected Integer endColumn;
    @XmlElement(name = "Explanation")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String explanation;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "primary", required = true)
    protected boolean primary;

    /**
     * Gets the value of the sourceFile property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceFile() {
        return sourceFile;
    }

    /**
     * Sets the value of the sourceFile property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceFile(String value) {
        this.sourceFile = value;
    }

    /**
     * Gets the value of the startLine property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartLine() {
        return startLine;
    }

    /**
     * Sets the value of the startLine property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartLine(Integer value) {
        this.startLine = value;
    }

    /**
     * Gets the value of the endLine property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEndLine() {
        return endLine;
    }

    /**
     * Sets the value of the endLine property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEndLine(Integer value) {
        this.endLine = value;
    }

    /**
     * Gets the value of the startColumn property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartColumn() {
        return startColumn;
    }

    /**
     * Sets the value of the startColumn property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartColumn(Integer value) {
        this.startColumn = value;
    }

    /**
     * Gets the value of the endColumn property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEndColumn() {
        return endColumn;
    }

    /**
     * Sets the value of the endColumn property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEndColumn(Integer value) {
        this.endColumn = value;
    }

    /**
     * Gets the value of the explanation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Sets the value of the explanation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExplanation(String value) {
        this.explanation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the primary property.
     * 
     */
    public boolean isPrimary() {
        return primary;
    }

    /**
     * Sets the value of the primary property.
     * 
     */
    public void setPrimary(boolean value) {
        this.primary = value;
    }

}
