# Introduction
This is a java client implementation of the services exposed by AfriGIS.

Please see the official [online documentation first](https://developers.afrigis.co.za/).

# Building
First thing to note: you [need valid service credentials](https://developers.afrigis.co.za/sign-up/) of the unit tests to pass.

You will need this to USE the services in ANYWAY, so just go [register](https://developers.afrigis.co.za/sign-up/)

These credentials can be supplied to the unit tests as environment variables, under
the keys "ag.services.test.secret" and "ag.services.test.clientId".

I am sure you are clever enough to figure out which is which.

You can feed your credentials to the maven build project by using the 
[normal -D command line option](http://books.sonatype.com/mvnref-book/reference/running-sect-options.html)

Then, run `mvn clean package` - and if all goes well, that should produce the JAR you are looking for.