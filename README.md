# evaluacionTres
Prueba 3 Aplicaciones Moviles. Login con validaciones, registro de usuarios, creación de eventos fechas. Opciones de recuperar pass, cambiar pass y eliminar usuario.

Login -> Valida al usuario mediante el RUT si existe o no en la base de datos SQLite
<img width="267" alt="image" src="https://user-images.githubusercontent.com/66278716/209411744-61813347-0d85-441a-b41c-ba1058ca6c72.png">


Register View -> Crea el usuario, no pueden existir usuarios con el mismo RUT (Primary Key)
<img width="272" alt="image" src="https://user-images.githubusercontent.com/66278716/209411757-bbeefdce-bb49-431f-b789-218946b6a8a0.png">


Recover Pass -> Valida según el token ingresado, si le corresponde al usuario muestra su pass.
<img width="264" alt="image" src="https://user-images.githubusercontent.com/66278716/209411804-35f55841-08a4-4451-8389-142e9149187e.png">


Reminders -> Muestra los eventos en un ListView obtenidos desde un List alimentado por un metodo en la BD que entrega los Reminder del User.
<img width="261" alt="image" src="https://user-images.githubusercontent.com/66278716/209411871-975d4975-ef7a-43b0-89ea-2e6d1a96124a.png">


Other Options -> El usuario puede cambiar su password si la actual ingresada le corresponde y puede borrar su usuario preguntandole en un AlertDialog si lo desea hacer.
<img width="266" alt="image" src="https://user-images.githubusercontent.com/66278716/209411912-f3472426-4c78-4075-9ecf-2bdc9ada56b7.png">



Add Reminder -> El usuario mediante los datos solicitados crea un recordatorio y selecciona su importancia en un Spinner 
<img width="251" alt="image" src="https://user-images.githubusercontent.com/66278716/209411947-9a399243-46d9-4bba-8a1a-277c12ab6843.png">

