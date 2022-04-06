# info832_unit-test
## Sonarcloud report

To generate sonarcloud report, we have connected our project to sonar cloud.
And we have used [Bitegarden Report Generation](https://www.bitegarden.com/sonarcloud-report) to generate report.

### How generate report ?

Change SonarCloud token in config.properties
```
sonar.token=Enter your sonarcloud token here
sonar.projectKey=M4verickFr_info832_unit-test
sonar.organizationKey=maverick
report.type=3
```

Running *bitegarden-sonarcloud-report.jar* with config file
```sh
java -Dconfig.file=config.properties -jar bitegarden-sonarcloud-report.jar
```

To get help with *bitegarden-sonarcloud-report.jar* and see other report type, use
```sh 
java -jar bitegarden-sonarcloud-report.jar --help
```

## Troubleshooting

The *bitegarden-sonarcloud-report.jar* file contains a license available only 14 days.
You can download a new version on the official website  [here](https://www.bitegarden.com/sonarcloud-report)