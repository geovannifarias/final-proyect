const formLogin = document.getElementById("form_login");

formLogin.addEventListener("submit", (event) => {
  event.preventDefault();
  const rut_colaborador = document.getElementById("rut_colaborador").value;
  const contraseña = document.getElementById("password").value;
  const lista = {
    rut_colaborador: rut_colaborador,
    contraseña: contraseña,
  };
  const listaJson = JSON.stringify(lista);
  fetch("http://localhost:3000/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: listaJson,
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data === 1) {
        window.location.href = "./gerente.html";
      } else if (data === 2) {
        window.location.href = "./index.html";
      } else if (data === 3) {
        window.location.href = "./operario.html";
      } else {
        alert("Usuario o contraseña incorrectos");
      }
    })
    .catch((error) => console.log(error));
});
