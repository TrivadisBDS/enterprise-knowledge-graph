

/* SAMPLE INPUT
author: Julia Child|F
book : Simca's Cuisine: 100 Classic French Recipes for Every Occasion|1972|0-394-40152-2
authorBook: Simca's Cuisine: 100 Classic French Recipes for Every Occasion|Simone Beck
 */

// CONFIGURATION
// Configures the data loader to create the schema
config create_schema: true, load_new: true, load_threads: 3

// DATA INPUT
// Define the data input source (a file which can be specified via command line arguments)
// inputfiledir is the directory for the input files

inputfiledir = '/home/marco/enterprise-knowledge-graph/dse/csv/'
employeeInput = File.csv(inputfiledir + "employee2.csv").delimiter(',')
termInput = File.csv(inputfiledir + "term2.csv").delimiter(',')
presentationInput = File.csv(inputfiledir + "presentation2.csv").delimiter(',')
certificationInput = File.csv(inputfiledir + "certification2.csv").delimiter(',')

employeeTermInput = File.csv(inputfiledir + "employeeTerm2.csv").delimiter(',')
employeePresentationInput = File.csv(inputfiledir + "employeePresentation2.csv").delimiter(',')
employeeCertificationInput = File.csv(inputfiledir + "employeeCertification2.csv").delimiter(',')
certificationTermInput = File.csv(inputfiledir + "certificationTerm2.csv").delimiter(',')

//Specifies what data source to load using which mapper (as defined inline)
  
load(employeeInput).asVertices {
    label "Employee"
    key "Name"
}

load(termInput).asVertices {
    label "Term"
    key "Name"
}

load(presentationInput).asVertices {
    label "Presentation"
    key "Name"
}

load(certificationInput).asVertices {
    label "Certification"
    key "Name"
}

load(employeeTermInput).asEdges {
    label "skill"
    outV "eName", {
        label "Employee"
        key "Name"
    }
    inV "tName", {
        label "Term"
        key "Name"
    }
}

load(employeePresentationInput).asEdges {
    label "participates in"
    outV "eName", {
        label "Employee"
        key "Name"
    }
    inV "pName", {
        label "Presentation"
        key "Name"
    }
}

load(employeeCertificationInput).asEdges {
    label "owns"
    outV "eName", {
        label "Employee"
        key "Name"
    }
    inV "cName", {
        label "Certification"
        key "Name"
    }
}

load(certificationTermInput).asEdges {
    label "related to"
    outV "cName", {
        label "Certification"
        key "Name"
    }
    inV "tName", {
        label "Term"
        key "Name"
    }
}


