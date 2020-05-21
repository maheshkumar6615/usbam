package com.adobe.aem.usbam.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = CustomHeadingModel.RESOURCE_TYPE,
        adapters = {CustomHeadingModel.class, ComponentExporter.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CustomHeadingModel implements ComponentExporter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected static final String RESOURCE_TYPE = "usbamapp/components/custom-heading";

    @ValueMapValue(name = "heading")
    private String heading;
    @ValueMapValue(name = "headingType")
    private String headingType;
    @ValueMapValue(name = "headingColor")
    private String headingColor;

    @ScriptVariable
    private Node currentNode;

    @ScriptVariable
    private Page currentPage;

    private String customValue = "custom text from model";
    private String lastModifiedDate;

    public String getLastModifiedDate() throws RepositoryException {
        return currentNode.getProperty("jcr:lastModified").toString();
    }

    public String getCustomValue() {
        return customValue;
    }

    public String getHeading() {
        return heading;
    }
    public String getHeadingType() {
        return headingType;
    }
    public String getHeadingColor() {
        return headingColor;
    }
    @Nonnull
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
