package  com.example.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyPlugin implements Plugin<Project>{

    void apply(Project project){
//        System.out.println("xxxxxxxx");
        System.out.println("hello gradle plugin!");
        System.out.println("xxxxxxxx");
        project.task('myTask') << {
            println "Hi this is micky's plugin"
        }
    }

}