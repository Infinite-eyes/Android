package com.example.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 *
 * ./gradlew MySecondTask
 *
 */
class MySecondTask extends DefaultTask{

    @TaskAction
    void output(){
        println "Hello this is my custom task output"

    }
}