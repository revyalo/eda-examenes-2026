# Organiser de estudiantes

Caso de uso inspirado en el enunciado de gestion de estudiantes y asignaturas.

Debes completar `Organiser` para que la localizacion por DNI sea eficiente.

## Metodos

- constructor vacio,
- constructor desde pares asignatura-estudiante,
- `enrolledSubjects(DNI dni)`: devuelve las asignaturas del estudiante o `null` si no existe,
- `newStudent(Student student, List<String> subjects)`: alta o modificacion de matricula,
- `registrationChange(Student student, List<String> subjects)`: cambio de matricula solo si el estudiante ya existe,
- `studentData(DNI dni)`: devuelve los datos personales en formato `"nombre apellido dni"` o `null`.

```bash
mvn test
```
