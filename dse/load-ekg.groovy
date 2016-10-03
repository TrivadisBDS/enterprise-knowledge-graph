

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
employeeTermInput = File.csv(inputfiledir + "employeeTerm2.csv").delimiter(',')

//Specifies what data source to load using which mapper (as defined inline)
  
load(employeeInput).asVertices {
    label "Employee"
    key "Name"
}

load(termInput).asVertices {
    label "Term"
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


