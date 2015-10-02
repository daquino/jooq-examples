#!/usr/bin/env bash

BASEDIR=$(dirname $0)
cd $BASEDIR

java -classpath "lib/*" org.jooq.util.GenerationTool conf/jooq-config.xml
