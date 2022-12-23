# Aplicación de Recordatorios
Prueba 3 Aplicaciones Moviles. Login con validaciones, registro de usuarios, creación de eventos fechas. Opciones de recuperar pass, cambiar pass y eliminar usuario.

Login -> Valida al usuario mediante el RUT si existe o no en la base de datos SQLite
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412157-55fea7c2-8869-4ae3-9cfb-4ee7025fe5ab.png">


Register View -> Crea el usuario, no pueden existir usuarios con el mismo RUT (Primary Key)
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412220-30a64bc0-9b0f-4c2f-b456-41569cc3ca49.png">


Recover Pass -> Valida según el token ingresado, si le corresponde al usuario muestra su pass.
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412199-f8f3b794-b459-4df1-a825-2b9cc99ccfba.png">


Reminders -> Muestra los eventos en un ListView obtenidos desde un List alimentado por un metodo en la BD que entrega los Reminder del User.
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412178-1789e624-c88b-4e69-b0cc-9c9bf2395c05.png">

Other Options -> El usuario puede cambiar su password si la actual ingresada le corresponde y puede borrar su usuario preguntandole en un AlertDialog si lo desea hacer.
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412237-0627f985-eac1-400a-a69b-8656e67d4162.png">

Add Reminder -> El usuario mediante los datos solicitados crea un recordatorio y selecciona su importancia en un Spinner 
<img width="995" alt="image" src="https://user-images.githubusercontent.com/66278716/209412252-bb12d491-a325-42a9-8d22-8f56d2bb4b7c.png">





