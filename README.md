# BookReaderApp
Android Application to reader books from external server.

Android application to show a list of books brought from a server, the web service is consumed and a list is created in a recylerview, if the processing of the answer is correct the list is shown.

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
