# evaluacionTres
Prueba 3 Aplicaciones Moviles. Login con validaciones, registro de usuarios, creación de eventos fechas. Opciones de recuperar pass, cambiar pass y eliminar usuario.

Login -> Valida al usuario mediante el RUT si existe o no en la base de datos SQLite
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412157-55fea7c2-8869-4ae3-9cfb-4ee7025fe5ab.png">


Register View -> Crea el usuario, no pueden existir usuarios con el mismo RUT (Primary Key)
<img width="1038" alt="image" src="https://user-images.githubusercontent.com/66278716/209412178-1789e624-c88b-4e69-b0cc-9c9bf2395c05.png">


Recover Pass -> Valida según el token ingresado, si le corresponde al usuario muestra su pass.

Reminders -> Muestra los eventos en un ListView obtenidos desde un List alimentado por un metodo en la BD que entrega los Reminder del User.

Other Options -> El usuario puede cambiar su password si la actual ingresada le corresponde y puede borrar su usuario preguntandole en un AlertDialog si lo desea hacer.

Add Reminder -> El usuario mediante los datos solicitados crea un recordatorio y selecciona su importancia en un Spinner 





