import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class UrlInputRoute {
    def configure = {
        from("${CH.config.gnutch.inputRoute}").
        convertBodyTo(java.io.File).
        beanRef('sourceUrlsProducerService', 'produce')
    }
}