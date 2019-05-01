package frontEnd.MessagingSystem.routing.outputStructures.stream;

import frontEnd.Interface.outputRouting.ExceptionHandler;
import frontEnd.MessagingSystem.AnalysisIssue;
import frontEnd.MessagingSystem.routing.EnvironmentInformation;
import frontEnd.MessagingSystem.routing.Listing;
import frontEnd.MessagingSystem.routing.outputStructures.common.JacksonSerializer;
import frontEnd.MessagingSystem.routing.structure.Default.Issue;
import frontEnd.MessagingSystem.routing.structure.Default.IssueWrapper;
import frontEnd.MessagingSystem.routing.structure.Default.Report;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import util.Utils;

import static frontEnd.MessagingSystem.routing.outputStructures.common.Default.mapper;

/**
 * <p>Default class.</p>
 *
 * @author franceme
 * Created on 04/30/2019.
 * @since 03.05.01
 *
 * <p>{Description Here}</p>
 */
@Log4j2
public class Default extends Structure {
    //region Attributes
    private Integer issueID = 0;
    private Boolean started = false;
    //endregion

    //region Constructors

    /**
     * <p>Constructor for ScarfXML.</p>
     *
     * @param info a {@link frontEnd.MessagingSystem.routing.EnvironmentInformation} object.
     * @throws frontEnd.Interface.outputRouting.ExceptionHandler if any.
     */
    public Default(EnvironmentInformation info) throws ExceptionHandler {
        super(info);
    }
    //endregion

    //region Overridden Methods

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeHeader() throws ExceptionHandler {

        log.info("Marshalling the header.");

        Report report = mapper(super.getSource());

        log.trace("Marshalling the Target Info from the Env. Info.");
        report.setTarget(mapper(super.getSource(), Utils.getPlatform(), Utils.getJVMInfo()));

        log.trace("Setting the issues to null to not be output");
        report.setIssues(null);

        log.debug("Marshalling the header");
        String output = StringUtils.trimToNull(JacksonSerializer.serialize(report, super.getSource().prettyPrint(), Listing.Default.getJacksonType()));

        log.debug("Replacing the header based on the type");
        switch (super.getSource().getMessagingType().getJacksonType()) {
            case JSON:
                output = output.substring(0, output.lastIndexOf("}"));
                break;
            case XML:
            case YAML:
                break;
        }

        log.trace("Current String:" + output);

        this.write(output);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIssue(AnalysisIssue issue) throws ExceptionHandler {

        super.addIssue(issue);

        log.debug("Marshalling the issue: " + issue.getInfo());
        Issue instance = mapper(issue, this.getId());

        String output;

        if (!this.started) {

            //region Instantiating and trimming the wrapper content
            log.trace("Writing a initialized list");
            IssueWrapper issueWrapper = new IssueWrapper();
            issueWrapper.getIssues().add(instance);

            log.debug("Marshalling the issue wrapper");
            output = JacksonSerializer.serialize(issueWrapper, super.getSource().prettyPrint(), Listing.Default.getJacksonType());

            log.trace("Manipulating the output based on the type");
            switch (super.getSource().getMessagingType().getJacksonType()) {
                case JSON:
                    log.debug("Manipulating the JSON header output");

                    //Manipulating the string to contain only the contents of the class
                    //otherwise the class would auto close the array, and begin being closed
                    output = output.substring(output.indexOf("{") + 1, output.lastIndexOf("]") - 1);
                    output = ", " + output;
                    break;
                case XML:
                case YAML:
                    break;
            }

            this.started = true;
            //endregion
        } else {

            log.debug("Marshalling the issue");
            output = ", " + JacksonSerializer.serialize(instance, super.getSource().prettyPrint(), Listing.Default.getJacksonType());
        }

        log.debug("Writing the marshaled output");
        this.write(StringUtils.trimToNull(output));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeFooter() throws ExceptionHandler {
        String ending = "";

        log.debug("Adding the footer to the output");
        switch (super.getSource().getMessagingType().getJacksonType()) {
            case JSON:
                ending = "\n]\n}";
                break;
            case XML:
            case YAML:
                break;
        }

        this.write(ending);
    }
    //endregion

    //region Helper Methods
    private Integer getId() {
        return this.issueID++;
    }
    //endregion
}
