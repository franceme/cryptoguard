package main.rule.engine;

import main.frontEnd.MessagingSystem.AnalysisIssue;
import main.frontEnd.MessagingSystem.routing.EnvironmentInformation;

import java.util.ArrayList;

/**
 * @author RigorityJTeam
 * Created on 2019-01-20.
 * @since {Version}
 *
 * <p>{Description}</p>
 */
public interface EntryHandler {

    /**
     * The method to return all of the Analysis Issues in a block style method.
     *
     * @param generalInfo {@link EnvironmentInformation} - The basic information retrieved from the command line.
     * @return {@link AnalysisIssue} - Returns a list of captured issues.
     */
    public ArrayList<AnalysisIssue> NonStreamScan(EnvironmentInformation generalInfo);

    /**
     * The method to return all of the Analysis Issues in a stream style method.
     *
     * @param generalInfo {@link EnvironmentInformation} - The basic information retrieved from the command line.
     * @return {@link AnalysisIssue} - Returns a stream of captured issues.
     */
    /*public Stream<AnalysisIssue> StreamScan(EnvironmentInformation generalInfo);*/
}
