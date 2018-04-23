# BookReaderApp
Android Application to reader books from external server.

Android application to show a list of books brought from a server, the web service is consumed and a list is created in a recylerview, if the processing of the answer is correct the list is shown.
<br>
<img src="https://github.com/OsmarICancino/BookReaderApp/blob/master/screen1.png" />
<br>

The response of the service is as follows:

```
{  
   "estado":1,
   "libros":[  
      {  
         "id_libro":"3",
         "categoria_id_categoria":"0",
         "nombre":"Osmar Test",
         "descripcion":"Osmar Test",
         "tamanio":"497419",
         "tipo":"application\/pdf",
         "nombre_archivo":"boardingpass.pdf",
         "categoria":"Arte"
      },
      {  
         "id_libro":"5",
         "categoria_id_categoria":"0",
         "nombre":"test",
         "descripcion":"test",
         "tamanio":"197801",
         "tipo":"application\/pdf",
         "nombre_archivo":"osmar test.pdf",
         "categoria":"Computacion"
      }
   ]
}
```
If the value of "state" is 1, the answer is correct, otherwise an error has occurred.
It has been tested on a local server, but it works with any external server.

In the project, it will be enough to replace the URL in the following fragment in YOU_SERVER_URL value:

```java
final RequestQueue requestQueue = Volley.newRequestQueue(this);
final String url ="http://YOU_SERVER_URL/movil/web/get_books.php";
JsonObjectRequest req = new JsonObjectRequest(url, null,
```

When the user clicks on a book, the operating system is requested to download and view the pdf file through an Intent:
<br>
<img src="https://github.com/OsmarICancino/BookReaderApp/blob/master/screen2.jpg" />
<br>

In the project are attached the configuration files made in PHP, located in the mobile.zip file, in one a singleton model is attached to connect to the database and the Book class (data) and in the other folder (web) the files are found to send the answer by GET.

You will only modify the values corresponding to your database in mysql_login.php file:

```
phpdefine("HOSTNAME", "localhost");// Nombre del host
define("PORT", "3306");// Número del puerto [ Opcional ]
define("DATABASE", "biblioteca"); // Nombre de la base de datos
define("USERNAME", "root"); // Nombre del usuario
define("PASSWORD", ""); // Constraseña

```

Contribution
--------------------

If you feel that something is missing, or you have a good idea on how to improve this implementation, feel free to open a pull requests exposing your arguments.


Created by
--------------------

Osmar I. Cancino Díaz - <o.cancinodiaz@gmail.com>
Mobile Application Engineer

<a href="https://twitter.com/Osmar_ICancino">
  <img alt="Follow me on Twitter"
       src="https://raw.github.com/kikoso/android-stackblur/master/art/twitter.png" />
</a>
<a href="https://plus.google.com/u/0/112832662508601636179">
  <img alt="Follow me on Google+"
       src="https://raw.github.com/kikoso/android-stackblur/master/art/google-plus.png" />
</a>
<a href="https://www.facebook.com/profile.php?id=100015486459234">
  <img alt="Follow me on Facebook!!"
       src="https://github.com/OsmarICancino/AppUPImage/blob/master/app/src/main/res/drawable/fb_icon.png" />
</a>

#PHP #Android #Java #Volley
