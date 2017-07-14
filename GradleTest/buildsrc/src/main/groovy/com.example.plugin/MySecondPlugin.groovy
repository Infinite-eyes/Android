package com.example.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project

public class MySecondPlugin implements Plugin<Project>{

    void apply(Project project){
        println "------------------------------------------"
        println "Hi this is second's plugin"
        println "------------------------------------------"
    }


}