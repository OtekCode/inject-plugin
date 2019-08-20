# InjectPlugin - Kotlin DI in minecraft servers!
#### Description
- This plugin allows to use SOLID rules in bukkit and bungee with Dependency Injection
#

#### Dependencies:
- ##### KotlinPlugin [Author](https://github.com/OtekPlay) [GitHub](https://github.com/OtekPlay/kotlin-plugin) [Spigot](https://www.spigotmc.org/resources/kotlinplugin-allow-to-use-kotlin-corountines-in-your-plugins.70526/) [Download](https://github.com/OtekPlay/kotlin-plugin/releases/download/1.0.0/kotlin-plugin-1.0.0.jar)
### How to use?
##### 1. Add repository to your pom.xml
#
```
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
```
##### 2. Add dependency to your pom.xml
#
```
<dependency>
    <groupId>com.github.OtekPlay</groupId>
    <artifactId>inject-api</artifactId>
    <version>1.0.0</version>
</dependency>
```
##### 3. Add depend to your yaml file
#
```
depend: [InjectPlugin]
```
##### 4.  Download [InjectPlugin](https://github.com/OtekPlay/inject-plugin/releases/download/1.0.0/inject-plugin-1.0.0.jar) and put inside your server plugins folder.
### Compile
```
git clone https://github.com/OtekPlay/inject-plugin
```
```
mvn clean install
```

#### Examples soon, you can check below in test how to use library.
#### [Tests](https://github.com/OtekPlay/inject-plugin/blob/master/inject-impl/src/test/java/ScopeTest.kt)
