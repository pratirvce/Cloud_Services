package org.akhila.cloudservices.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductLine {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private Object image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }
}
