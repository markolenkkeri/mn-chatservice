package chatservice

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

import javax.inject.Inject

@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.run(Application)
    }
}