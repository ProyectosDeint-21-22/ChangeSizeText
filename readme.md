# Proyecto ChangeSizeText.

###### Proyecto Acabado "06/10/2021".

###### Ignacio Moya González.

***Aplicación creada en Android Studio.***

***Aplicación con tres Activitys (dos Activitys), donde las dos primeras se comunican entre sí para cambiar el tamaño de un texto mediante un SeekBar***

*ChangeSizeTextActivity espeficará un mensaje de texto y un valor dado por un seekBar, y ViewMessageAcitivity recogerá tanto el mensaje con el texto cambiado.*

##### *Realizado con API 31 y minimunSDK 23.*

## Contenido:

**06/10/2021**

- La datos que se envían desde ChangeSizeTextActivity a ViewMessageActivity a través de un Bundle e Intent, como el proyecto anterior SendMessage.

- View SeekBar: hay que tener cuidado con la propiedad android:max( valor máximo del SeekBar) y android:progress (valor del Seekbar), porque existe la tendencia de ponerle el valor con dp. Si hacemos esto no funcionará ya que estas propiedades necesitan un valor int.

- Los datos que se pasan entre las Activitys están contenidos en una clase POJO llamada Message (User, message, size). User será una instancia de la clase User, ya que queremos que exista una gestión de Usuarios. Clase User (name, email), será otra clase POJO.

- A diferencia con la app SendMessage, uno de los datos compartidos (User), se encuentra en el contexto de Application, porque queremos que sea visible por cualquier Activity.

- Para ello, creamos una clase personalizada de la clase Application (ChangeSizeApplication), es decir, una clase que sobreescriba la clase Application, llamada User. Al sobreescribir la clase Application hereda todo el contexto de nuestra aplicación.

- Para que nos funciones la clase ChangeSizeApplication en la configuración del AndroidManifiest.xml debemos de cambiar el nombre de la clase Application e indicarle que nuestra clase creada ChangeSizeApplication es ahora nuestra clase Application.

  ![Imagen AndroidManifiest](https://raw.githubusercontent.com/ProyectosDeint-21-22/ChangeSizeText/master/Imagen%20AndroidManifiest.png)

- Sabemos que nuesta clase POJO Mesagge implementa la interfaz Serializable, por tanto nuestra clase User también implementará la misma interfaz, ya que se es un campo de la clase Message y se recoge con un Intent.

- La clave de este ejercicio es como obtener ese usuario User de la clase Application en nuestra Activity. Se obtiene a través del contexto de Application (`getApplication()`), pero recordamos que sobreescribimos esta clase, entonces simplemente le hacemos un casting.

  ```java
  /**
  * Para obtener el usuario de la clase Application: obtenemos la clase Application (getApplication()),
  * Casting ChangeSizeApplication
  * getUser().
  */
  Message message= new Message(((ChangeSizeApplication)getApplication()).getUser(),
                 binding.etTexto.getText().toString(),binding.skSize.getProgress());
  ```

**07/10/2021**

- Guardar el Estado de una Activity (estado persistente, estado dinámico y estado de diseño). Mirar proyectos SaveStateActivity y StartActivityForResult.

#### Links:

[(https://developer.android.com/)](https://developer.android.com/)

[(https://material.io/resources/color/#!/?view.left=0&view.right=0)](https://material.io/resources/color/#!/?view.left=0&view.right=0)