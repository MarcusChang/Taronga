# Taronga
BPT_Pure Scaffold

纯JAVA技术栈业务层自动化测试框架集，Maven工程结构，集成WebDriver, Junit驱动，使用Jenkins集成，报告使用surefire-report。

1. The Jenkins Job -----> Goals and options:
clean -Dmaven.clean.failOnError=false surefire-report:report

2. <!--surefire plugin for BPT test-->

               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-surefire-plugin</artifactId>
                   <version>${surefire.version}</version>
                   <executions>
                       <execution>
                           <id>run-BPT-test</id>
                           <!--<phase>integration-test</phase>-->
                           <goals>
                               <goal>test</goal>
                           </goals>
                           <configuration>
                               <includes>
                                   <!--<include>**/ExampleForChrome.java</include>
                                   <include>**/ExampleForFirefox.java</include>
                                   <include>**/ExampleForIE.java</include>-->
                                   <include>**/TestCase_167543.java</include>
                                   <!-- <include>**/TestCase_167545_Firefox.java</include>
                                    <include>**/TestCase_167545_IE.java</include>-->
                               </includes>
                           </configuration>
                       </execution>
                   </executions>
               </plugin>

               <!--used for Junit test report generation-->
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-surefire-report-plugin</artifactId>
                   <version>${surefire-report.version}</version>
                   <configuration>
                       <!--<reportSets>-->
                       <!--<reportSet>-->
                       <!--<reports>-->
                       <!--<report>report-only</report>-->
                       <!--</reports>-->
                       <!--</reportSet>-->
                       <!--</reportSets>-->
                       <!--<reportsDirectory>${surefire-report.path}</reportsDirectory>-->
                       <outputDirectory>${surefire-report.path}</outputDirectory>
                       <outputName>${surefire-report.name}</outputName>
                   </configuration>
               </plugin>
