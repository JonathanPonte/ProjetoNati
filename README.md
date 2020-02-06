# ProjetoNati - API
> Api para gerência de matriz curricular.

# Json e Rotas

<h3>Usuario</h3>

<h4>Post http://localhost:8080/api/usuario </h4>

```sh

{
    "id": int(AUTO),
    "email": String,
    "senha": String,
    "nome": String,
    "tipo": int
 }
```

<h3>Curso</h3>

<h4>Post http://localhost:8080/api/curso</h4>

```sh
 {
     "id": int(AUTO),
     "nome": "String",
     "totalCredito": int,
     "semestres": []
 }
```

<h3>Semestre</h3>

<h4>Post http://localhost:8080/api/semestre</h4>

```sh
 {
      "id": int(AUTO),
      "periodo": String,
      "cadeiras": []
 }
```

<h3>Cadeira<h3>         

<h4>Post http://localhost:8080/api/cadeira</h4>

```sh
 {
      "id": int(AUTO),
      "qtdCredito": int,
      "semestreId": int,
      "disciplinaId": int
 }
```

<h3>Disciplina</3h>

<h4>Post http://localhost:8080/api/disciplina</h4>

```sh
 {
     "id": int(AUTO),
     "nome": String,
     "codigo": String
  }
```
