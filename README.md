# todoListJavaSpringboot
Implement todo list RESTful API with Spring boot

# Setup instruction
* Packaging application by run this command: `mvnw package`
* Run application by this command `java -jar target/todoList-0.0.1-SNAPSHOT.jar`

# API Document

**View all items in the list**
----
  Returns json data of all tasks.

* **URL**

  api/v1/todolist/tasks

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
     ```
    [
        {
            "id": 1,
            "subject": "Task1",
            "content": "Content1",
            "status": "PENDING",
            "createdAt": 1517224122769,
            "updatedAt": 1517224122769
        },
        {
            "id": 2,
            "subject": "Task2",
            "content": "Content2",
            "status": "PENDING",
            "createdAt": 1517224342241,
            "updatedAt": 1517224342241
        }
    ]
     ```
* **Sample Call:**

  ```
  GET | http://localhost:8080/api/v1/todolist/tasks
  ```

**View a single task in the list**
----
  Returns json data about a single task.

* **URL**

  api/v1/todolist/task/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
     ```
    {
        "id": 1,
        "subject": "Task1",
        "content": "Content1",
        "status": "PENDING",
        "createdAt": 1517224122769,
        "updatedAt": 1517224122769
    }
     ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `null`

* **Sample Call:**

  ```
  GET | http://localhost:8080/api/v1/todolist/task/1
  ```

**Add a task to the list**
----
  Returns json data of a added task.

* **URL**

  api/v1/todolist/task

* **Method:**

  `POST`
  
*  **URL Params**

   **Required:**
 
   None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
     ```
    {
        "id": 2,
        "subject": "Task2",
        "content": "Content2",
        "status": "PENDING",
        "createdAt": 1517224342241,
        "updatedAt": 1517224342241
    }
     ```
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `Depend on request`
    
* **Sample Call:**

  ```
  POST | http://localhost:8080/api/v1/todolist/task

  Body: 
  {
        "subject" : "Task2",
        "content" : "Content2",
        "status" : "PENDING"
  }
  ```

**Edit existing task**
----
  Returns json data of a edited task.

* **URL**

  api/v1/todolist/task/:id

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
     ```
    {
        "id": 1,
        "subject": "Task1 - edited",
        "content": "Content1 - edited",
        "status": "DONE",
        "createdAt": 1517224122769,
        "updatedAt": 1517224676029
    }
     ```
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `Depend on request`

* **Sample Call:**

  ```
  PUT | http://localhost:8080/api/v1/todolist/task/1

  Body: 
  {
        "subject" : "Task1 - edited",
        "content" : "Content1 - edited",
        "status" : "DONE"
  }
  ```

**Set the task status**
----
  Returns json data of a edited task.

* **URL**

  api/v1/todolist/task/:id/status/:status

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`
   `status=[String]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
     ```
    {
        "id": 1,
        "subject": "Task1",
        "content": "Content1",
        "status": "DONE",
        "createdAt": 1517224122769,
        "updatedAt": 1517224676029
    }
     ```
 
* **Error Response:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** 
  ```
  {
    "timestamp": 1517225176926,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "java.lang.IllegalArgumentException",
    "message": "No enum constant com.nubbnueng.todoList.model.TaskStatus.DON",
    "path": "/api/v1/todolist/task/1/status/don"
  }
  ```

* **Sample Call:**

  ```
  PUT | http://localhost:8080/api/v1/todolist/task/1/status/DONE
  ```

**Delete a task from the list**
----

* **URL**

  api/v1/todolist/task/:id

* **Method:**

  `DELETE`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `null`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `null`

* **Sample Call:**

  ```
  DELETE | http://localhost:8080/api/v1/todolist/task/1
  ```