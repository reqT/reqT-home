title=reqT Download
date=2014-08-01
type=page
status=published
~~~~~~

<a href="http://reqt.org/reqT.jar" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-cloud-download"></span> Download reqT.jar </a>  30MB v3.1.x-SNAPSHOT latest stable [all versions](history.html)

###<a id="how-to-run">How to run reqT:</a>

1. Download the reqT.jar above and save it in some directory

2. Open a terminal, navigate to that directory and type this in terminal: 
    ```
    java -jar reqT.jar
    ```
    This requires java. To check and install java, see [below](#java). If you have java installed you will see a message similar to this:
    ```
    ** Welcome to reqT version 3.1.4
    ** Snapshot build number: 566
    ** Scala version 2.12.8
    ** Java  version 1.8.0_232 OpenJDK 64-Bit Server VM

    **                  _______
    **                 |__   __|
    **   _ __  ___   __ _ | |      reqT - a requirements engineering tool
    **  |  __|/ _ \ / _  || |      http://reqT.org
    **  | |  |  __/| (_| || |      (c) 2010-2019, Lund University
    **  |_|   \___| \__  ||_|      Open Source BSD-2-clause license
    **                 | |
    **                 |_|

    ** Type  edit      to start model editor gui
    ** Type  :help     for help on the Scala interpreter
    ** Type  :pa       to enter paste mode
    ** Type  :q        to exit when all sub-threads are done
    ** Type  sys.exit  to exit and terminate all threads
    ** Type  Feature?  to get help on a concept, e.g. Feature

    reqT> 
    ```

3. Type this into the console by the `reqT>` prompt and press enter:

        println("Hello reqT!") 
        
4. Then try out the "Hello reqT" example [here](http://reqt.org/documentation.html#hello)    
        
###<a id="java"> If reqT does not start:</a>

* Check if you have Java 1.8.x installed by opening a terminal window (bash, cmd, or powershell etc.) and type this command:
    ```
    java -version 
    ```    
     This should print something similar to 
    ```
    java version "1.8.0_232"
    ```
     
* If the above step failed then install Java 1.8 from here: 
    * [Windows/Mac: scroll down to Java SE8](http://www.oracle.com/technetwork/java/javase/downloads) 
    * [linux install openjdk-8] (http://openjdk.java.net/install/index.html) 

