Este proyecto es una prueba para  el control de pico y placa de vehiculos en la ciudad de Quito
Es una API Restfull que funciona con un endpoint el cual permitira determinar si un vehiculo puede o no circular dentro de la ciudad de acuerdo a lo establecido
la API esta desarrollada bajo JAVA+Springboot y el motor de base de datos SQL Server

END POINT
hhttp://localhost:9000/api/v1/vehiculo/save ->De acuerdo a la configuracion realizada en el archivo application.properties

Configurar el archivo application.properties para poder desplegar el aplicativo
cargar la base de datos 

probar el end point en postman u otro gestor

PARAMETROS A INGRESAR EN EL METODO POST
numero de placa del vehiculo
hora
fecha
los datos mencionados deben ser ingresados en formato JSON
{
  "numero_placa":"PPA37080",
  "hora":"06:35:00",
  "fecha":"2024-08-08T07:19:31"
}
REGLAS A TOMAR EN CUENTA PARA PROBAR EL APLICATIVO
El pico y placa comienza en el siguiente horario
06:00 - 09:30  en la mañana 
16:00 - 20:00  en la tarde

Dias que no se puede circular segun el ultimo digito de la placa
LUNES 1y2
MARTES 3y4
MIERCOLES 5y6
JUEVES 7y 8
VIERNES 9y 0
FINES DE SEMANA SE PUEDE TRANSITAR LIBREMENTE
