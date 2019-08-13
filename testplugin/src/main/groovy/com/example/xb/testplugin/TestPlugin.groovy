package com.example.xb.testplugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println("进入了testPlugin...")

        def testParam = project.getExtensions().create("testParam", TestParamExtension)

//        project.extensions.add("testParam", TestParamExtension)

        project.afterEvaluate {
            if (testParam.hasProperty("name")){
                def name = testParam.getProperty("name")
                println("name is $name")
            }
        }
    }
}