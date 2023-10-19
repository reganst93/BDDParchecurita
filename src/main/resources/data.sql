insert into `Clasificación de centros`  (`tipo de centro`)
values ("SAPU"),
       ("SAR"),
       ("CESFAM"),
       ("COSAM"),
       ("CSU"),
       ("CRS"),
       ("CGU"),
       ("CGR"),
       ("CCR"),
       ("No Aplica");

insert into triage (categoría,urgencia)
values ("Triage 1","Emergencia con riesgo vital"),
       ("Triage 2", "Paciente de alta complejidad"),
       ("Triage 3","Paciente de mediano riesgo o complejidad"),
       ("Triage 4","No urgente/Baja complejidad"),
       ("Triage 5","Atencion General");

INSERT INTO `centros médicos` (nombre,comunas,dirección,apertura,cierre,`apertura sábado`,`cierre sábado`,`apertura domingo`,`cierre domingo`,teléfonos,`clasificación de centro`,`tipos de triage`)
values ("Sar Enfermera sofia pincheira","Cerrillo","Pje. Los Eclipses 7550",'09:00:00','19:00:00',null,null,null,null,'25551234','2','3'),
       ("Consultorio Escuela de Formación Policial de Carabineros de Chile","Cerrillos","Av. Pedro Aguirre Cerda 6655",'09:00:00','18:00:00',null,null,null,null,'29221415','10','3'),
       ("Centro Integramedica Oeste","Cerillos","Av. Américo Vespucio 1501",'08:30:00','19:00:00','08:30:00','19:00:00',null,null,'25366666','10','1'),
       ("Centro de Salud Familiar Enfermera Sofia Pincheira","Cerillos","Av. Las Torres 7590",'08:00:00','18:00:00',null,null,null,null,'25747800','3','3'),
       ("COSAM Cerillos","Cerillos","Diecinueve de Septiembre 6161",'09:00:00','17:00:00',null,null,null,null,'26124174','4','3'),
       ("SAPU Dr.Norman Voulliéme","Cerrillo","Pje. Petrarca 7067 ",'00:00:00','23:59:59','00:00:00','23:59:59','00:00:00','23:59:59','87753276','1','1'),
       ("Centro Comunitario de Salud Familiar Maria Salas","Cerillos","Cam. Cta. Barriga 230, Curacaví",'09:00:00','18:00:00',null,null,null,null,'26127060','3','3'),
       ("Centro de Salud Familiar Dr.Norman Voulliéme","Cerillos","Av. Salomón Sack N°1323",'08:30:00','18:30:00',null,null,null,null,'25746654','3','3'),
       ("Uno Salud Cerillos","Cerrillos","Av. Pedro Aguirre Cerda 7003",'08:30:00','20:00:00','09:00:00','14:00:00',null,null,'60070710','10','2'),
       ("Centro Comunitario de Salud Familiar Buzeta","Cerillos","Av. Carlos Valdovinos 3955",'09:00:00','17:00:00',null,null,null,null,'26124014','3','3');




insert into `contacto online` (`página web`,`red social`,email,`centro médico`)
values (null,null,null,'1'),
       (null,null,null,'2'),
       ("www.integramedica.cl/integramedica/integramedica-oeste","www.facebook.com/Integramedica/",null,'3'),
       (null,"www.facebook.com/cesfampincheira/","oirscesfamsarsofiapincheira@gmail.com",'4'),
       ("https://mcerrillos.cl/cosam.php,null",null,"cosamcerrillos@gmail.com",'5'),
       (null,null,null,'6'),
       ("www.hospitaldecuracavi.cl/red-atencion-primaria/cecosfmariasalas.html","www.instagram.com/hospitaldecuracavi/?hl=es-la",null,'7'),
       (null,"www.instagram.com/cesfam_nvoullieme/?hl=es",null,'8'),
       ("www.unosalud.cl/blog/nueva-clinica-llegamos-a-cerrillos-para-verte-sonreir/",null,null,'9'),
       ("www.mcerrillos.cl/cecosf.php",null,null,'10');


INSERT INTO creadores (nombre,apellido,cargo)
values("Matias","Carrion","Scrum Master"),
      ("Giovanni","Alamos","Product Owner"),
      ("Stephania","Bilbao","Desarrollador"),
      ("Kevin","Briceño","Desarrollador"),
      ("Catalina","Aedo","Desarrollador");


