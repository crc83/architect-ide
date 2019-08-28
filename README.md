
[![Build Status](https://semaphoreci.com/api/v1/crc83/architect-ide/branches/master/badge.svg)](https://semaphoreci.com/crc83/architect-ide)

# About

Architect Ide The aim of project is to give a tool that support architect in architecture vision preparation.
This tool should help to check if all risks, concerns and constraints are addressed to specific epics. 
This tool should support bidirectional sync with JIRA or other task tracking tool. 
This tool should be highly extensible, so architect may add own rules for validation or outcoming document generation.

# Looks like a plan

What is done and what shall be done
1. [DONE] Implement ANTLR parser to parse WBS into model
2. Implement syntax highlite and something like code completition
3. Implement validation of document, to highlite open issues and risks e.t.c.
4. Implement export to word/pdf e.t.c. Define plugin API for this.
5. Implement synchronization strategy with jira e.t.c.

# Licence

Apache 2.0 license 

# Decisions made

1. Shall I go with maven build tool or gradle build tool? (Maven)

2. What license shall I use? (Apache 2.0)


## 1. Shall I go with maven build tool or gradle build tool?

IMHO maven plugin requires less efforts to integrate.

Also I hope that maven support in eclipse would be better.

### Maven has *tycho* plugin for build automation

It's described here: http://www.vogella.com/tutorials/EclipseTycho/article.html

And referenced here: https://stackoverflow.com/questions/6830399/how-to-build-an-eclipse-plugin-with-maven

Current version is: 1.2.0

Last update: 29 May 2018

Implemented by: SAP AG

Licence: EPL v 1.0

### Gradle *Wuff* plugin

Is referenced here: https://stackoverflow.com/questions/18952641/building-eclipse-plugins-with-gradle

Current version: 0.0.14 

Last update: 03 June 2015

#### More robust plugin is *bnd-platform* 

It's described here: https://github.com/stempler/bnd-platform

Latest version:  1.7.0

Last update: 31 October 2018

Licence: Apache 2.0

## 2. What license shall I use?

After investigation and reading descussion at: https://habr.com/post/243091/


