#!/usr/bin/env python3

import argparse
import hashlib
import json
import os
import shlex
import signal
import subprocess
import sys
import time
from collections import OrderedDict

# TODO - Add xml/json results verification

'''####################################
#A utility class that contains the rest of the main common files
'''  ####################################
curdir = os.path.abspath(os.curdir)
gitPath = os.path.join(curdir, '.git')
failFast, offline = False, not os.path.exists(gitPath)
android, java7, java = os.environ.get('ANDROID_HOME'), os.environ.get('JAVA7_HOME'), os.environ.get('JAVA_HOME')

# region Offline information
archivedInformation = {'properties': {'projectName': 'cryptoguard', 'groupName': 'vt.edu', 'versionNumber': 'V03.11.06',
                                      'buildFrameWork': 'Java', 'buildVersion': '1.8.232', 'org.gradle.daemon': 'false',
                                      'gradle.version': '4.10.3', 'surveyURL': 'TBD'}, 'rawArgs': {
    '    FORMAT': {'id': 'in', 'defaultArg': 'format', 'desc': 'Required: The format of input you want to scan',
                   'Required': True}, '    SOURCE': {'id': 's', 'defaultArg': 'file/files/*.in/dir/ClassPathString',
                                                     'desc': 'Required: The source to be scanned use the absolute path or send all of the source files via the file input.in; ex. find -type f *.java >> input.in.',
                                                     'Required': True},
    '    DEPENDENCY': {'id': 'd', 'defaultArg': 'dir', 'desc': 'The dependency to be scanned use the relative path.',
                       'Required': False}, '    OUT': {'id': 'o', 'defaultArg': 'file',
                                                       'desc': 'The file to be created with the output default will be the project name.',
                                                       'Required': False},
    '    NEW': {'id': 'new', 'defaultArg': 'null',
                'desc': 'The file to be created with the output if existing will be overwritten.', 'Required': False},
    '    TIMEMEASURE': {'id': 't', 'defaultArg': 'null', 'desc': 'Output the time of the internal processes.',
                        'Required': False},
    '    FORMATOUT': {'id': 'm', 'defaultArg': 'formatType', 'desc': 'The output format you want to produce',
                      'Required': False},
    '    PRETTY': {'id': 'n', 'defaultArg': 'null', 'desc': "Output the analysis information in a 'pretty' format.",
                   'Required': False},
    '    NOEXIT': {'id': 'X', 'defaultArg': 'null', 'desc': 'Upon completion of scanning', 'Required': False},
    '    EXPERIMENTRESULTS': {'id': 'exp', 'defaultArg': 'null', 'desc': 'View the experiment based results.',
                              'Required': False},
    '    VERSION': {'id': 'V', 'defaultArg': 'null', 'desc': 'Output the version number.', 'Required': False},
    '    NOLOGS': {'id': 'vx', 'defaultArg': 'null', 'desc': 'Display logs only from the fatal logs',
                   'Required': False},
    '    VERBOSE': {'id': 'v', 'defaultArg': 'null', 'desc': 'Display logs from debug levels', 'Required': False},
    '    VERYVERBOSE': {'id': 'vv', 'defaultArg': 'null', 'desc': 'Display logs from trace levels', 'Required': False},
    '    TIMESTAMP': {'id': 'ts', 'defaultArg': 'null', 'desc': 'Add a timestamp to the file output.',
                      'Required': False},
    '    DEPTH': {'id': 'depth', 'defaultArg': 'null', 'desc': 'The depth of slicing to go into', 'Required': False},
    '    LOG': {'id': 'L', 'defaultArg': 'null', 'desc': 'Enable logging to the console.', 'Required': False},
    '    JAVA': {'id': 'java', 'defaultArg': 'envVariable',
                 'desc': 'Directory of Java to be used JDK 7 for JavaFiles/Project and JDK 8 for ClassFiles/Jar',
                 'Required': False},
    '    ANDROID': {'id': 'android', 'defaultArg': 'envVariable', 'desc': 'Specify of Android SDK', 'Required': False},
    '    HEURISTICS': {'id': 'H', 'defaultArg': 'null',
                       'desc': 'The flag determining whether or not to display heuristics.', 'Required': False},
    '    STREAM': {'id': 'st', 'defaultArg': 'null', 'desc': 'Stream the analysis to the output file.',
                   'Required': False},
    '    HELP': {'id': 'h', 'defaultArg': 'null', 'desc': 'Print out the Help Information.', 'Required': False},
    '    MAIN': {'id': 'main', 'defaultArg': 'className',
                 'desc': 'Choose the main class if there are multiple main classes in the files given.',
                 'Required': False}}, 'engineType': {'    JAR': {'name': 'JAR File', 'flag': 'jar', 'extension': '.jar',
                                                                 'helpInfo': 'To signal a Jar File to be scanned.)'},
                                                     '    APK': {'name': 'APK File', 'flag': 'apk', 'extension': '.apk',
                                                                 'helpInfo': 'To signal a APK File to be scanned.)'},
                                                     '    DIR': {'name': 'Directory of Source Code', 'flag': 'source',
                                                                 'extension': 'dir',
                                                                 'helpInfo': 'To signal the source directory of a Maven/Gradle Project.)'},
                                                     '    JAVAFILES': {'name': 'Java File or Files', 'flag': 'java',
                                                                       'extension': '.java',
                                                                       'helpInfo': 'To signal a Java File(s) to be scanned.)'},
                                                     '    CLASSFILES': {'name': 'Class File or Files', 'flag': 'class',
                                                                        'extension': '.class',
                                                                        'helpInfo': 'To signal a Class File(s) to be scanned.);'}},
                       'outputType': {'    Legacy': {'type': 'Legacy', 'flag': 'L', 'outputExtension': '.txt'},
                                      '    ScarfXML': {'type': 'ScarfXML', 'flag': 'SX', 'outputExtension': '.xml'},
                                      '    Default': {'type': 'Default', 'flag': 'D', 'outputExtension': '.json'}},
                       'exceptionType': {'    SUCCESS': {'id': '0', 'messageType': 'Successful'},
                                         '    HELP': {'id': '0', 'messageType': 'Asking For Help'},
                                         '    VERSION': {'id': '0', 'messageType': 'Asking For Version'},
                                         '    GEN_VALID': {'id': '1', 'messageType': 'General Argument Validation'},
                                         '    ARG_VALID': {'id': '2', 'messageType': 'Argument Value Validation'},
                                         '    FORMAT_VALID': {'id': '7',
                                                              'messageType': 'Format Specific Argument Validation'},
                                         '    FILE_I': {'id': '15', 'messageType': 'File Input Error'},
                                         '    FILE_READ': {'id': '16', 'messageType': 'Reading File Error'},
                                         '    FILE_AFK': {'id': '17', 'messageType': 'File Not Available'},
                                         '    FILE_O': {'id': '30', 'messageType': 'File Output Error'},
                                         '    FILE_CON': {'id': '31', 'messageType': 'Output File Creation Error'},
                                         '    FILE_CUT': {'id': '32', 'messageType': 'Error Closing The File'},
                                         '    ENV_VAR': {'id': '45', 'messageType': 'Environment Variable Not Set'},
                                         '    MAR_VAR': {'id': '100', 'messageType': 'Error Marshalling The Output'},
                                         '    SCAN_GEN': {'id': '120',
                                                          'messageType': 'General Error Scanning The Program'},
                                         '    LOADING': {'id': '121', 'messageType': 'Error Loading Class'},
                                         '    UNKWN': {'id': '127', 'messageType': 'Unknown'}}, 'examples': {
        'General Project Version': {'type': 'General', 'arg': '-V',
                                    'explanation': 'The version argument (-V) returns the version of the project and exits.'},
        'General Project No Logging': {'type': 'General', 'arg': '-vx',
                                       'explanation': 'The argument (-vx) only displays the fatal logs.'},
        'General Project Verbose Logging': {'type': 'General', 'arg': '-v',
                                            'explanation': 'The argument (-v) displays debug logs.'},
        'General Project Very Verbose Logging': {'type': 'General', 'arg': '-vv',
                                                 'explanation': 'The argument (-vv) displays the all of the logs available.'},
        'General Project Stream': {'type': 'General', 'arg': '-st',
                                   'explanation': 'The argument (-st) enables streaming the results to whatever output file is specified.'},
        'General Project Heuristics': {'type': 'General', 'arg': '-H',
                                       'explanation': 'The argument (-H) writes the heuristics picked up in the output file.'},
        'General Project Specifying the main file': {'type': 'General', 'arg': '-main',
                                                     'explanation': 'The argument (-main) specifies the main class (containing public static void main) if there are multiple within the project.'},
        'General Project Java Home': {'type': 'General', 'arg': '-java',
                                      'explanation': "The argument (-java) sets the Java file path needed for an internal library. This is needed if the environment variable isn't set.\nJDK 7 needed for either a Project or Java File Scanning.\nJDK 8 needed for the other projects."},
        'General Project Android Home': {'type': 'General', 'arg': '-android',
                                         'explanation': "The argument (-android) sets the Android file path.needed for an internal library. This is needed if the environment variable isn't set.\nNeeded if an Android project is being scanned."},
        'General Project PrettyPrint': {'type': 'General', 'arg': '-n',
                                        'explanation': 'The prettyprint argument (-n) writes the result in the "pretty" format.'},
        'General Project Time Measurement': {'type': 'General', 'arg': '-t',
                                             'explanation': 'The time argument (-t) displays the time taken for the scanning.'},
        'JAR Project Base': {'type': 'JAR', 'arg': '-in jar -s .../project.jar',
                             'explanation': 'The format argument (-in) specifies the type of project (jar) and the source argument (-s) specifies the location of the project.'},
        'JAR Project Dependency': {'type': 'JAR', 'arg': '-in jar -s .../project.jar -d .../lib/file(s).jar',
                                   'explanation': 'The format argument (-d) specifies the directory of the dependencies to be used with the project and picks up the file.jar.'},
        'JAR Project Fileout': {'type': 'JAR', 'arg': '-in jar -s .../project.jar -m D -o .../fileout.json',
                                'explanation': 'The output format argument (-m) specifies the type of output to write amd the output argument (-o) specifies the file to write the results to.'},
        'JAR Project Sample Test ': {'type': 'JAR',
                                     'arg': '-in jar -s cryptoguard/samples/testable-jar/build/libs/testable-jar.jar  -d cryptoguard/samples/testable-jar/build/dependencies  -m SX  -o cryptoguard/build/tmp/tempJarFile_Scarf_0.xml  -t  -H  -n -java .../jdk8',
                                     'explanation': 'The output format argument (-in) specifies the type of project (jar).\nThe source argument (-s) specifies the project to be scanned (.../testable-jar.jar).\nThe dependency argument (-d) specifies the directory of the dependencies (.../dependencies).\nThe output format argument (-m) specifies the type of result to write out (Scarf).\nThe output argument (-o) specifies the file to write out to (.../tempJarFile_Scarf_0.xml).\nThe time argument (-t) displays time taken via the project.\nThe heuristic argument (-H) writes various heuristics taken to the output.\nThe prettyprint argument (-n) formats and writes the output into a "pretty" format.\nThe java argument (-java) specifies the java home, either java 7 or 8 for the internal library.'},
        'Project Scanner Base': {'type': 'Project', 'arg': '-in source -s .../project/',
                                 'explanation': 'The format argument (-in) specifies the type of project (source) and the source argument (-s) specifies the location of the project.\nThis must either be a gradle or maven based project.'},
        'Project Scanner Dependency': {'type': 'Project', 'arg': '-in source -s .../project/ -d .../lib/file(s).jar',
                                       'explanation': 'The format argument (-d) specifies the directory of the dependencies to be used with the project and picks up the file.jar.'},
        'Project Fileout': {'type': 'Project', 'arg': '-in source -s .../project/ -m D -o .../fileout.json',
                            'explanation': 'The output format argument (-m) specifies the type of output to write amd the output argument (-o) specifies the file to write the results to.'},
        'Project Sample Test ': {'type': 'Project',
                                 'arg': '-in source -s cryptoguard/samples/testable-jar  -d cryptoguard/samples/testable-jar/build/dependencies  -m L  -o cryptoguard/build/tmp/testable-jar.txt  -t  -H  -n ',
                                 'explanation': 'The output format argument (-in) specifies the type of project (source).\nThe source argument (-s) specifies the project to be scanned (.../testable-jar).\nThe dependency argument (-d) specifies the directory of the dependencies (.../dependencies).\nThe output format argument (-m) specifies the type of result to write out (Legacy).\nThe output argument (-o) specifies the file to write out to (.../testable-jar.txt).\nThe time argument (-t) displays time taken via the project.\nThe heuristic argument (-H) writes various heuristics taken to the output.\nThe prettyprint argument (-n) formats and writes the output into a "pretty" format.'},
        'Java File(s) Project Base Single File': {'type': 'Java', 'arg': '-in java -s .../test.java',
                                                  'explanation': 'The format argument (-in) specifies the type of project (java) and the source argument (-s) specifies the file to be used.'},
        'Java File(s) Project Multiple Files (Split via space)': {'type': 'Java',
                                                                  'arg': '-in java -s .../test.java .../testTwo.java',
                                                                  'explanation': 'The argument (-s) specifies the file to be used, retrieving test.java and testTwo.java via the space between the arguments.'},
        'Java File(s) Project Multiple Files (Split via classpath)': {'type': 'Java',
                                                                      'arg': '-in java -s .../test.java:.../testTwo.java',
                                                                      'explanation': 'The argument (-s) specifies the file to be used, retrieving test.java and testTwo.java via the split by classpath (delimited by :).'},
        'Java File(s) Project Multiple Files (Split via input.in file)': {'type': 'Java',
                                                                          'arg': '-in java -s .../input.in',
                                                                          'explanation': 'The argument (-s) specifies the input.in file to be used. This file should contain a line delimited paths to the source file. This also works based on the \nex. \n.../test.java\n.../testTwo.java'},
        'Java File Fileout': {'type': 'Java', 'arg': '-in java -s .../test.java -m D -o .../fileout.json',
                              'explanation': 'The output format argument (-m) specifies the type of output to write amd the output argument (-o) specifies the file to write the results to.'},
        'Java File Dependency': {'type': 'Java', 'arg': '-in java -s .../test.java -d .../lib/file(s).jar',
                                 'explanation': 'The format argument (-d) specifies the directory of the dependencies to be used with the project and picks up the file.jar.'},
        'Java File Test ': {'type': 'Java',
                            'arg': '-in java -s cryptoguard/samples/temp/tester/test.java  -m SX  -o cryptoguard/build/tmp/test_java.xml  -t  -vv  -n ',
                            'explanation': 'The output format argument (-in) specifies the type of project (java).\nThe source argument (-s) specifies the project to be scanned (.../test.java).\nThe output format argument (-m) specifies the type of result to write out (Scarf).\nThe output argument (-o) specifies the file to write out to (.../test_java.xml).\nThe very verbose argument (-vv) displays all of the logs available.\nThe prettyprint argument (-n) formats and writes the output into a "pretty" format.'},
        'Java Class File(s) Project Base': {'type': 'Class', 'arg': '-in class -s .../test.class',
                                            'explanation': 'The format argument (-in) specifies the type of project (class) and the source argument (-s) specifies the location of the project.'},
        'Java Class File(s) Project Multiple Files (Split via space)': {'type': 'Class',
                                                                        'arg': '-in class -s .../test.class .../testTwo.class',
                                                                        'explanation': 'The argument (-s) specifies the file to be used, retrieving test.class and testTwo.class via the space between the arguments.'},
        'Java Class File(s) Project Multiple Files (Split via classpath)': {'type': 'Class',
                                                                            'arg': '-in class -s .../test.class:.../testTwo.class',
                                                                            'explanation': 'The argument (-s) specifies the file to be used, retrieving test.class and testTwo.class via the split by classpath (delimited by :).'},
        'Java Class File(s) Project Multiple Files (Split via input.in file)': {'type': 'Class',
                                                                                'arg': '-in class -s .../input.in',
                                                                                'explanation': 'The argument (-s) specifies the input.in file to be used. This file should contain a line delimited paths to the source file. This also works based on the \nex. \n.../test.class\n.../testTwo.class'},
        'Java Class File(s) Project Dependency': {'type': 'Class',
                                                  'arg': '-in class -s .../test.class -d .../lib/file(s).jar',
                                                  'explanation': 'The format argument (-d) specifies the directory of the dependencies to be used with the project and picks up the file.jar.'},
        'Java Class File Test ': {'type': 'Class',
                                  'arg': '-in class -s cryptoguard/samples/VerySimple/very.class -m SX  -o cryptoguard/build/tmp/verySimple_klass.xml  -n ',
                                  'explanation': 'The output format argument (-in) specifies the type of project (java).\nThe source argument (-s) specifies the project to be scanned (.../test.java).\nThe output format argument (-m) specifies the type of result to write out (Scarf).\nThe output argument (-o) specifies the file to write out to (.../verySimple_klass.xml).\nThe prettyprint argument (-n) formats and writes the output into a "pretty" format.'},
        'APK Project Base': {'type': 'APK', 'arg': '-in apk -s .../app-debug.apk',
                             'explanation': 'The format argument (-in) specifies the type of project (apk) and the source argument (-s) specifies the location of the project.'},
        'APK Project Dependency': {'type': 'APK', 'arg': '-in apk -s  .../app-debug.apk -d .../lib/file(s).jar',
                                   'explanation': 'The format argument (-d) specifies the directory of the dependencies to be used with the project and picks up the file.jar.'},
        'APK Project Fileout': {'type': 'APK', 'arg': '-in apk -s .../app-debug.apk -m D -o .../fileout.json',
                                'explanation': 'The output format argument (-m) specifies the type of output to write amd the output argument (-o) specifies the file to write the results to.'},
        'APK Project File Test ': {'type': 'APK',
                                   'arg': '-in apk -s cryptoguard/samples/app-debug.apk -m SX  -o cryptoguard/build/tmp/app-debug.xml  -n -android .../android_home',
                                   'explanation': 'The output format argument (-in) specifies the type of project (java).\nThe source argument (-s) specifies the project to be scanned (.../test.java).\nThe output format argument (-m) specifies the type of result to write out (Scarf).\nThe output argument (-o) specifies the file to write out to (.../debug.xml).\nThe prettyprint argument (-n) formats and writes the output into a "pretty" format.\nThe android argument (-android) specifies the android home for the internal library.'}}}


# endregion
# region Loading
class Loading(object):
    # region Online Reading
    def retrieveProperties(file='gradle.properties'):
        dyct = {}
        with open(file, 'r') as props:
            for line in props:
                if '=' in line:
                    key, value = line.split('=')
                    dyct[str(key.strip())] = str(value.strip())
        return dyct

    def parseEngineType(file='src/main/java/rule/engine/EngineType.java'):
        properties, starter, stopper = {}, False, False
        with open(file, 'r') as java:
            line = java.readline()
            while line and not stopper:

                if line.strip().startswith("//endregion"):
                    stopper = True
                elif (starter and not line.strip().startswith("//") and not line.strip().startswith(";")):
                    name, rest = line.split("(\"")
                    broken = rest.split(",")
                    properties[name] = {
                        'name': broken[0].replace("\"", "").strip(),
                        'flag': broken[1].replace("\"", "").strip(),
                        'extension': broken[2].replace("\"", "").strip(),
                        'helpInfo': broken[3].replace("\"", "").strip()
                    }
                elif line.strip().startswith("//region Values"):
                    starter = True

                line = java.readline()
        return properties

    def parseExceptionType(file='src/main/java/frontEnd/Interface/outputRouting/ExceptionId.java'):
        properties, starter, stopper = {}, False, False
        with open(file, 'r') as java:
            line = java.readline()
            while line and not stopper:

                if starter and line.strip().startswith(";"):
                    stopper = True
                elif (starter and line.strip() != '' and not line.strip().startswith(
                        "//") and not line.strip().startswith(";")):
                    name, rest = line.split("(")
                    broken = rest.split(",")

                    properties[name] = {
                        'id': broken[0].replace("\"", "").strip(),
                        'messageType': broken[1].replace("\"", "").replace(")", "").strip()
                    }
                elif line.strip().startswith("//region Values"):
                    starter = True

                line = java.readline()
        return properties

    def parseArgs(file='src/main/java/frontEnd/argsIdentifier.java'):
        properties, starter, stopper = {}, False, False
        with open(file, 'r') as java:
            line = java.readline()
            while line and not stopper:

                if line.strip().startswith("//endregion"):
                    stopper = True
                elif (starter and not line.strip().startswith("//") and not line.strip().startswith(";")):
                    name, rest = line.split("(\"")
                    broken = rest.split(",")
                    properties[name] = {
                        'id': broken[0].replace("\"", "").strip(),
                        'defaultArg': broken[1].replace("\"", "").strip(),
                        'desc': broken[2].replace("\"", "").strip(),
                        'Required': 'Required' in broken[2]
                    }
                elif line.strip().startswith("//region Values"):
                    starter = True

                line = java.readline()
        return properties

    def parseOutputType(file='src/main/java/frontEnd/MessagingSystem/routing/Listing.java'):
        properties, starter, stopper = {}, False, False
        with open(file, 'r') as java:
            line = java.readline()
            while line and not stopper:

                if line.strip().startswith("//endregion"):
                    stopper = True
                elif (starter and not line.strip().startswith("//") and not line.strip().startswith(";")):
                    name, rest = line.split("(\"")
                    broken = rest.split(",")
                    ext = broken[2].replace("\"", "").strip()
                    if ext == 'null':
                        ext = broken[4].split('.')
                        ext = ext[-1]
                        ext = "." + ext[:int(ext.index(')'))].lower()

                    properties[name] = {
                        'type': broken[0].replace("\"", "").strip(),
                        'flag': broken[1].replace("\"", "").strip(),
                        'outputExtension': ext
                    }
                elif line.strip().startswith("//region Values"):
                    starter = True

                line = java.readline()
        return properties

    def getExamplesRaw(file='exampleUsages.json'):
        with open(file, 'r') as jsonFile:
            data = jsonFile.read()
        data = json.loads(data)
        return data

    # endregion
    # region Online/Offline Reading
    def getExampleArgs():
        if offline:
            return archivedInformation['examples']
        else:
            return Loading.getExamplesRaw()

    def getProperties():
        if offline:
            return archivedInformation['properties']
        else:
            return Loading.retrieveProperties()

    def getRawArgs():
        if offline:
            return archivedInformation['rawArgs']
        else:
            return Loading.parseArgs()

    def getEngineType():
        if offline:
            return archivedInformation['engineType']
        else:
            return Loading.parseEngineType()

    def getDisplayOutputTypes():
        if offline:
            return archivedInformation['outputType']
        else:
            return Loading.parseOutputType()

    def getDisplayExceptionTypes():
        if offline:
            return archivedInformation['exceptionType']
        else:
            return Loading.parseExceptionType()
    # endregion


# endregion
# region Reading
class Reading(object):
    def prepareOffline():
        print('Writing offline information internally')
        data = {
            'properties': Loading.getProperties(),
            'rawArgs': Loading.getRawArgs(),
            'engineType': Loading.getEngineType(),
            'outputType': Loading.getDisplayOutputTypes(),
            'exceptionType': Loading.getDisplayExceptionTypes(),
            'examples': Loading.getExampleArgs()
        }
        return data

    def overWriting(replaceWith=None):
        if replaceWith == None:
            replaceWith = Reading.prepareOffline()
        foil = 'cryptoguard.py'
        replace = "archivedInformation = "

        lines = []
        with open(foil) as reading:
            for line in reading.readlines():
                if line.startswith(replace):
                    line = replace + str(replaceWith) + '\n'
                lines += [line]

        with open(foil, 'w') as writing:
            for line in lines:
                writing.write(line)


# endregion
# region Utils
class Utils(object):

    def prettyTime(num):
        string = ""
        if num // 360 > 0:
            string = string + str(num // 360) + " H "
            num = num - ((num // 360) * 360)
        if num // 60 > 0:
            string = string + str(num // 60) + " m "
            num = num - ((num // 60) * 60)
        if num > 0:
            string = string + str(num) + " s "
        return string

    def hash():
        Utils.build()
        print(Utils.halfRows())

        foil = Loading.getProperties()['projectName'] + '.jar'
        print("Determing the sha512 for " + foil, end=' | ')

        print(Utils.retrieveSha(foil))

    def retrieveSha(inFile):
        sha = None
        with open(inFile, 'rb') as new:
            contents = new.read()
            sha = hashlib.sha512(contents).hexdigest()
        return sha

    def stringMult(num, string='='):
        return ''.join([string for x in range(int(num))])

    def printSurveyURL():
        print(Loading.getProperties()['surveyURL'])

    def halfRows(kar='='):
        return Utils.stringMult(Utils.getWidthOfTerminal() / 2, kar)

    def splitRows(kar='='):
        return Utils.stringMult(Utils.getWidthOfTerminal(), kar)

    def getWidthOfTerminal():
        try:
            value = int(os.popen('stty size', 'r').read().split()[1])
            value = value*.75
        except:
            value = 50
        return value

    def printVersion():
        props = Loading.getProperties()
        print(props['projectName'] + ': ' + props['versionNumber'])
        print('Gradle Version: ' + props['gradle.version'])
        print('Java Build Version: ' + props['buildVersion'])

    def percent(x, y):
        return Utils.outOf(x, x + y)

    def outOf(x, y):
        if (x == 0):
            return 0
        return round((x / y) * 100, 2)

    def clean():
        print("Cleaning the project")
        print(Utils.halfRows())

        cmd = str(os.path.join(os.path.abspath(os.curdir), 'gradlew')) + ' clean'
        print('Cleaning the project using | ./gradlew clean ', end='| ', flush=True)
        try:
            proc = subprocess.Popen(
                shlex.split(cmd),
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE
            )
            stdout, stderr = proc.communicate()
        except Exception as e:
            print('Unknown Error ' + str(e))
            sys.exit(0)

        stdout, stderr = stdout.decode('utf-8'), stderr.decode('utf-8')

        if 'BUILD SUCCESSFUL' not in stdout:
            print('The build broke, exiting now')
            sys.exit(0)
        print('Successful')

    def build():
        print("Building the project")
        print(Utils.halfRows())
        argz = ' clean build -x test '
        print('Building the project using | ./gradlew' + str(argz), end='| ', flush=True)
        start = time.time()
        cmd = str(os.path.join(os.path.abspath(os.curdir), 'gradlew')) + str(argz)
        try:
            proc = subprocess.Popen(
                shlex.split(cmd),
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE
            )
            stdout, stderr = proc.communicate()
        except Exception as e:
            print('Unknown Error ' + str(e))
            sys.exit(0)

        stdout, stderr = stdout.decode('utf-8'), stderr.decode('utf-8')

        if 'BUILD SUCCESSFUL' not in stdout:
            print('The build broke, exiting now')
            sys.exit(0)

        print('Successful | ' + str(int(time.time() - start)) + ' (s)')

        print('Copying the jar file to the current directory ', end='| ', flush=True)

        projectName = Loading.getProperties()['projectName']
        os.system('cp build/libs/' + projectName + '*.jar ./' + projectName + '.jar')

        if os.path.exists(projectName + '.jar'):
            print("Successful")
        else:
            print("Failure")

    # Setting the arguments to be handled by the parser
    def arguments(parser, curChoices):

        parser.add_argument("switch", choices=curChoices, nargs='?', default='help',
                            help='Use the q flag to show detailed help')
        parser.add_argument("-v", action='store_true', help='Print the project version')

        return parser

    def help():
        Utils.printVersion()
        print(Utils.halfRows())
        Utils.routingInfo('./cryptoguard.py')
        sys.exit(0)

    def routing(switch):
        offline = not os.path.exists(gitPath)
        func = routers.get(switch, Utils.routingInfo)
        if offline and not func['offline']:
            print('Cannot run ' + switch + ' in Offline Mode')
            sys.exit(0)
        return func

    def routingInfo(useage=''):
        global offline
        for val in routers:
            if (not offline or (offline and routers[val]['offline'])):
                print('\t' + str(useage) + ' ' + str(val) + ' ' + str(routers[val]['def']))
        return

    def start():
        print("Running the cryptoguard helper program")
        global offline
        if offline:
            print('This is running in an offline mode')
        curChoices = list(routers.keys())
        args = Utils.arguments(argparse.ArgumentParser(), curChoices).parse_args()
        if (args.v):
            Utils.printVersion()
            sys.exit()

        print(Utils.splitRows() + '\n')

        Utils.routing(args.switch)["func"]()


# endregion
# region envVars
class envVars(object):
    def checkVariables(outFile='_cryptoguard.source'):
        Utils.splitRows()
        fail = True

        global android
        global java7
        global java

        exports = []

        if (not android or not os.path.exists(android)):
            print("ANDROID_HOME is not set")
            yaynay = input('Do you want to set it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to JAVA_HOME? ').strip()
                exports += ['export ANDROID_HOME=' + newHome]
        else:
            print("ANDROID_HOME is set to " + android)
            yaynay = input('Do you want to reset it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to ANDROID_HOME? ').strip()
                exports += ['export ANDROID_HOME=' + newHome]

        if (not java7 or not os.path.exists(java7)):
            print("JAVA7_HOME is not set")
            yaynay = input('Do you want to set it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to JAVA7_HOME? ').strip()
                exports += ['export JAVA7_HOME=' + newHome]
        else:
            print("JAVA7_HOME is set to " + java7)
            yaynay = input('Do you want to reset it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to JAVA7_HOME? ').strip()
                exports += ['export JAVA7_HOME=' + newHome]

        if (not java or not os.path.exists(java)):
            print("JAVA_HOME is not set")
            yaynay = input('Do you want to set it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to JAVA_HOME? ').strip()
                exports += ['export JAVA_HOME=' + newHome]
        else:
            print("JAVA_HOME is set to " + java)
            yaynay = input('Do you want to reset it (y/n-default)? ') == 'y'
            if yaynay:
                newHome = input('What is the new path to JAVA_HOME? ').strip()
                exports += ['export JAVA_HOME=' + newHome]

        if len(exports) > 0:
            with open(outFile, 'w') as out:
                for arg in exports:
                    out.write(arg + '\n')
            os.chmod(outFile, 0o777)
            print("Please run the following command: source " + outFile)

        return fail


# endregion
# region ArgUtils
class argsUtils(object):
    def basicBuildCommand():
        print("Building a basic command")
        print('Please Note this does not verify whether the directory/files exist')
        print("Common abreviations:")
        print("\tn = no")
        print("\ty = yes")
        print(Utils.halfRows())

        projectName = Loading.getProperties()['projectName']
        cmd = 'java -jar ' + projectName + ' '

        lookup = Loading.parseEngineType()
        for value in lookup.values():
            print(value['name'] + ' flag: ' + value['flag'])
        print()

        typeOfProject = input("What type of project by flag (jar/apk/source/java/class)? ")
        if typeOfProject not in [x['flag'] for x in lookup.values()]:
            print("Please enter a valid type of project");
            sys.exit()
        cmd += '-in ' + typeOfProject + ' '

        for key, value in lookup.items():
            if value['flag'] == typeOfProject:
                typeOfProject = value

        print()

        print(Utils.halfRows())

        source = input(
            "What file/project directory would you like to scan (java/class files please enter class path or single file)? ")
        cmd += '-s ' + source + ' '
        print()

        if (typeOfProject['flag'] != 'dir' and not source.endswith(typeOfProject['extension']) and not source.endswith(
                ".in")):
            print("Please enter a valid file for Scanning");
            sys.exit()

        print(Utils.halfRows())

        global android
        global java7
        global java

        javaHome = sdkHome = None
        if (typeOfProject['flag'] == 'apk'):
            print("Current ANDROID_HOME is set to " + android)
            sdkHome = input("Would you like to specify the Android Home (n/sdk directory)? ")
            print()
            if sdkHome and sdkHome != 'n':
                cmd += '-android ' + sdkHome + ' '
        if (typeOfProject['flag'] == 'apk' or typeOfProject['flag'] == 'jar' or typeOfProject['flag'] == 'class'):
            print("Current JAVA_HOME is set to " + java)
            javaHome = input("Would you like to specify the Java 8 Home (n/jdk directory)? ")
        if (typeOfProject['flag'] == 'dir' or typeOfProject['flag'] == 'java'):
            print("Current JAVA7_HOME is set to " + java7)
            javaHome = input("Would you like to specify the Java 7 Home (n/jdk directory)? ")
        print()

        if javaHome and javaHome != 'n':
            cmd += '-java ' + javaHome + ' '

        dependency = input("Would you like to add a dependency folder (n/directory)? ")
        if (dependency != 'n'):
            cmd += '-in ' + dependency + ' '
        print()

        main = input("Would you like to specify the main class (n/file)? ")
        if (main != 'n'):
            cmd += '-main ' + main + ' '
        print()

        print(Utils.halfRows())
        print('Output formats')
        lookup = Loading.parseOutputType()
        for value in lookup.values():
            print(value['type'] + " flag: " + value['flag'] + ' extension: ' + value['outputExtension'])
        print()

        outType = input("Would you like to specify the output format by flag (n/SX/L/D)? ")
        if (outType != 'n'):
            if outType not in [x['flag'] for x in lookup.values()]:
                print('Please enter a valid output format');
                sys.exit(0)
            cmd += '-m ' + outType + ' '
            for key, value in lookup.items():
                if value['flag'] == outType:
                    lookup = value
        print()

        foil = input("Would you like to specify the output file (n/file)? ")
        if (foil != 'n'):
            if not foil.endswith(lookup['outputExtension']):
                print('Please enter a valid file for the output type.');
                sys.exit(0)
            cmd += '-o ' + foil + ' '
        print()

        if (outType == 'n' and foil != 'n' or outType != 'n' and foil == 'n'):
            print('Please enter both the output format and the output file.');
            sys.exit(0)

        if foil != 'n':
            overwrite = input("Would you like to overwrite the output file (y/n)? ") == 'y'
            if (overwrite):
                cmd += '-new '
            print()

        print(Utils.halfRows())
        logging = input("Would you like to set the logging high/medium/low/off/no (h/m/l/o/n)? ")
        if (logging == 'h'):
            cmd += '-vv '
        elif (logging == 'm'):
            cmd += '-v '
        elif (logging == 'o'):
            cmd += '-vx '
        print()

        print(Utils.halfRows())

        result = input("Would you like to stream the results (y/n)? ") == 'y'
        if (result):
            cmd += '-st '
        print()

        result = input("Would you like to the time measurement to the output (y/n)? ") == 'y'
        if (result):
            cmd += '-t '
        print()

        result = input("Would you like to format the results (y/n)? ") == 'y'
        if (result):
            cmd += '-n '
        print()

        result = input("Would you like to add heuristics to the results (y/n)? ") == 'y'
        if (result):
            cmd += '-H '
        print()

        result = input("Would you like to specify the depth of heuristics to the results (y/n)? ") == 'y'
        if (result):
            result = input("What number? ")
            try:
                result = int(result)
            except ValueError:
                print("Please enter a valid depth number.");
                sys.exit(0)
            cmd += '-depth ' + str(result) + ' '
        print()

        print(Utils.halfRows())
        print('The build up command is:' + cmd)

        print(Utils.halfRows())
        run = input('Would you like to run the command (y/n)?') == 'y'
        if (run):
            os.system(cmd)

    def displayProjectTypes():
        print("Can scan the following project types:")
        print(Utils.halfRows())
        for key, value in Loading.parseEngineType().items():
            print('\t' + value['name'] + " accepts a " + value['extension'])

    def displayOutputTypes():
        print("Can write the results as the following output types:")
        print(Utils.halfRows())
        for key, value in Loading.parseOutputType().items():
            print('\t' + value['type'] + " accepts a " + value['outputExtension'] + ' file output type.')

    def displayExceptionTypes():
        print("Uses the following error codes:")
        print(Utils.halfRows())
        for key, value in Loading.parseExceptionType().items():
            print('\t' + value['id'] + " is a " + value['messageType'] + ' Exception.')

    def writeUsage():
        argsUtils.helpfulArgs(writeOut=True)

    def helpfulArgs(filter=None, writeOut=False, writeOutFile='USAGE.md'):
        projectName = Loading.getProperties()['projectName']
        projectVersion = Loading.getProperties()['versionNumber']

        data = Loading.getExampleArgs()

        grouping = {
            'General': {},
            'APK': {},
            'JAR': {},
            'Java': {},
            'Project': {},
            'Class': {}
        }
        for key, value in data.items():
            if filter is None or key.contains(filter):
                grouping[value['type']][key] = value

                if not writeOut:
                    print('Example ' + key)

                    if ('Java File' in key):
                        print('CURRENTLY UNSTABLE')

                    print(Utils.halfRows())
                    print("java -jar " + projectName + ".jar " + value['arg'])
                    print(value['explanation'])
                    print()

        if writeOut:
            print("Writing the Usage file")
            print(Utils.halfRows())
            with open(writeOutFile, 'w') as out:
                out.write("# " + projectName + ":" + projectVersion + " General Usage\n")

                out.write("## Raw Arguments\n")
                out.write(
                    "**Please Note** the general arguments can be used in any order and in various combinations (except for the version argument)\n")
                lookup = argsUtils.parseArgs()
                longestOneCol = max(len(x['id']) for x in lookup.values())
                longestTwoCol = max(len(x['defaultArg']) for x in lookup.values())
                longestThreeCol = max(len(x['desc']) for x in lookup.values())
                out.write('| Id | Default | Description |\n')
                out.write('|-' + Utils.stringMult(longestOneCol, '-') + '|' + Utils.stringMult(longestTwoCol,
                                                                                               '-') + '|' + Utils.stringMult(
                    longestThreeCol, '-') + '|\n')
                for key, value in lookup.items():
                    if key.strip() != 'NOEXIT':
                        arg = value['defaultArg']
                        if arg == 'null':
                            arg = 'Flag'
                        out.write(
                            '| -' + value['id'] + ' | ' + arg + ' | ' + value['desc'].replace(")", "").replace(";",
                                                                                                               "") + ' |\n')

                out.write('---\n')

                out.write("## Exceptions\n")
                lookup = argsUtils.parseExceptionType()
                longestLength = max(len(x['messageType']) for x in lookup.values())
                out.write('| error code | error type |\n')
                out.write('|------------|' + Utils.stringMult(longestLength, '-') + '|\n')
                for key, value in lookup.items():
                    out.write('| ' + value['id'] + ' | ' + value['messageType'] + ' |\n')

                out.write('---\n')

                out.write('## Format Types (used with the -in argument)\n')
                lookup = argsUtils.parseEngineType()
                longestOneCol = max(len(x['name']) for x in lookup.values())
                longestTwoCol = max(len(x['flag']) for x in lookup.values())
                longestThreeCol = max(len(x['helpInfo']) for x in lookup.values())
                out.write('| Name | Flag | Description |\n')
                out.write('|' + Utils.stringMult(longestOneCol, '-') + '|' + Utils.stringMult(longestTwoCol,
                                                                                              '-') + '|' + Utils.stringMult(
                    longestThreeCol, '-') + '|\n')
                for key, value in lookup.items():
                    out.write('| ' + value['name'] + ' | ' + value['flag'] + ' | ' + value['helpInfo'].replace(")",
                                                                                                               "").replace(
                        ";", "") + ' |\n')

                out.write('---\n')

                out.write('## Output Types (used with the -m argument, optional)\n')
                lookup = argsUtils.parseOutputType()
                longestOneCol = max(len(x['type']) for x in lookup.values())
                longestTwoCol = max(len(x['flag']) for x in lookup.values())
                out.write('| Name | Flag |\n')
                out.write(
                    '|' + Utils.stringMult(longestOneCol, '-') + '|' + Utils.stringMult(longestTwoCol, '-') + '|\n')
                for key, value in lookup.items():
                    out.write('| ' + value['type'] + ' | ' + value['flag'] + ' |\n')

                out.write('---\n')

                out.write(
                    "\nListed Below are various examples of cmd line arguments with their explanations grouped by their project type.")
                out.write("\n\n")
                for key, value in grouping.items():
                    out.write("## " + key + "\n")
                    out.write("---\n")
                    for key, value in value.items():
                        out.write("### " + key + "\n")
                        out.write("> java -jar " + projectName + ".jar " + value['arg'] + "\n\n")
                        out.write(value['explanation'] + "\n\n")
                    out.write("\n\n")
            print('Written to ' + writeOutFile)

    def readRawArgs():
        projectName = Loading.getProperties()['projectName']
        rawArgs = Loading.parseArgs()

        for key, value in rawArgs.items():
            if key.strip() != 'NOEXIT':
                required = ''
                if (value['Required']):
                    required = '* '

                print("Name: " + key.strip())
                print(required + "Arg: -" + value['id'])
                print(value['desc'])

                if value['defaultArg'] != 'null':
                    print('Default: ' + value['defaultArg'])
                    print('Usage: java -jar ' + projectName + ' -' + value['id'] + ' ' + value['defaultArg'])
                else:
                    print('Usage: java -jar ' + projectName + ' -' + value['id'])

                if key.strip() == 'FORMAT':
                    print('\nDifferent Options available for project types:')
                    for key, value in Loading.parseEngineType().items():
                        print('\t' + value['flag'] + ": " + value['name'] + " " + value['helpInfo'])
                elif key.strip() == 'FORMATOUT':
                    print('\nDifferent Options available for output format:')
                    for key, value in Loading.parseOutputType().items():
                        print('\t' + value['flag'] + ": " + value['type'])

                print()

        print('Exceptions')
        for key, value in Loading.parseExceptionType().items():
            print(value['id'] + ': ' + value['messageType'])


# endregion
# region TestUtils
class TestUtils(object):

    def pullTests(dir=os.path.join(os.path.abspath(os.curdir), "src", "test")):
        dyct = {}

        for root, dirnames, filenames in os.walk(dir):
            for filename in filenames:
                if (filename.endswith('.java')):
                    fulFoil, className = os.path.join(root, filename), filename.replace('.java', '')
                    with open(fulFoil, 'r') as foil:
                        line = foil.readline()
                        while line:
                            if line.__contains__('@Test'):
                                if (className not in dyct):
                                    dyct[className] = []

                                liveTest, method = not line.__contains__('//@Test'), foil.readline()
                                start, end = method.find("public void "), method.find("(")

                                if (start != -1 and end != -1):
                                    testName = method[(start + len("public void ")):end]
                                    dyct[className].append({'testName': testName, 'live': liveTest})

                            line = foil.readline()
        return dyct

    def test():
        test = input("Please enter the Class.testName to be run: ")
        print("Running the test")
        print(Utils.halfRows())
        if (TestUtils.runTest(test)):
            print("Passed")
        else:
            print("Failed")

    def runTest(test):
        cmd = str(os.path.join(os.path.abspath(os.curdir), 'gradlew')) + ' test --tests ' + str(
            test) + ' --info --rerun-tasks'
        try:
            proc = subprocess.Popen(
                shlex.split(cmd),
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE
            )
            stdout, stderr = proc.communicate()
        except Exception as e:
            print('Unknown Error ' + str(e))
            sys.exit(0)

        stdout, stderr = stdout.decode('utf-8'), stderr.decode('utf-8')
        global failFast

        if 'BUILD SUCCESSFUL' in stdout:
            return True
        elif 'BUILD FAILED' in stderr:
            if failFast:
                print(stderr)
                print('Failing on ' + str(test));
                sys.exit(0)
            return False
        else:
            print('Unknown Error: ')
            if failFast:
                print('Failing on ' + str(test));
                sys.exit(0)
            return False

    def activeSkipTests(dyct=pullTests()):
        skippedTests = liveTests = 0
        for key, value in dyct.items():
            skippedTests += sum([not x['live'] for x in value])
            liveTests += sum([x['live'] for x in value])
        return liveTests, skippedTests

    def getHelpTests(dyct=pullTests()):
        liveTests, skippedTests = TestUtils.activeSkipTests(dyct)
        grouping = {
            'APK': {},
            'JAR': {},
            'JAVA': {},
            'SOURCE': {},
            'CLASS': {}
        }
        for key, value in dyct.items():
            if ('_' in key):
                testType = key.strip().strip().split('_')[1]
                grouping[testType]['Skipped'] = sum([not x['live'] for x in value])
                grouping[testType]['Active'] = sum([x['live'] for x in value])
        return liveTests, skippedTests, grouping

    def helptests(dyct=pullTests()):
        liveTests, skippedTests, grouping = TestUtils.getHelpTests(dyct)

        totalTests = liveTests + skippedTests
        print("General Information")
        print(Utils.halfRows())
        print("Total Tests: " + str(totalTests))
        print("Live Tests: " + str(liveTests) + ' : ' + str(Utils.outOf(liveTests, totalTests)))
        print("Deactivated Tests: " + str(skippedTests) + ' : ' + str(Utils.outOf(skippedTests, totalTests)))
        print()

        for key, value in grouping.items():
            print(key)
            print(Utils.halfRows())
            print("Live Tests: " + str(value['Active']) + ' : ' + str(Utils.outOf(value['Active'], totalTests)))
            print(
                "Deactivated Tests: " + str(value['Skipped']) + ' : ' + str(Utils.outOf(value['Skipped'], totalTests)))
            print()

    # status = ['Pass','Fail','Skip']
    def addTestResult(dyct, type, status, time, name, timeReRun):

        dyct[type][status] += [{
            'name': name,
            'timeTaken': time,
            'timesReRun': timeReRun
        }]

        return dyct

    def reRunTestResult(dyct, type, fail, testName, timeReRun, newTime):
        item = [item for item in dyct[type]['Fail'] if item['name'] == testName][0]

        if (not fail):
            item['timesReRun'] = timeReRun
            item['timeTaken'] = newTime
            dyct[type]['Pass'] += item
            dyct[type]['Fail'].remove(item)

        return item

    def testType():
        print("About to run a specific set of tests")
        dyct = TestUtils.pullTests()

        liveTests, skippedTests, grouping = TestUtils.getHelpTests(dyct)
        runningTests = 0
        for key, value in grouping.items():
            print(str(key) + " : Active Tests " + str(value['Active']))
            runningTests += value['Active']

        print('OTHER : Active Tests ' + str(liveTests - runningTests))

        options = list(grouping.keys())
        options += ['OTHER']

        option = input("Please enter what kind of test you would like to have run from " + str(options) + " : ").upper()
        if (option not in options):
            print('Option is not valid')
            sys.exit()
        TestUtils.tests(dyct=dyct, filter=option)

    def tests(dyct=pullTests(), filter=None):
        print("Running all of the available tests.")
        dyct = OrderedDict(sorted(dyct.items()))

        results = {
            'APK': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            },
            'JAR': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            },
            'JAVA': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            },
            'SOURCE': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            },
            'CLASS': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            },
            'OTHER': {
                'Pass': [],
                'Fail': [],
                'Skip': []
            }
        }

        liveTests, skippedTests = TestUtils.activeSkipTests(dyct)
        numTests = liveTests + skippedTests

        passed, failed, skipped, testNum, rerun, rerunLim = 0, 0, 0, 1, 0, 1
        start, failedTests, verbose, skippedTests = time.time(), [], False, []

        global android
        global java7
        global java

        android_set, java7_set, java_set = android is not None, java7 is not None, java is not None

        if not java_set:
            print('No JAVA_HOME environment found, please set this')
            sys.exit(1)

        if (not android_set or not java7_set):
            print('==============================')
            if not android_set:
                print('Skipping All Android Tests, no ANDROID_HOME env found')
            else:
                print('Skipping All Project and Java file Tests, no JAVA7_HOME env found')

        print('==============================')
        for key, value in dyct.items():
            subpassed, subfailed, subskipped = 0, 0, 0

            if ('_' in key):
                testType = key.strip().strip().split('_')[1]
            else:
                testType = 'OTHER'

            for test in value:
                status, testTime = 'Skip', 0

                envSkip = (not android_set and key.endswith('_APK')) or (
                        not java7_set and (key.endswith('SOURCE') or key.endswith('JAVA')))

                testName, startTest = str(key) + '.' + str(test['testName']), time.time()
                skipTestTime = False
                strTest = str(testNum)
                if testNum < 10:
                    strTest = '0' + str(strTest)
                print(str(strTest) + '/' + str(numTests) + ' | ' + str(testName) + ' | ', end='', flush=True)
                if not test['live'] or envSkip or (filter is not None and filter != testType):
                    skipped = skipped + 1
                    subskipped = subskipped + 1
                    skipTestTime = True
                    print('Skip | ', end='', flush=True)
                    skippedTests += [testName]
                else:
                    testResult = TestUtils.runTest(testName)
                    if (testResult):
                        passed = passed + 1
                        subpassed = subpassed + 1
                        print('Pass | ', end='', flush=True)
                        status = 'Pass'
                    else:
                        failed = failed + 1
                        subfailed = subfailed + 1
                        print('Fail | ', end='', flush=True)
                        failedTests += [testName]
                        status = 'Fail'
                testNum = testNum + 1
                if (not skipTestTime):
                    testTime = int(time.time() - startTest)
                else:
                    testTime = 0
                print(Utils.prettyTime(testTime))

                results = TestUtils.addTestResult(results, testType, status, testTime, testName, 0)
            if verbose:
                print(
                    str(key) + ' Skipped/Passed/Fail/(% passed): ' + str(subskipped) + '/' + str(subpassed) + '/' + str(
                        subfailed) + '/% ' + str(Utils.percent(subpassed, subfailed)))
        while rerun < rerunLim:
            print('Rerunning the failed tests')
            for test in failedTests:
                print(test, end=' | ', flush=True)
                start = time.time()
                result = TestUtils.runTest(test)
                end = time.time()
                testTime = int(end - start)
                if result:
                    result = 'Pass'
                    failed = failed - 1
                    failedTests.remove(test)

                    if ('_' in key):
                        testType = key.strip().strip().split('_')[1]
                    else:
                        testType = 'OTHER'

                    results = TestUtils.reRunTestResult(results, testType, False, test, rerun, testTime)
                else:
                    result = 'Fail'
                print(str(result) + ' | ' + Utils.prettyTime(testTime))
            rerun = rerun + 1
        print('==============================')
        print('Time Taken : ' + Utils.prettyTime(int(time.time() - start)))
        print('Skipped Tests: ' + str(skipped))
        print('Passed Tests: ' + str(passed))
        print('Failed Tests: ' + str(failed))
        print('Total Tests: ' + str(numTests))
        print('Total Tests Passed: %' + str(Utils.percent(passed, failed)))
        print('Total Tests Failed: %' + str(Utils.percent(failed, passed)))
        print('==============================')
        if failed > 0:
            print('Failed Tests')
            for test in failedTests:
                print(test)
            print('==============================')
        if len(skippedTests) > 0 and filter is None:
            print('Skipped Tests')
            for test in skippedTests:
                print(test)
            print('==============================')

        # if failed > 0:
        #    if failed > 255:
        #        failed = 255
        #    sys.exit(failed)
        # else:
        #    sys.exit(0)

        return results


# endregion
# region Routers
'''####################################
#The dictionary containing the working functions and their respective definitions
'''  ####################################
routers = {
    'rawArgs': {
        "func": argsUtils.readRawArgs,
        "def": "Prints the raw arguments of the program.",
        'offline': True
    },
    'exampleArgs': {
        "func": argsUtils.helpfulArgs,
        "def": "Sample examples of running the program with arguments and explanations.",
        'offline': True
    },
    'writeUsage': {
        "func": argsUtils.writeUsage,
        "def": "Write the example args to a markdown file (USAGE.md).",
        'offline': True
    },
    'checkEnv': {
        "func": envVars.checkVariables,
        "def": "Checks (suggestions to set them if missing) the environment variables.",
        'offline': True
    },
    'projectType': {
        "func": argsUtils.displayProjectTypes,
        "def": "Displays some information about the project types available to scan.",
        'offline': True
    },
    'outputType': {
        "func": argsUtils.displayOutputTypes,
        "def": "Displays some information about the various output types available to write out as.",
        'offline': True
    },
    'exceptionType': {
        "func": argsUtils.displayExceptionTypes,
        "def": "Displays information about the standardized exceptions.",
        'offline': True
    },
    'clean': {
        "func": Utils.clean,
        "def": "Cleans the project.",
        'offline': False
    },
    'build': {
        "func": Utils.build,
        "def": "Builds the project.",
        'offline': False
    },
    'hash': {
        "func": Utils.hash,
        "def": "Determines the hash of a freshly built project.",
        'offline': False
    },
    'buildCmd': {
        "func": argsUtils.basicBuildCommand,
        "def": "Build the command to run, NOTE experimental!",
        'offline': True
    },
    'test': {
        "func": TestUtils.test,
        "def": "Runs a specified test.",
        'offline': False
    },
    'tests': {
        "func": TestUtils.tests,
        "def": "Runs all of the tests crawled.",
        'offline': False
    },
    'testType': {
        "func": TestUtils.testType,
        "def": "Runs a specified set of tests.",
        'offline': False
    },
    'testsHelp': {
        "func": TestUtils.helptests,
        "def": "Shows helpful information about the tests crawled.",
        'offline': False
    },
    # 'survey': {
    #    "func": Utils.printSurveyURL,
    #    "def": "Displays the url to the survey if it is active.",
    #    'offline': True
    # },
    'help': {
        "func": Utils.help,
        "def": "Displays helpful information to the user if it's the first time running.",
        'offline': True
    },
    'offline': {
        "func": Reading.overWriting,
        "def": "Write enough of the information internally for this script to run stand-alone.",
        'offline': False
    }
}
#endregion

def signal_handler(sig, frame):
    print('\nExiting...')
    sys.exit(0)


'''####################################
#The main runner of this file, intended to be ran from
'''  ####################################
if __name__ == '__main__':
    signal.signal(signal.SIGINT, signal_handler)

    Utils.start()