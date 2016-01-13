
# JSON marshalling/unmarshalling of java.time in spring boot

Setup spring boot / Jackson to marshall/unmarshall java.time

By default, spring boot and json jackson serializes DateTime as follows:

```
{
    "created": {
        "chronology": {
            "calendarType": "iso8601",
            "id": "ISO"
        },
        "dayOfMonth": 13,
        "dayOfWeek": "WEDNESDAY",
        "dayOfYear": 13,
        "hour": 17,
        "minute": 14,
        "month": "JANUARY",
        "monthValue": 1,
        "nano": 703000000,
        "second": 32,
        "year": 2016
    }
}
```

1.- Add dependency:

```
<dependency>
	<groupId>com.fasterxml.jackson.datatype</groupId>
	<artifactId>jackson-datatype-jsr310</artifactId>
</dependency>
```


After customising the serializations, looks like:

```
{
  "created" : "2016-01-13T17:33:05.307"
}
```