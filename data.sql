INSERT INTO EMPRESA (ADRECA, CIF, NOM) VALUES
       ('Calle Principal 123', 'A' || lpad(trunc(random()*100000000), 8, '0'), 'Empresa A'),
       ('Avenida Central 456', 'B' || lpad(trunc(random()*100000000), 8, '0'), 'Empresa B'),
       ('Carrera Principal 789', 'C' || lpad(trunc(random()*100000000), 8, '0'), 'Empresa C');

INSERT INTO alumne (CICLE, COGNOMS, ESTAT_PRACTIQUES, MODALITAT, NOM, EMPRESA_ID, DNI) VALUES
        ('DAM', 'García Martínez', 'ACABADES', 'DUAL', 'Juan', 1, '12423876A'),
        ('DAW', 'López Pérez', 'ENPROCES', 'FCT', 'María', 2, '81621826S'),
        ('ASIX', 'Martínez Sánchez', 'ACABADES', 'DUAL', 'Carlos', 3, '34871924R'),
        ('DAM', 'Hernández López', 'ENPROCES', 'DUAL', 'Ana', 1, '78152643T'),
        ('DAW', 'Rodríguez González', 'ACABADES', 'FCT', 'Laura', 2, '62391482D'),
        ('ASIX', 'Gómez Ramírez', 'ENPROCES', 'DUAL', 'Pedro', 3, '29314872E'),
        ('DAM', 'Pérez Torres', 'ACABADES', 'FCT', 'Sofía', 1, '42937162W'),
        ('DAW', 'González García', 'ENPROCES', 'DUAL', 'Luis', 2, '82134796Q'),
        ('ASIX', 'Ramírez Martínez', 'ACABADES', 'FCT', 'Alejandra', 3, '13498276G'),
        ('DAM', 'Torres Sánchez', 'ENPROCES', 'DUAL', 'Daniel', 1, '67231984H');
