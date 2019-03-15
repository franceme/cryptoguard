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
 * <p>Java class for BugTraceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BugTraceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AssessmentReportFile" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/>
 *         &lt;element name="InstanceLocation" type="{https://www.swamp.com/com/scarf/struct}InstanceLocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author drmonster
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BugTraceType", propOrder = {
        "buildId",
        "assessmentReportFile",
        "instanceLocation"
})
public class BugTraceType {

    @XmlElement(name = "BuildId")
    protected int buildId;
    @XmlElement(name = "AssessmentReportFile", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String assessmentReportFile;
    @XmlElement(name = "InstanceLocation")
    protected InstanceLocationType instanceLocation;

    /**
     * Gets the value of the buildId property.
     *
     * @return a int.
     */
    public int getBuildId() {
        return buildId;
    }

    /**
     * Sets the value of the buildId property.
     *
     * @param value a int.
     */
    public void setBuildId(int value) {
        this.buildId = value;
    }

    /**
     * Gets the value of the assessmentReportFile property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAssessmentReportFile() {
        return assessmentReportFile;
    }

    /**
     * Sets the value of the assessmentReportFile property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setAssessmentReportFile(String value) {
        this.assessmentReportFile = value;
    }

    /**
     * Gets the value of the instanceLocation property.
     *
     * @return a {@link com.example.response.InstanceLocationType} object.
     */
    public InstanceLocationType getInstanceLocation() {
        return instanceLocation;
    }

    /**
     * Sets the value of the instanceLocation property.
     *
     * @param value
     *     allowed object is
     *     {@link com.example.response.InstanceLocationType}
     */
    public void setInstanceLocation(InstanceLocationType value) {
        this.instanceLocation = value;
    }

}
