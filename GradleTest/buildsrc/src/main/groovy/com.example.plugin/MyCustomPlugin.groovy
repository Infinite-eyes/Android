package com.example.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction


class MyCustomPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("myArgs", MyCustomPluginExtension)
        project.task('customTask', type: MyCustomTask)
    }


    class MyCustomTask extends DefaultTask {
        @TaskAction
        void output() {
          println "Sender is ${project.myArgs.sender},\nmessage: ${project.myArgs.message}"
        }
    }


}
