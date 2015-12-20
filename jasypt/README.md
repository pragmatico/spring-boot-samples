# Jasypt

Jasypt Spring Boot provides Encryption support for property sources in Spring Boot Applications, 
ideal to encrypt password in properties/config files.

Maven dependency
---------------

        <!-- Jaypt - encrypt properties -->
        <dependency>
            <groupId>com.github.ulisesbocchio</groupId>
            <artifactId>jasypt-spring-boot</artifactId>
            <version>1.2</version>
        </dependency>



Encrypt passwords in properties files
---------------

Steps to generate passwords using Jasypt tool:

1. 	Download jasypt:

	```
	wget http://sourceforge.net/projects/jasypt/files/jasypt/jasypt%201.9.2/jasypt-1.9.2-dist.zip
	```
	
2. Unzip jasypt:

	```
	unzip jasypt-1.9.2-dist.zip
	```

3.	Encrypt passwords:
	
	Sample encrypting the input PASSWORD

	```
	sh bin/encrypt.sh input=<PASSWORD> password=<SECRET> algorithm=PBEWithMD5AndDES
	```


