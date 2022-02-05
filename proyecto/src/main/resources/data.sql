INSERT INTO projects VALUES (1,'Proyecto1','PPI','pruebaPPI','2008-01-01 00:00:01','2010-01-01 00:00:01');

INSERT INTO backlogs (id, identifier, project_id) VALUES (1, 1, 1);

INSERT INTO projectTask (id, name, sumary, acceptanceCriteria, status, priority, hours, startDate, endDate, projectIdentifier, backLog_id) VALUES (1, 'Tarea1', 'proyecto de prueba', 'Que el proyecto se guarde','Not Started', 3, 7.0, null, null, 'PPI', 1);