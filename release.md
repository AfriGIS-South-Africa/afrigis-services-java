# Release process
[Official references.](http://central.sonatype.org/pages/apache-maven.html)

## Assumptions
- You have a  valid JIRA account
- Your JIRA account is setup with permissions to release
- You have verified that unit/integration tests are passing (`release` profile skips unit tests)


## Steps
CD into root of project

### Adjust the version
See 
- [semver](http://semver.org/)
- [SO](http://stackoverflow.com/questions/5726291/updating-version-numbers-of-modules-in-a-multi-module-maven-project) 
- [docs](http://www.mojohaus.org/versions-maven-plugin/)

If, for example, your new release version is 99.99.99, run:
`mvn versions:set -DnewVersion=99.99.99`

If all seems well, run
`mvn versions:commit`

Commit the changes to SCM.

### Release
Run:

`mvn -P release  clean deploy`

### Wait a while
It takes some time (few minutes? more?) for everythign to sync up on the repo side.

You can check if things are available [by searching maven central.](http://mvnrepository.com/search?q=afrigis)


