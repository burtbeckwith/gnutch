// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
    production {
        grails.serverURL = "http://www.changeme.com"
    }
    development {
        grails.serverURL = "http://localhost:8080/${appName}"
    }
    test {
        grails.serverURL = "http://localhost:8080/${appName}"
    }
}


// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}
  appenders {
    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    file name: 'stacktrace', file: "/var/log/tomcat7/stacktrace.log"
  }
    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
           debug 'gnutch'
           // trace 'gnutch'
           // trace 'org.apache.camel.http'
           // debug 'org.apache.camel'
   warn 'org.mortbay.log'
}


gnutch {
  // Input route definition 
  inputRoute = 'file:///tmp/gnutch-input'

  // text file containing regular expressions to include and exclude URL crawling patterns
  regexUrlFilter = 'regex-urlfilter.txt'
  

  crawl {
   // Crawling thread pool
   threads = 20
  }
  
  // Crawling pattern/XSLT association
  transformations = [
  '^http://www.jflpartners.com/news/news_.*_i\\.html$':'xslt/2.xsl',
  '^http://www.newswire.ca/en/story/\\d*/.*':'xslt/4.xsl',
  'https://europeanequities.nyx.com/en/content/.*':'xslt/5.xsl',
  'http://www.dgap.de/dgap/News/.*':'xslt/7.xsl',
  'http://www.presseportal.de/pm/\\d*/\\d*/.*':'xslt/8.xsl',
  'http://www.kase.kz/en/news/show/\\d*':'xslt/13.xsl',
  'http://www.szse.cn/main/en/disclosure/listedcompaniesannouncement':'xslt/18.xsl',
  'http://www.sgx.com/wps/wcm/connect/sgx_en/home/higlights/news_releases/.*':'xslt/19.xsl',
  'https://newsclient.omxgroup.com/cdsPublic/viewDisclosure.action.*':'xslt/21.xsl',
  'http://news.sky.com/story/\\d*/.*':'xslt/23.xsl',
  'http://newsroom.businesswire.com/press-release/.*':'xslt/25.xsl',
  'http://www.marketwire.com/press-release/.*':'xslt/26.xsl',
  'http://www.globenewswire.com/news-release/.*':'xslt/27.xsl',
  'http://techcrunch.com/\\d*/\\d*/\\d*/.*':'xslt/28.xsl',
  'http://3igroup.com/news/.*':'xslt/35.xsl',
  'http://www.abraaj.com/content/.*':'xslt/37.xsl',
  'http://www.abry.com/home/news/.*/.*':'xslt/38.xsl',
  'http://www.aconinvestments.com/news/.*':'xslt/39.xsl',
  'http://www.adventinternational.com/news/PressReleases/pages/.*':'xslt/40.xsl',

  // Rumen's work
  'http://www.bencis.com/web/site/default.aspx\\?m=news&ca=d&id=\\d*':'xslt/303.xsl',
  'http://www.beringea.com/newsroom.php\\?id=\\d*':'xslt/304.xsl',
  'http://www.berkshirepartners.com/news_press_.*':'xslt/305.xsl',
  'http://www.blackstone.com/news-views/details/.*':'xslt/308.xsl',
  'http://blackstreetcapital.com/.*':'xslt/309.xsl',
  'http://bluepointcapital.com/newsroom/article.aspx\\?id=\\d*':'xslt/310.xsl',
  'http://boldercapital.com/news/.*':'xslt/312.xsl',
  'http://www.bvlp.com/press-announcements-events/[^\\?].*':'xslt/313.xsl',
  'http://www.equistonepe.com/detail/news-detail\\?id=\\d*&news=1&popup=1':'xslt/315.xsl',
  'http://www.bridgepoint.eu/en/news/press-releases/\\d*/.*':'xslt/318.xsl',
  'http://www.brs.com/pr\\d*.html':'xslt/319.xsl',
  'http://www.bwku.de/index.php\\?article_id=\\d*&clang=1':'xslt/322.xsl',
  'http://www.crp.com/news.*':'xslt/329.xsl',
  'http://www.capman.com/capman-group/news-and-materials/releases/release/.*':'xslt/332.xsl',
  'http://www.capvis.com/index.php?id=12.*':'xslt/333.xsl'
  ]

  http {
    // UserAgent string. Better if contain email address of person who is responsible 
    // for crawling. That will allow source owners to contact person directly
    userAgent = "GNutch crawler. Contact maintainer: admin@softsky.com.ua"
    // Maximmum number of connections per host
    defaultMaxConnectionsPerHost = 40
    // Maximmum number of total connections
    maxTotalConnections = 40
  }

  solr {
    // URL to Solr server
    serverUrl = 'http://mergeaa4.miniserver.com:8983/solr'
  }
 
  
  activemq {
    // URL to message broker
    brokerURL = 'vm://localhost'
    // conf = 'classpath:activemq.xml'
  } 

}