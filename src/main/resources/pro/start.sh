#!/bin/bash
echo "start ..."
java -jar local_repo/rpn-1.0.jar -Xms2048m -Xmx4096m -Xss256k -XX:PermSize=1024m -XX:SurvivorRatio=4 -XX:+PrintGCTimeStamps