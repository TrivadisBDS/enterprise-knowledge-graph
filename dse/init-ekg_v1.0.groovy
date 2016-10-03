// Create Schema for Enterprise Knowledge Graph

// Create Labels
schema.vertexLabel('Project').ifNotExists().create()
schema.vertexLabel('ProjectType').ifNotExists().create()
schema.vertexLabel('Industry').ifNotExists().create()
schema.vertexLabel('Customer').ifNotExists().create()
schema.vertexLabel('Presentation').ifNotExists().create()
schema.vertexLabel('Publication').ifNotExists().create()
schema.vertexLabel('Term').ifNotExists().create()
schema.vertexLabel('Employee').ifNotExists().create()
schema.vertexLabel('Certification').ifNotExists().create()
schema.vertexLabel('SocialMediaProfile').ifNotExists().create()
schema.vertexLabel('InstantMessaging').ifNotExists().create()
schema.vertexLabel('Event').ifNotExists().create()
schema.vertexLabel('Course').ifNotExists().create()
schema.vertexLabel('Location').ifNotExists().create()
schema.vertexLabel('Department').ifNotExists().create()
schema.vertexLabel('EventType').ifNotExists().create()

// Create propertyKeys for Vertex
schema.propertyKey('Abstract').Text().ifNotExists().create()
schema.propertyKey('Acronym').Text().ifNotExists().create()
schema.propertyKey('CallforPaperLink').Text().ifNotExists().create()
schema.propertyKey('City').Text().ifNotExists().create()
schema.propertyKey('Classification').Text().ifNotExists().create()
schema.propertyKey('Country').Text().ifNotExists().create()
schema.propertyKey('CourseCode').Text().ifNotExists().create()
schema.propertyKey('CourseType').Text().ifNotExists().create()
schema.propertyKey('DeadlineCallforPaper').Timestamp().ifNotExists().create()
schema.propertyKey('EventLink').Text().ifNotExists().create()
schema.propertyKey('From').Timestamp().ifNotExists().create()
schema.propertyKey('Language').Text().ifNotExists().create()
schema.propertyKey('Length').Int().ifNotExists().create()
schema.propertyKey('Link').Text().ifNotExists().create()
schema.propertyKey('Mobile').Text().ifNotExists().create()
schema.propertyKey('Name').Text().ifNotExists().create()
schema.propertyKey('OwnEvent').Boolean().ifNotExists().create()
schema.propertyKey('PartnerEvent').Boolean().ifNotExists().create()
schema.propertyKey('PhotoLink').Text().ifNotExists().create()
schema.propertyKey('Privatadresse').Text().ifNotExists().create()
schema.propertyKey('Projectmethod').Text().ifNotExists().create()
schema.propertyKey('Projektsumme').Int().ifNotExists().create()
schema.propertyKey('PublicationType').Text().ifNotExists().create()
schema.propertyKey('SAPProjektNumber').Int().ifNotExists().create()
schema.propertyKey('Scheduled').Text().ifNotExists().create()
schema.propertyKey('Status').Text().ifNotExists().create()
schema.propertyKey('TargetAudience').Text().ifNotExists().create()
schema.propertyKey('Telephone').Text().ifNotExists().create()
schema.propertyKey('To').Timestamp().ifNotExists().create()

// Create propertyKeys for Edges
schema.propertyKey('Since').Timestamp().ifNotExists().create()
schema.propertyKey('Level').Text().ifNotExists().create()
schema.propertyKey('Role').Text().ifNotExists().create()
schema.propertyKey('For').Text().ifNotExists().create()

//Add Vertex properties
schema.vertexLabel('Project').properties('SAPProjektNumber').add()
schema.vertexLabel('Project').properties('Name').add()
schema.vertexLabel('Project').properties('Projektsumme').add()
schema.vertexLabel('Project').properties('Classification').add()
schema.vertexLabel('Project').properties('Projectmethod').add()
schema.vertexLabel('ProjectType').properties('Name').add()
schema.vertexLabel('Industry').properties('Name').add()
schema.vertexLabel('Customer').properties('Name').add()
schema.vertexLabel('Presentation').properties('Name').add()
schema.vertexLabel('Presentation').properties('Abstract').add()
schema.vertexLabel('Presentation').properties('Status').add()
schema.vertexLabel('Presentation').properties('Link').add()
schema.vertexLabel('Publication').properties('Name').add()
schema.vertexLabel('Publication').properties('PublicationType').add()
schema.vertexLabel('Publication').properties('Link').add()
schema.vertexLabel('Term').properties('Name').add()
schema.vertexLabel('Employee').properties('Name').add()
schema.vertexLabel('Employee').properties('Acronym').add()
schema.vertexLabel('Employee').properties('Telephone').add()
schema.vertexLabel('Employee').properties('Mobile').add()
schema.vertexLabel('Employee').properties('Privatadresse').add()
schema.vertexLabel('Employee').properties('PhotoLink').add()
schema.vertexLabel('Certification').properties('Name').add()
schema.vertexLabel('SocialMediaProfile').properties('Name').add()
schema.vertexLabel('SocialMediaProfile').properties('Link').add()
schema.vertexLabel('InstantMessaging').properties('Name').add()
schema.vertexLabel('InstantMessaging').properties('Link').add()
schema.vertexLabel('Event').properties('Name').add()
schema.vertexLabel('Event').properties('From').add()
schema.vertexLabel('Event').properties('To').add()
schema.vertexLabel('Event').properties('CallforPaperLink').add()
schema.vertexLabel('Event').properties('EventLink').add()
schema.vertexLabel('Event').properties('DeadlineCallforPaper').add()
schema.vertexLabel('Event').properties('PartnerEvent').add()
schema.vertexLabel('Event').properties('OwnEvent').add()
schema.vertexLabel('Event').properties('TargetAudience').add()
schema.vertexLabel('Course').properties('Name').add()
schema.vertexLabel('Course').properties('Length').add()
schema.vertexLabel('Course').properties('Status').add()
schema.vertexLabel('Course').properties('CourseType').add()
schema.vertexLabel('Course').properties('CourseCode').add()
schema.vertexLabel('Course').properties('Scheduled').add()
schema.vertexLabel('Course').properties('Language').add()
schema.vertexLabel('Location').properties('City').add()
schema.vertexLabel('Location').properties('Country').add()
schema.vertexLabel('Department').properties('Name').add()
schema.vertexLabel('EventType').properties('Name').add()

// Creating edgeLabels
schema.edgeLabel('responsible').multiple().properties('For').connection('Event', 'Employee').ifNotExists().create()
schema.edgeLabel('skill').multiple().properties('Level', 'Since').connection('Employee', 'Term').ifNotExists().create()
schema.edgeLabel('participates in').multiple().properties('Since', 'Role').connection('Employee', 'Project').ifNotExists().create()
schema.edgeLabel('owns').multiple().properties('Since').connection('Employee', 'Certification').ifNotExists().create()
schema.edgeLabel('part of').single().properties('Since').connection('Employee', 'Department').ifNotExists().create()
schema.edgeLabel('located in').single().properties('Since').connection('Employee', 'Location').ifNotExists().create()
schema.edgeLabel('uses').multiple().connection('Employee', 'SocialMediaProfile').ifNotExists().create()
schema.edgeLabel('uses').multiple().connection('Employee', 'InstantMessaging').ifNotExists().create()
schema.edgeLabel('managed by').multiple().connection('Employee', 'Employee').ifNotExists().create()
schema.edgeLabel('participates in').multiple().connection('Employee', 'Presentation').ifNotExists().create()
schema.edgeLabel('teaches').multiple().connection('Employee', 'Course').ifNotExists().create()
schema.edgeLabel('author').multiple().connection('Employee', 'Publication').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Certification', 'Term').ifNotExists().create()
schema.edgeLabel('located in').multiple().connection('Department', 'Location').ifNotExists().create()
schema.edgeLabel('located in').multiple().connection('Event', 'Location').ifNotExists().create()
schema.edgeLabel('created for').multiple().connection('Event', 'Presentation').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Event', 'Term').ifNotExists().create()
schema.edgeLabel('isOf').single().connection('Event', 'EventType').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Presentation', 'Term').ifNotExists().create()
schema.edgeLabel('for').multiple().connection('Presentation', 'Industry').ifNotExists().create()
schema.edgeLabel('main teacher').single().connection('Course', 'Employee').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Course', 'Term').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Publication', 'Term').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Term', 'Term').ifNotExists().create()
schema.edgeLabel('isOf').single().connection('Project', 'ProjectType').ifNotExists().create()
schema.edgeLabel('responsible unit').single().connection('Project', 'Department').ifNotExists().create()
schema.edgeLabel('managed by').multiple().connection('Project', 'Employee').ifNotExists().create()
schema.edgeLabel('owned by').single().connection('Project', 'Employee').ifNotExists().create()
schema.edgeLabel('related to').multiple().connection('Project', 'Term').ifNotExists().create()
schema.edgeLabel('for').multiple().connection('Project', 'Industry').ifNotExists().create()
schema.edgeLabel('for').multiple().connection('Project', 'Customer').ifNotExists().create()
schema.edgeLabel('in').single().connection('Customer', 'Industry').ifNotExists().create()


schema.vertexLabel('Employee').index('byName').materialized().by('Name').add()
schema.vertexLabel('Term').index('byName').materialized().by('Name').add()
