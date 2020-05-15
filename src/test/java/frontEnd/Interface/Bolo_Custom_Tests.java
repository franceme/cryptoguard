/* Licensed under GPL-3.0 */
package frontEnd.Interface;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static test.TestUtilities.captureNewFileOutViaStdOut;
import static test.TestUtilities.isLinux;
import static util.Utils.makeArg;

import frontEnd.MessagingSystem.routing.Listing;
import frontEnd.MessagingSystem.routing.structure.Scarf.AnalyzerReport;
import frontEnd.argsIdentifier;
import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import rule.engine.EngineType;
import util.Utils;

//@RunWith(QuarantiningRunner.class)
//@Quarantine({"com.binarytweed", "frontEnd.Interface.*"})
public class Bolo_Custom_Tests {
  //region Velocity Tools
  /** Generated Test */
  @Test(timeout = 300000) //Timeout = 5 Minutes
  public void generatedTest_velocityTools_Zero() {
    String fileOut = "_GeneratedTestFile_0.xml";
    new File(fileOut).delete();

    ArrayList<String> tempSource =
        new ArrayList<String>() {
          {
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/whitebox/GenericToolsTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/DisplayToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/AlternatorToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/ClassToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/whitebox/ConfigTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/ClassToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/blackbox/CookieToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/LinkToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/XmlToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/whitebox/ConfigTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/LoopToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/JettyLogger.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/ClassToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/LoopToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/blackbox/LinkToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/ClassToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/DisplayToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/FilteredLogChuteCommonsLog.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/LinkToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/generic/LoopToolTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/blackbox/ServletAdaptor.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/whitebox/ConfigTests.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/tools.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes/org/apache/velocity/tools/test/blackbox/ViewToolsTests.class");
          }
        };
    String source = Utils.join(" ", tempSource);

    String tempDependency =
        Utils.join(
            ":",
            new ArrayList<String>() {
              {
                add(
                    "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/dist/test-classes");
                add(
                    "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes");
                add(
                    "/home/maister/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar");
                add(
                    "/home/maister/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar");
                add(
                    "/home/maister/.m2/repository/commons-chain/commons-chain/1.1/commons-chain-1.1.jar");
                add(
                    "/home/maister/.m2/repository/commons-collections/commons-collections/3.2/commons-collections-3.2.jar");
                add(
                    "/home/maister/.m2/repository/commons-lang/commons-lang/2.2/commons-lang-2.2.jar");
                add(
                    "/home/maister/.m2/repository/commons-logging/commons-logging/1.1/commons-logging-1.1.jar");
                add(
                    "/home/maister/.m2/repository/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.jar");
                add("/home/maister/.m2/repository/dom4j/dom4j/1.1/dom4j-1.1.jar");
                add(
                    "/home/maister/.m2/repository/javax/servlet/servlet-api/2.3/servlet-api-2.3.jar");
                add("/home/maister/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar");
                add("/home/maister/.m2/repository/sslext/sslext/1.2-0/sslext-1.2-0.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.jar");
                add("/home/maister/.m2/repository/antlr/antlr/2.7.2/antlr-2.7.2.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/velocity/velocity/1.6.2/velocity-1.6.2.jar");
                add("/home/maister/.m2/repository/httpunit/httpunit/1.6.1/httpunit-1.6.1.jar");
                add(
                    "/home/maister/.m2/repository/jtidy/jtidy/4aug2000r7-dev/jtidy-4aug2000r7-dev.jar");
                add(
                    "/home/maister/.m2/repository/org/mortbay/jetty/jetty-embedded/6.0.1/jetty-embedded-6.0.1.jar");
                add("/home/maister/.m2/repository/org/mortbay/jetty/jetty/6.0.1/jetty-6.0.1.jar");
                add(
                    "/home/maister/.m2/repository/org/mortbay/jetty/jetty-util/6.0.1/jetty-util-6.0.1.jar");
                add(
                    "/home/maister/.m2/repository/org/mortbay/jetty/servlet-api-2.5/6.0.1/servlet-api-2.5-6.0.1.jar");
                add(
                    "/home/maister/.m2/repository/org/mortbay/jetty/jsp-api-2.1/6.0.1/jsp-api-2.1-6.0.1.jar");
                add("/home/maister/.m2/repository/nekohtml/nekohtml/0.9.5/nekohtml-0.9.5.jar");
                add("/home/maister/.m2/repository/rhino/js/1.6R5/js-1.6R5.jar");
                add("/home/maister/.m2/repository/xerces/xercesImpl/2.8.1/xercesImpl-2.8.1.jar");
                add("/home/maister/.m2/repository/xml-apis/xml-apis/1.3.03/xml-apis-1.3.03.jar");
                add(
                    "/home/maister/.m2/repository/xerces/xmlParserAPIs/2.6.2/xmlParserAPIs-2.6.2.jar");
                add("/home/maister/.m2/repository/junit/junit/4.1/junit-4.1.jar");
              }
            });
    String dependency = Utils.join(" ", tempDependency);

    if (isLinux) {

      String args =
          makeArg(argsIdentifier.FORMAT, EngineType.CLASSFILES)
              + makeArg(argsIdentifier.SOURCE, source)
              + makeArg(argsIdentifier.OUT, fileOut)
              + makeArg(argsIdentifier.FORMATOUT, Listing.ScarfXML)
              + makeArg(argsIdentifier.DEPENDENCY, dependency)
              + makeArg(argsIdentifier.PRETTY)
              + makeArg(argsIdentifier.STREAM)
              + makeArg(argsIdentifier.NOEXIT);

      try {
        String outputFile = captureNewFileOutViaStdOut(args.split(" "));

        AnalyzerReport report = AnalyzerReport.deserialize(new File(outputFile));
        /*
        assertFalse(report.getBugInstance().isEmpty());
        assertTrue(report.getBugInstance().stream().anyMatch(bugInstance -> {
            try {
                return Utils.containsAny(bugInstance.getClassName(), Utils.retrieveFullyQualifiedName(tempSource));
            } catch (ExceptionHandler exceptionHandler) {
                exceptionHandler.printStackTrace();
                return false;
            }
        }));
         */

      } catch (Exception e) {
        e.printStackTrace();
        assertNull(e);
      }
    }
  }

  /** Generated Test */
  @Test(timeout = 300000) //Timeout = 5 Minutes
  public void generatedTest_velocityTools_One() {
    String fileOut = "_GeneratedTestFile_1.xml";
    new File(fileOut).delete();

    ArrayList<String> tempSource =
        new ArrayList<String>() {
          {
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/DefaultKey.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/EasyFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/FormTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/EasyFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Data.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ToolManager.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/BrowserTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/context/ChainedContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ToolConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/XmlTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/XmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/log/LogSystemCommonsLog.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ToolboxConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolboxManager.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LocaleConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ComparisonDateTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/WebappUberspector.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ImportSupport.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/WebappUberspector.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/WebappResourceLoader.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ViewToolInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/StrutsUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/FormatConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/WebappLoader.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/jsp/JspToolContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ToolInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/ParameterParser.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/XmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/ValidatorTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/WebappUberspector.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/DisplayTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ViewContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ConfigurationUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/JeeFilterConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/ViewRenderTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/NullKeyException.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/DataInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/PagerTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/MarkupTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ToolInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/EasyFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/log/LogChuteCommonsLog.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/ActionMessagesTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/VelocityViewServlet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/JeeConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Data.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/AbstractSearchTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ResourceTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Data.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/RenderTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ToolContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/TilesTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ViewContextTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/AbstractLockConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/SortTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/ValidatorTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ListTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ConfigurationCleaner.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/AbstractSearchTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ParameterTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ToolConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/MarkupTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/ContextTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/AbstractPagerTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/VelocityViewFilter.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ServletUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/FieldTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ImportTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/MessageTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/EscapeTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ToolboxFactory.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/CompoundConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/XmlTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/XmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/InvalidScopeException.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/i18n/MultiViewsTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/MarkupTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/MessageTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ImportSupport.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ViewToolContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/Toolbox.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ViewToolManager.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ClassUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/context/ViewContext.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/FieldTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/XmlFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/VelocityViewServlet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/ConversionUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/MarkupTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/PropertiesFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/LogSupport.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/MessageResourcesTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ToolConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ResourceTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/JeeServletConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/DateTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Data.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/AbstractSearchTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ValidScope.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/IteratorTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/JeeContextConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/SortTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/Scope.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/ImportTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/LinkTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ServletUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/Alternator.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/FieldTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/XMLToolboxManager.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/VelocityLayoutServlet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/ConfigurationException.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/MathTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/ErrorsTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ValueParser.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/jsp/VelocityViewTag.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Configuration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/DisplayTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/VelocityLayoutServlet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Data.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/NumberTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/CookieTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/StrutsLinkTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/OldToolInfo.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/CookieTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/CookieTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ComparisonDateTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/SkipSetters.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/struts/SecureLinkTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ServletUtils.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/UiDependencyTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/LinkTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/IncludeTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ContextTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletLogger.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/VelocityView.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/servlet/ServletToolboxRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/log/CommonsLogLogSystem.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/ViewResourceTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/tools/BrowserSnifferTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/Property.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LoopTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/FactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/AlternatorTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/OldXmlFactoryConfigurationRuleSet.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ImportSupport.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ToolboxManager.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/LinkTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/SafeConfig.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ClassTool.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ServletLogChute.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/InvalidScope.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/config/FileFactoryConfiguration.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/view/ImportSupport.class");
            add(
                "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes/org/apache/velocity/tools/generic/ConversionTool.class");
          }
        };
    String source = Utils.join(" ", tempSource);

    String tempDependency =
        Utils.join(
            ":",
            new ArrayList<String>() {
              {
                add(
                    "/home/maister/.Projects/Bolo/6_velocitytools/run-velocitytools/velocity-tools-2.0/build/classes");
                add(
                    "/home/maister/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar");
                add(
                    "/home/maister/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar");
                add(
                    "/home/maister/.m2/repository/commons-chain/commons-chain/1.1/commons-chain-1.1.jar");
                add(
                    "/home/maister/.m2/repository/commons-collections/commons-collections/3.2/commons-collections-3.2.jar");
                add(
                    "/home/maister/.m2/repository/commons-lang/commons-lang/2.2/commons-lang-2.2.jar");
                add(
                    "/home/maister/.m2/repository/commons-logging/commons-logging/1.1/commons-logging-1.1.jar");
                add(
                    "/home/maister/.m2/repository/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.jar");
                add("/home/maister/.m2/repository/dom4j/dom4j/1.1/dom4j-1.1.jar");
                add(
                    "/home/maister/.m2/repository/javax/servlet/servlet-api/2.3/servlet-api-2.3.jar");
                add("/home/maister/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar");
                add("/home/maister/.m2/repository/sslext/sslext/1.2-0/sslext-1.2-0.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.jar");
                add("/home/maister/.m2/repository/antlr/antlr/2.7.2/antlr-2.7.2.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.jar");
                add(
                    "/home/maister/.m2/repository/org/apache/velocity/velocity/1.6.2/velocity-1.6.2.jar");
              }
            });
    String dependency = Utils.join(" ", tempDependency);

    if (isLinux) {

      String args =
          makeArg(argsIdentifier.FORMAT, EngineType.CLASSFILES)
              + makeArg(argsIdentifier.SOURCE, source)
              + makeArg(argsIdentifier.OUT, fileOut)
              + makeArg(argsIdentifier.FORMATOUT, Listing.ScarfXML)
              + makeArg(argsIdentifier.DEPENDENCY, dependency)
              + makeArg(argsIdentifier.PRETTY)
              + makeArg(argsIdentifier.STREAM)
              + makeArg(argsIdentifier.VERYVERBOSE)
              + makeArg(argsIdentifier.NOEXIT);

      try {
        String outputFile = captureNewFileOutViaStdOut(args.split(" "));

        AnalyzerReport report = AnalyzerReport.deserialize(new File(outputFile));
        /*
        assertFalse(report.getBugInstance().isEmpty());
        assertTrue(report.getBugInstance().stream().anyMatch(bugInstance -> {
            try {
                return Utils.containsAny(bugInstance.getClassName(), Utils.retrieveFullyQualifiedName(tempSource));
            } catch (ExceptionHandler exceptionHandler) {
                exceptionHandler.printStackTrace();
                return false;
            }
        }));
        */

      } catch (Exception e) {
        e.printStackTrace();
        assertNull(e);
      }
    }
  }
  //endregion
  //region Jacorb Tests
  /** Generated Test */
  @Test(timeout = 300000) //Timeout = 5 Minutes
  public void generatedTest_32() {
    String fileOut = "_GeneratedTestFile_32.xml";
    new File(fileOut).delete();

    ArrayList<String> tempSource =
        new ArrayList<String>() {
          {
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/jacorb_imr/target/test-classes/org/jacorb/test/orbreinvoke/jacorb_imr/Server.class");
          }
        };
    String source = Utils.join(" ", tempSource);

    String tempDependency =
        Utils.join(
            ":",
            new ArrayList<String>() {
              {
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/jacorb_imr/target/test-classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/jacorb_imr/target/classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/core/target/jacorb-3.7.jar");
                add("/home/maister/.m2/repository/org/slf4j/slf4j-api/1.7.6/slf4j-api-1.7.6.jar");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/omgapi/target/jacorb-omgapi-3.7.jar");
              }
            });
    String dependency = Utils.join(" ", tempDependency);

    if (isLinux) {

      String args =
          makeArg(argsIdentifier.FORMAT, EngineType.CLASSFILES)
              + makeArg(argsIdentifier.SOURCE, source)
              + makeArg(argsIdentifier.OUT, fileOut)
              + makeArg(argsIdentifier.FORMATOUT, Listing.ScarfXML)
              + makeArg(argsIdentifier.DEPENDENCY, dependency)
              + makeArg(argsIdentifier.PRETTY)
              + makeArg(argsIdentifier.NOEXIT);

      try {
        String outputFile = captureNewFileOutViaStdOut(args.split(" "));

        AnalyzerReport report = AnalyzerReport.deserialize(new File(outputFile));
        /*
        assertFalse(report.getBugInstance().isEmpty());
        assertTrue(report.getBugInstance().stream().anyMatch(bugInstance -> {
            try {
                return Utils.containsAny(bugInstance.getClassName(), Utils.retrieveFullyQualifiedName(tempSource));
            } catch (ExceptionHandler exceptionHandler) {
                exceptionHandler.printStackTrace();
                return false;
            }
        }));
        */

      } catch (Exception e) {
        e.printStackTrace();
        assertNull(e);
      }
    }
  }

  /** Generated Test */
  @Test //@Test(timeout=300000)//Timeout = 5 Minutes
  public void generatedTest_33() {
    String fileOut = "_GeneratedTestFile_33.xml";
    new File(fileOut).delete();

    ArrayList<String> tempSource =
        new ArrayList<String>() {
          {
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/test-classes/org/jacorb/test/orbreinvoke/tao_imr/TwoPoaServer.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/test-classes/org/jacorb/test/orbreinvoke/tao_imr/OnePoaServer.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/test-classes/org/jacorb/test/orbreinvoke/tao_imr/MyCmdArgs.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/test-classes/org/jacorb/test/orbreinvoke/tao_imr/SimpleServer.class");
          }
        };
    String source = Utils.join(" ", tempSource);

    String tempDependency =
        Utils.join(
            ":",
            new ArrayList<String>() {
              {
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/test-classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_imr/target/classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/core/target/jacorb-3.7.jar");
                add("/home/maister/.m2/repository/org/slf4j/slf4j-api/1.7.6/slf4j-api-1.7.6.jar");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/omgapi/target/jacorb-omgapi-3.7.jar");
              }
            });
    String dependency = Utils.join(" ", tempDependency);

    if (isLinux) {

      String args =
          makeArg(argsIdentifier.FORMAT, EngineType.CLASSFILES)
              + makeArg(argsIdentifier.SOURCE, source)
              + makeArg(argsIdentifier.OUT, fileOut)
              + makeArg(argsIdentifier.FORMATOUT, Listing.ScarfXML)
              + makeArg(argsIdentifier.DEPENDENCY, dependency)
              + makeArg(argsIdentifier.PRETTY)
              + makeArg(argsIdentifier.NOEXIT);

      try {
        String outputFile = captureNewFileOutViaStdOut(args.split(" "));

        AnalyzerReport report = AnalyzerReport.deserialize(new File(outputFile));
        /*
        assertFalse(report.getBugInstance().isEmpty());
        assertTrue(report.getBugInstance().stream().anyMatch(bugInstance -> {
            try {
                return Utils.containsAny(bugInstance.getClassName(), Utils.retrieveFullyQualifiedName(tempSource));
            } catch (ExceptionHandler exceptionHandler) {
                exceptionHandler.printStackTrace();
                return false;
            }
        }));
        */

      } catch (Exception e) {
        e.printStackTrace();
        assertNull(e);
      }
    }
  }

  /** Generated Test */
  @Test(timeout = 300000) //Timeout = 5 Minutes
  public void generatedTest_34() {
    String fileOut = "_GeneratedTestFile_34.xml";
    new File(fileOut).delete();

    ArrayList<String> tempSource =
        new ArrayList<String>() {
          {
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/test-classes/org/jacorb/test/orbreinvoke/tao_ns/Server.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/test-classes/org/jacorb/test/orbreinvoke/tao_ns/MyCmdArgs.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/test-classes/org/jacorb/test/orbreinvoke/tao_ns/ConnectNameService.class");
            add(
                "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/test-classes/org/jacorb/test/orbreinvoke/tao_ns/Client.class");
          }
        };
    String source = Utils.join(" ", tempSource);

    String tempDependency =
        Utils.join(
            ":",
            new ArrayList<String>() {
              {
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/test-classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/test/orbreinvoke/tao_ns/target/classes");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/core/target/jacorb-3.7.jar");
                add("/home/maister/.m2/repository/org/slf4j/slf4j-api/1.7.6/slf4j-api-1.7.6.jar");
                add(
                    "/home/maister/.Projects/Bolo/5_jacorb/run-jacorb/jacorb-3.7/omgapi/target/jacorb-omgapi-3.7.jar");
              }
            });
    String dependency = Utils.join(" ", tempDependency);

    if (isLinux) {

      String args =
          makeArg(argsIdentifier.FORMAT, EngineType.CLASSFILES)
              + makeArg(argsIdentifier.SOURCE, source)
              + makeArg(argsIdentifier.OUT, fileOut)
              + makeArg(argsIdentifier.FORMATOUT, Listing.ScarfXML)
              + makeArg(argsIdentifier.DEPENDENCY, dependency)
              + makeArg(argsIdentifier.PRETTY)
              + makeArg(argsIdentifier.NOEXIT);

      try {
        String outputFile = captureNewFileOutViaStdOut(args.split(" "));

        AnalyzerReport report = AnalyzerReport.deserialize(new File(outputFile));
        /*
        assertFalse(report.getBugInstance().isEmpty());
        assertTrue(report.getBugInstance().stream().anyMatch(bugInstance -> {
            try {
                return Utils.containsAny(bugInstance.getClassName(), Utils.retrieveFullyQualifiedName(tempSource));
            } catch (ExceptionHandler exceptionHandler) {
                exceptionHandler.printStackTrace();
                return false;
            }
        }));
        */

      } catch (Exception e) {
        e.printStackTrace();
        assertNull(e);
      }
    }
  }
  //endregion
}
