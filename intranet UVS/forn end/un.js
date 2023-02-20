try {
    const {rut_colaborador, nombre_colaborador, apellido_colaborador, telefono_colaborador, correo_electronico, contraseña} = req.body
const [rows] = await pool.query('INSERT INTO colaborador (rut_colaborador, nombre_colaborador, apellido_colaborador, telefono_colaborador, correo_electronico, contraseña) VALUES (?, ?, ?, ?, ?, ?)', [rut_colaborador, nombre_colaborador, apellido_colaborador, telefono_colaborador, correo_electronico, contraseña])
res.send({
    nombre_colaborador,
    apellido_colaborador,
    telefono_colaborador,
    correo_electronico,
    contraseña
})
} catch (error) {
    return res.status(500).json({
        message: 'Algo ha salido mal'
    })        
}
