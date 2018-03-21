"# TP1-Productor - Consumidor" 

- Para consumir el stock necesito que se consuma mas de lo que se produce. 

- Los bloques deben ser syhnchronized para que los metodos se ejecuten de a uno evitando asi la concurrencia.

- la Clase BeerHouse es el recurso compartido por las Clases BeerProducer y BeerConsumer. Al tener los metodos synchonized evitamos que se ejecuten de a uno.

- 1. Las Clases Productor y Consumidor implementan la interface Runnable y se crea un objeto de tipo Thread para la Clase Productor y otro para la Clase Consumidor.
- 2. Se extiende Thread, se sobreescribe run y se llama al método start.
- 3. Se instancia Thread como new Thread
