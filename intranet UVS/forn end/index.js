const formElement = document.getElementById("guardar");
const formActualizar = document.getElementById("actualizar");
const formEliminar = document.getElementById("eliminar");
//agregar
formElement.addEventListener("submit", (event) => {
  event.preventDefault();
  const rut_colaborador = document.getElementById("rut").value;
  const nombre_colaborador = document.getElementById("nombre").value;
  const apellido_colaborador = document.getElementById("apellido").value;
  const correo_colaborador = document.getElementById("correo").value;
  const telefono_colaborador = document.getElementById("telefono").value;
  const correo_electronico = document.getElementById("correo").value;
  const contraseña = document.getElementById("contraseña").value;
  const cargo = document.getElementById("cargos").value;

  const lista = {
    rut_colaborador: rut_colaborador,
    nombre_colaborador: nombre_colaborador,
    apellido_colaborador: apellido_colaborador,
    correo_colaborador: correo_colaborador,
    telefono_colaborador: telefono_colaborador,
    correo_electronico: correo_electronico,
    contraseña: contraseña,
    cargo: cargo,
  };
  const listaJson = JSON.stringify(lista);
  console.log(listaJson);

  // send data to backend
  fetch("http://localhost:3000/empleados", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: listaJson,
  })
    .then((response) => response.json())
    .then(window.location.reload())
    .catch((error) => console.log(error));

  window.location.reload();
});

const recargarDatosEmpleados = async () => {
  const tablaMostrarEmpleados = document.getElementById("mostrar");

  // clean all table values for each row
  tablaMostrarEmpleados.innerHTML = "";

  fetch("http://localhost:3000/empleados")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((element) => {
        tablaMostrarEmpleados.innerHTML += `
          <tr>
              <td>${element.rut_colaborador}</td>
              <td>${element.nombre_colaborador}</td>
              <td>${element.apellido_colaborador}</td>
              <td>${element.telefono_colaborador}</td>
              <td>${element.correo_electronico}</td>
              <td>${element.contraseña}</td>
          </tr>
          `;
      });
    });
};
//actualizar
recargarDatosEmpleados();

formActualizar.addEventListener("submit", (event) => {
  event.preventDefault();
  const rut = document.getElementById("rut_actualizar").value;
  const nombre_colaborador = document.getElementById("nombre_actualizar").value;
  const apellido_colaborador = document.getElementById(
    "apellido_actualizar"
  ).value;
  const correo_colaborador = document.getElementById("correo_actualizar").value;
  const telefono_colaborador = document.getElementById(
    "telefono_actualizar"
  ).value;
  const correo_electronico = document.getElementById("correo_actualizar").value;
  const contraseña = document.getElementById("contraseña_actualizar").value;
  const cargo = document.getElementById("cargos_update").value;
  const lista = {
    nombre_colaborador: nombre_colaborador,
    apellido_colaborador: apellido_colaborador,
    correo_colaborador: correo_colaborador,
    telefono_colaborador: telefono_colaborador,
    correo_electronico: correo_electronico,
    contraseña: contraseña,
    cargo: cargo,
  };
  const listaJson = JSON.stringify(lista);
  console.log(listaJson);
  console.log(rut);

  // send data to backend
  fetch(`http://localhost:3000/empleados/${rut}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
    body: listaJson,
  })
    .then((response) => response.json())
    // .then(window.location.reload())
    .catch((error) => console.log(error));
});

formEliminar.addEventListener("submit", (event) => {
  event.preventDefault();
  const rut = document.getElementById("rut_eliminar").value;

  // send data to backend
  fetch(`http://localhost:3000/empleados/${rut}`, {
    method: "DELETE",
  })
    .then((response) => response.json())
    .then(window.location.reload())
    .catch((error) => console.log("ERROR: ", error));
});
