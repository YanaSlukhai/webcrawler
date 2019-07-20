package model;

import java.util.Objects;

public final class HtmlElement {
    private final String elementId;
    private final String elementClass;
    private final String elementTitle;
    private final String elementXPath;

    public HtmlElement(String elementId, String elementClass, String elementTitle, String elementXPath) {
        this.elementId = elementId;
        this.elementClass = elementClass;
        this.elementTitle = elementTitle;
        this.elementXPath = elementXPath;
    }

    public String getElementId() {
        return elementId;
    }

    public String getElementClass() {
        return elementClass;
    }

    public String getElementTitle() {
        return elementTitle;
    }

    public String getElementXPath() {
        return elementXPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HtmlElement that = (HtmlElement) o;
        return Objects.equals(getElementId(), that.getElementId()) &&
                Objects.equals(getElementClass(), that.getElementClass()) &&
                Objects.equals(getElementTitle(), that.getElementTitle()) &&
                Objects.equals(getElementXPath(), that.getElementXPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElementId(), getElementClass(), getElementTitle(), getElementXPath());
    }

    @Override
    public String toString() {
        return "HtmlElement{" +
                "elementId='" + elementId + '\'' +
                ", elementClass='" + elementClass + '\'' +
                ", elementTitle='" + elementTitle + '\'' +
                ", elementXPath='" + elementXPath + '\'' +
                '}';
    }
}
